package com.amica.help;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class representing a problem ticket for a help desk.
 *
 * @author Will Provost
 */
@Getter
@EqualsAndHashCode(of="ID")
public class Ticket implements Comparable<Ticket> {

    public enum Status { CREATED, ASSIGNED, RESOLVED }
    public enum Priority { LOW, MEDIUM, HIGH, URGENT }

    private static int nextID = 0;

    private int ID;
    private Status status;
    private Priority priority;
    private String originator;
    private String description;
    private Technician technician;
    private List<Event> history = new ArrayList<>();
    private SortedSet<Tag> tags = new TreeSet<>();

    public Ticket(String originator, String description, Priority priority) {
        this.ID = ++nextID;
        this.status= Status.CREATED;
        this.priority = priority;
        this.originator = originator;
        this.description = description;
        this.history.add(new Event(status, "Created ticket."));
    }

    public Stream<Event> getHistory() {
    	return history.stream();
    }

    public Stream<Tag> getTags() {
    	return tags.stream();
    }
    
    public void assign(Technician technician) {
        if (status != Status.RESOLVED) {
            this.technician = technician;
            status = Status.ASSIGNED;
            history.add(new Event(status, "Assigned to " + technician + "."));
            technician.getActiveTickets().add(this);
        } else {
            throw new IllegalStateException("Can't re-assign a resolved new ticket.");
        }
    }
    
    public void addNote(String note) {
    	history.add(new Event(note));
    }

    public void resolve(String note) {
        if (status == Status.ASSIGNED) {
            status = Status.RESOLVED;
            history.add(new Event(status, note));
            technician.getActiveTickets().remove(this);
        } else {
        	throw new IllegalStateException("Can't resolve a resolved ticket.");
        }
    }

    public void addTags(String... tagValues) {
		for (String tagValue : tagValues) {
			tags.add(Tag.getTag(tagValue));
		}
    }

    public int getMinutesToResolve() {
    	final int MILLISECONDS_PER_MINUTE = 60000;
        if (status == Status.RESOLVED) {
        	long time = history.get(history.size() - 1).getTimestamp() -
        			history.get(0).getTimestamp();
        	return (int) time / MILLISECONDS_PER_MINUTE;
        } else {
        	throw new IllegalStateException("The ticket is not yet resolved.");
        }
    }
    
    public boolean includesText(String text) {
		return description.contains(text) ||
				getHistory().anyMatch(e -> e.getNote().contains(text));
    }
    
    @Override
    public String toString() {
    	return String.format("Ticket %d: %s priority, %s", 
    			ID, priority.toString(), status.toString());
    }
    
    public int compareTo(Ticket other) {
    	if (this.equals(other)) {
    		return 0;
    	}
    	
    	int result = -priority.compareTo(other.getPriority());
    	if (result == 0) {
    		result = Integer.compare(ID, other.getID());
    	}
    	return result;
    }
}
