package com.amica.help;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.amica.help.Ticket.Priority;
import com.amica.help.Ticket.Status;

public class HelpDesk implements HelpDeskAPI {

	private SortedSet<Technician> technicians = new TreeSet<>();
	private SortedSet<Ticket> tickets = new TreeSet<>();
	
	public void addTechnician(String ID, String name, int extension) {
		technicians.add(new Technician(ID, name, extension));		
	}
	
	public int createTicket(String originator, String description, Priority priority) {
		if (technicians.isEmpty()) {
			throw new IllegalStateException("No technicians available yet.");
		}
		Ticket ticket = new Ticket(originator, description, priority);
		tickets.add(ticket);
		ticket.assign(technicians.stream()
				.min((a,b) -> Integer.compare
						(a.getActiveTickets().size(), b.getActiveTickets().size()))
				.get());
		return ticket.getID();
	}
	
	public SortedSet<Technician> getTechnicians() {
		return technicians;
	}
	
	public int reopenTicket(int priorTicketID, String reason, Priority priority) {
		if (technicians.isEmpty()) {
			throw new IllegalStateException("No technicians available yet.");
		}
		Ticket ticket = new ReopenedTicket
				(getTicketByID(priorTicketID), reason, priority);
		tickets.add(ticket);
		return ticket.getID();
	}
	
	public Stream<Ticket> getTickets() {
		return tickets.stream();
	}
	
	public Ticket getTicketByID(int ID) {
		return tickets.stream()
				.filter(t -> t.getID() == ID)
				.findFirst()
				.orElse(null);
	}
	
	public Stream<Ticket> getTicketsByStatus(Status status) {
		return tickets.stream()
				.filter(t -> t.getStatus() == status);
	}
	
	public Stream<Ticket> getTicketsByNotStatus(Status status) {
		return tickets.stream()
				.filter(t -> t.getStatus() != status);
	}
	
	public Stream<Ticket> getTicketsByTechnician(String techID) {
		return tickets.stream()
				.filter(t -> t.getTechnician().getID().equals(techID));
	}

	public Stream<Ticket> getTicketsWithAnyTag(Tag... tags) {
		return tickets.stream()
				.filter(ticket -> ticket.getTags().anyMatch
					(candidate -> Arrays.stream(tags).anyMatch
							(tag -> tag.equals(candidate))));
	}

	public int getAverageMinutesToResolve() {
		return (int) getTicketsByStatus(Status.RESOLVED)
				.mapToInt(Ticket::getMinutesToResolve).average().getAsDouble();
	}

	public Map<String, Double> getAverageMinutesToResolvePerTechnician() {
		return getTicketsByStatus(Status.RESOLVED)
				.collect(Collectors.groupingBy(t -> t.getTechnician().getID(),
						Collectors.averagingInt(Ticket::getMinutesToResolve)));
	}		

	public Stream<Ticket> getTicketsByText(String text) {
		return tickets.stream().filter(t -> t.includesText(text));
	}
}
