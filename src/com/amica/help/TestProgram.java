package com.amica.help;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import com.amica.help.Ticket.Priority;
import com.amica.help.Ticket.Status;

public class TestProgram {
	
	public static HelpDeskAPI helpDesk = new HelpDesk();

	public static void runSimulation() {
		
		Tag.addSynonym("RDP", "remoting");
		Tag.addSynonym("remote desktop", "remoting");
		Tag.addCapitalization("CMA");
		Tag.addCapitalization("GitHub");
		Tag.addCapitalization("VM");
		Tag.addCapitalization("VPN");
		
		helpDesk.addTechnician("A05589", "Andree", 55491);
		helpDesk.addTechnician("A12312", "Boris", 12399);
		helpDesk.addTechnician("A17440", "Caelem", 34002);
		helpDesk.addTechnician("A20265", "Dineh", 60709);

		Clock.setTime("11/1/21 8:22");
		helpDesk.createTicket("A21013", "Unable to log in.", Priority.HIGH);
		Clock.setTime("11/1/21 8:23");
		helpDesk.getTicketByID(1).addTags("remoting");
		Clock.setTime("11/1/21 8:33");
		helpDesk.createTicket("A19556", "Can't connect to remote desktop from my laptop.", Priority.HIGH);
		Clock.setTime("11/1/21 8:34");
		helpDesk.getTicketByID(2).addTags("remoting", "laptop");
		Clock.setTime("11/1/21 8:36");
		helpDesk.getTicketByID(2).addNote("Checking if the user can connect from other machines.");
		Clock.setTime("11/1/21 8:37");
		helpDesk.createTicket("A05989", "Need GitHub access.", Priority.MEDIUM);
		Clock.setTime("11/1/21 8:38");
		helpDesk.getTicketByID(3).addTags("permissions", "GitHub");
		Clock.setTime("11/1/21 8:39");
		helpDesk.getTicketByID(3).addNote("Requested approval from manager.");
		Clock.setTime("11/1/21 9:05");
		helpDesk.createTicket("T17549", "Can't use just one screen for remote desktop.", Priority.MEDIUM);
		Clock.setTime("11/1/21 9:06");
		helpDesk.getTicketByID(4).addTags("remote desktop");
		Clock.setTime("11/1/21 9:07");
		helpDesk.getTicketByID(4).resolve("Explained that this is not a feature we support right now.");
		Clock.setTime("11/1/21 9:48");
		helpDesk.getTicketByID(1).addNote("Determined that it's a VPN problem rather than RDP.");
		Clock.setTime("11/1/21 9:51");
		helpDesk.getTicketByID(1).addNote("Recommended that the user update their browser.");
		Clock.setTime("11/1/21 9:52");
		helpDesk.getTicketByID(1).addTags("VPN");
		Clock.setTime("11/1/21 14:11");
		helpDesk.createTicket("A24490", "Files on my user drive are currupt.", Priority.HIGH);
		Clock.setTime("11/1/21 14:12");
		helpDesk.getTicketByID(5).addTags("VM");
		Clock.setTime("11/1/21 14:14");
		helpDesk.getTicketByID(2).addNote("User: Yes, I can connect from other desktop machines at Amica.");
		Clock.setTime("11/1/21 14:17");
		helpDesk.getTicketByID(5).addNote("Requested examples of corrupt files.");
		Clock.setTime("11/1/21 16:39");
		helpDesk.createTicket("T24090", "Need CMA access.", Priority.MEDIUM);
		Clock.setTime("11/1/21 16:41");
		helpDesk.getTicketByID(6).addTags("Permissions", "CMA");
		Clock.setTime("11/1/21 16:42");
		helpDesk.getTicketByID(6).addNote("Requested approval from manager.");
		
		Clock.setTime("11/2/21 8:11");
		helpDesk.createTicket("A15711", "Laptop won't start up.", Priority.URGENT);
		Clock.setTime("11/2/21 8:12");
		helpDesk.getTicketByID(7).addTags("laptop");
		Clock.setTime("11/2/21 8:45");
		helpDesk.getTicketByID(6).resolve("Received approval; added permission.");
		Clock.setTime("11/2/21 8:52");
		helpDesk.createTicket("A20271", "Can't login.", Priority.HIGH);
		Clock.setTime("11/2/21 8:53");
		helpDesk.getTicketByID(8).addTags("remoting");
		Clock.setTime("11/2/21 10:19");
		helpDesk.createTicket("T13370", "Need to reset MobilePass.", Priority.HIGH);
		Clock.setTime("11/2/21 10:20");
		helpDesk.getTicketByID(3).resolve("Received approval; added permission.");
		Clock.setTime("11/2/21 10:21");
		helpDesk.getTicketByID(9).addTags("vpn");
		Clock.setTime("11/2/21 10:22");
		helpDesk.getTicketByID(9).addNote("Tried to contact user; left voice mail.");
		Clock.setTime("11/2/21 11:00");
		helpDesk.createTicket("A14401", "Unable to log in.", Priority.HIGH);
		Clock.setTime("11/2/21 11:01");
		helpDesk.getTicketByID(10).addTags("RDP");
		Clock.setTime("11/2/21 11:32");
		helpDesk.createTicket("T11918", "No disk space left! I don't have that much stuff on here; not sure what's taking up all the space.", Priority.URGENT);
		Clock.setTime("11/2/21 11:33");
		helpDesk.getTicketByID(11).addTags("vm");
		Clock.setTime("11/2/21 14:49");
		helpDesk.getTicketByID(1).resolve("User reports that the browser update fixed it.");
		
		Clock.setTime("11/3/21 9:22");
		helpDesk.createTicket("A13288", "Need GitHub access.", Priority.MEDIUM);
		Clock.setTime("11/3/21 9:23");
		helpDesk.getTicketByID(12).addTags("permissions", "github");
		Clock.setTime("11/3/21 9:24");
		helpDesk.getTicketByID(12).addNote("Requested approval from manager.");
		Clock.setTime("11/3/21 11:11");
		helpDesk.createTicket("A22465", "Laptop audio seems to be broken.", Priority.MEDIUM);
		Clock.setTime("11/3/21 11:12");
		helpDesk.getTicketByID(13).addTags("laptop", "audio");
		Clock.setTime("11/3/21 11:39");
		helpDesk.createTicket("A18087", "Can't log in.", Priority.HIGH);
		Clock.setTime("11/3/21 11:40");
		helpDesk.getTicketByID(14).addTags("remote desktop");
		Clock.setTime("11/3/21 13:11");
		helpDesk.getTicketByID(10).resolve("Opened remote access to RI150WS3344; confirmed user can connect.");
		Clock.setTime("11/3/21 13:16");
		helpDesk.getTicketByID(5).addNote("User: See /Users/A10551/Projects/Spec_20211015.pdf.");
		Clock.setTime("11/3/21 13:17");
		helpDesk.getTicketByID(5).addNote("Building a new VM.");
		Clock.setTime("11/3/21 13:18");
		helpDesk.getTicketByID(5).resolve("Migrated most files to new VM, restored remaining files from backups, switched IP address over.");
		Clock.setTime("11/3/21 13:19");
		helpDesk.getTicketByID(11).resolve("Found user's ME2020 Maven cache way overloaded, recommended cleaning it out.");
	}
	
	public static void assertThat(boolean condition, String error) {
		if (!condition) {
			System.out.println("    ASSERTION FAILED: " + error);
		}
	}

	public static void assertEqual(Object actual, Object expected, String error) {
		if (!actual.equals(expected)) {
			System.out.format("    ASSERTION FAILED: " + error + "%n", actual);
		}
	}

	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * All of the test logic uses the {@link HelpDeskAPI} and so is pre-written.
	 * <ul>
	 *   <li>We can find a ticket by ID.</li>
	 *   <li>IDs are a generated sequence starting at 1.</li>
	 *   <li>We can find all tickets in a given status.</li>
	 *   <li>We can find all tickets not in a given status.</li>
	 *   <li>Tickets are automatically assigned after being created.</li>
	 *   <li>Tickets show the RESOLVED status after being resolved.</li>
	 * </ul>
	 */
	public static void test1_Tickets() {
		System.out.println("Running test 1, tickets ...");
		
		assertThat(helpDesk.getTicketByID(0) == null, "There shouldn't be a ticket 0.");
		assertThat(helpDesk.getTicketByID(1) != null, "There should be a ticket 1.");
		assertThat(helpDesk.getTicketByID(14) != null, "There should be a ticket 14.");
		 
		assertThat(helpDesk.getTicketsByStatus(Status.CREATED).count() == 0,
				"There shuldn't be any tickets in the CREATED state.");
		assertThat(helpDesk.getTicketsByStatus(Status.RESOLVED).count() == 7,
				"There shuld be 7 tickets in the RESOLVED state.");
		 
		System.out.println();
	}
	
	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * You will have to fill out the test logic yourself, based on your
	 * design, class names, method names, etc.
	 * <ul>
	 *   <li>We can't re-assign a resolved ticket.</li>
	 *   <li>Each ticket has a history that includes events for assignment and 
	 *       resolution, with timestamps taken from the {@link Clock}.</li>
	 *   <li>Notes added to the ticket appear in the event history as well.</li>
	 * </ul>
	 */
	public static void test2_History() {
		System.out.println("Running test 2, history ...");
		 
		Iterator<Event> history = helpDesk.getTicketByID(4).getHistory().iterator();
		Event created4 = history.next();
		assertEqual(Clock.format(created4.getTimestamp()), "11/1/21 9:05", 
				"Ticket 4 should have been created at 9:05, was %s.");
		assertEqual(created4.getNewStatus(), Status.CREATED, 
				"Ticket 4's first event should be CREATED, was %s.");
		assertEqual(created4.getNote(), "Created ticket.", 
				"Ticket 4 creation note is wrong: %s.");
		Event assigned4 = history.next();
		assertEqual(Clock.format(assigned4.getTimestamp()), "11/1/21 9:05", 
				"Ticket 4 should have been assigned at 9:05, was %s.");
		assertEqual(assigned4.getNewStatus(), Status.ASSIGNED, 
				"Ticket 4's second event should be ASSIGNED, was %s.");
		assertEqual(assigned4.getNote(), "Assigned to Technician A20265, Dineh.", 
				"Ticket 4 assignment note is wrong: %s.");
		Event resolved4 = history.next();
		assertEqual(Clock.format(resolved4.getTimestamp()), "11/1/21 9:07", 
				"Ticket 4 should have been resolved at 9:07, was %s.");
		assertEqual(resolved4.getNewStatus(), Status.RESOLVED, 
				"Ticket 4's second event should be RESOLVED, was %s.");
		assertEqual(resolved4.getNote(), "Explained that this is not a feature we support right now.", 
				"Ticket 4 resolution note is wrong: %s.");
		
		history = helpDesk.getTicketByID(2).getHistory().iterator();
		history.next();
		history.next();
		history.next();
		Event note7 = history.next();
		assertEqual(Clock.format(note7.getTimestamp()), "11/1/21 14:14", 
				"Ticket 2's 2nd note should be stamped 14:14, was %s.");
		assertThat(note7.getNewStatus() == null, 
				"Ticket 2's second note status should be null, was " + 
		note7.getNewStatus() + ".");
		assertEqual(note7.getNote(), "User: Yes, I can connect from other desktop machines at Amica.", 
				"Ticket 2's 2nd note is wrong: %s.");
		
		
		 System.out.println();
	}
	
	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * Some of this is pre-written, and you will have to develop the rest.
	 * <ul>
	 *   <li>We can find all tickets assigned to a given technician.</li>
	 *   <li>Tickets are always assigned to the technician with the fewest
	 *       active (i.e. unresolved) tickets.</li>
	 *   <li>Tickets are sorted from highest priority to lowest, 
	 *       in the master data set and for each technician.</li>
	 * </ul>
	 */
	public static void test3_Assignment() {
		System.out.println("Running test 3, assignment ...");
		 
		assertEqual(helpDesk.getTicketsByTechnician("A05589").count(), 5L, 
				"Andree should have been assigned 5 tickets, but has %s.");
		assertEqual(helpDesk.getTicketsByTechnician("A12312").count(), 3L, 
				"Boris should have been assigned 3 tickets, but has %s.");
		assertEqual(helpDesk.getTicketsByTechnician("A17440").count(), 3L, 
				"Caelem should have been assigned 3 tickets, but has %s.");
		assertEqual(helpDesk.getTicketsByTechnician("A20265").count(), 3L, 
				"Dineh should have been assigned 3 tickets, but has %s.");
		
		Iterator<Ticket> tickets = ((HelpDesk) helpDesk).getTickets().iterator();
		assertEqual(tickets.next().getID(), 7, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 11, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 1, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 2, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 5, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 8, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 9, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 10, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 14, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 3, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 4, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 6, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 12, "Out of sequence in master set: %s");
		assertEqual(tickets.next().getID(), 13, "Out of sequence in master set: %s");
		
		Iterator<Technician> techs = ((HelpDesk) helpDesk).getTechnicians().iterator();
		
		Collection<Ticket> forTech = techs.next().getActiveTickets(); 
		assertEqual(forTech.size(), 3, "Andree should have 3 active tickets, was %s");
		tickets = forTech.iterator();
		assertEqual(tickets.next().getID(), 8, "Out of sequence for Andree: %s");
		assertEqual(tickets.next().getID(), 12, "Out of sequence for Andree: %s");
		assertEqual(tickets.next().getID(), 13, "Out of sequence for Andree: %s");
		
		forTech = techs.next().getActiveTickets(); 
		assertEqual(forTech.size(), 3, "Boris should have 3 active tickets, was %s");
		tickets = forTech.iterator();
		assertEqual(tickets.next().getID(), 7, "Out of sequence for Boris: %s");
		assertEqual(tickets.next().getID(), 2, "Out of sequence for Boris: %s");
		assertEqual(tickets.next().getID(), 14, "Out of sequence for Boris: %s");
		
		forTech = techs.next().getActiveTickets(); 
		assertEqual(forTech.size(), 1, "Caelem should have 1 active tickets, was %s");
		tickets = forTech.iterator();
		assertEqual(tickets.next().getID(), 9, "Out of sequence for Caelem: %s");
		
		forTech = techs.next().getActiveTickets(); 
		assertEqual(forTech.size(), 0, "Dineh should have 0 active tickets, was %s");

		
		 System.out.println();
	}

	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * You will have to fill out the test logic yourself, based on your
	 * design, class names, method names, etc.
	 * <ul>
	 *   <li>We can tag tickets and find them by tags.</li>
	 *   <li>A ticket will only appear once in these results, even if 
	 *       it has multiple requested tags.</li>
	 *   <li>Tags are considered equal on a case-insensitive basis.</li>
	 * </ul>
	 */
	public static void test4_Tags() {
		System.out.println("Running test 4, tags ...");
		
		Tag laptop = Tag.getTag("laptop");
		assertEqual(helpDesk.getTicketsWithAnyTag(laptop).count(), 3L, 
				"There should be 3 tickets with the 'laptop' tag, was %s.");

		Tag VM = Tag.getTag("VM");
		assertEqual(helpDesk.getTicketsWithAnyTag(VM).count(), 2L, 
				"There should be 2 tickets with the 'vm' tag, was %s.");
		
		Tag permissions = Tag.getTag("permissions");
		Tag CMA = Tag.getTag("CMA");
		assertEqual(helpDesk.getTicketsWithAnyTag(permissions, CMA).count(), 3L, 
				"There should be 2 tickets with the 'permissions' and/or 'CMA' tags, was %s.");
		
		System.out.println();
	}
	
	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * All of the test logic uses the {@link HelpDeskAPI} and so is pre-written.
	 * <ul>
	 *   <li>We can correctly calculate our average time to resolve a ticket.</li>
	 *   <li>We can also see the average time per technician.</li>
	 * </ul>
	 */
	public static void test5_TimeToResolve() {
		System.out.println("Running test 5, time to resolve ...");
		
		int minutes = helpDesk.getAverageMinutesToResolve();
		int hours = minutes / 60;
		minutes %= 60;
		assertEqual(hours, 24, "Average hours to resolve should be 24, was %s.");
		assertEqual(minutes, 29, "Average minutes to resolve should be 29, was %s.");
		
		Map<String,Double> byTech = helpDesk.getAverageMinutesToResolvePerTechnician();
		assertEqual(byTech.get("A05589").intValue(), 1396, 
				"Andree's average should be 1396, was %s.");
		assertThat(!byTech.containsKey("A12312"), 
				"Boris shouldn't have an average time to resolve.");
		assertEqual(byTech.get("A17440").intValue(), 1557, 
				"Caelem average should be 1557, was %s.");
		assertEqual(byTech.get("A20265").intValue(), 1458, 
				"Dineh's average should be 1458, was %s.");
		
		System.out.println();
	}
	
	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * All of the test logic uses the {@link HelpDeskAPI} and so is pre-written.
	 * <ul>
	 *   <li>We can find tickets whose descriptions or notes include a given substring.</li>
	 * </ul>
	 */
	public static void test6_TextSearch() {
		System.out.println("Running test 6, text search ...");

		Stream<Ticket> tickets = helpDesk.getTicketsByText("corrupt");
		assertEqual(tickets.count(), 1L, 
				"There should be one ticket with the text 'corrupt', was %s.");
		
		tickets = helpDesk.getTicketsByText("browser");
		assertEqual(tickets.count(), 1L, 
				"There should be one ticket with the text 'browser', was %s.");
		
		System.out.println();
	}
	
	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * Some of this is pre-written, and you will have to develop the rest.
	 * <ul>
	 *   <li>We can reopen a resolved ticket, with a new reason and priority.</li>
	 *   <li>We can't reopen an un-resolved ticket.</li>
	 *   <li>Reopened tickets take on the originator of the prior ticket,
	 *       and are assigned to the original technician.</li>
	 *   <li>Reopened tickets compile their own history and that of the prior ticket.</li>
	 *   <li>Reopened tickets compile their own tags and those of the prior ticket.</li>
	 *   <li>Reopened tags search their own and the prior ticket's text.</li>
	 */
	public static void test7_ReopenedTickets() {
		System.out.println("Running test 7, reopened tickets ...");

		Clock.setTime("11/3/21 14:01");
		helpDesk.reopenTicket(6, "Still can't connect.", Priority.MEDIUM);
		Clock.setTime("11/3/21 14:12");
		helpDesk.reopenTicket(3, "Still can't log in.", Priority.HIGH);
		Clock.setTime("11/3/21 14:59");
		helpDesk.getTicketByID(3).addTags("VPN");
		
		Stream<Event> originalHistory = helpDesk.getTicketByID(6).getHistory();
		Stream<Event> reopenedHistory = helpDesk.getTicketByID(15).getHistory();
		long expectedSize = originalHistory.count() + 2;
		long actualSize = reopenedHistory.count(); 
		assertEqual(actualSize, expectedSize, "Reopened ticket should have " + 
				expectedSize + " events, was %s");
		
		assertThat(helpDesk.getTicketsWithAnyTag(Tag.getTag("GitHub"))
				.mapToInt(Ticket::getID).anyMatch(ID -> ID == 16),
					"Reopened ticket not found by prior ticket's tag;");
		assertThat(helpDesk.getTicketsWithAnyTag(Tag.getTag("VPN"))
				.mapToInt(Ticket::getID).anyMatch(ID -> ID == 16),
					"Reopened ticket not found by its own tag;");
			
		Stream<Ticket> tickets = helpDesk.getTicketsByText("access");
		assertThat(tickets.mapToInt(Ticket::getID).anyMatch(ID -> ID == 15),
				"Reopened ticked should be found by original description.");
		
		System.out.println();
	}
	
	/**
	 * This method tests that the ijmplementation meets the following requirements.
	 * You will have to fill out the test logic yourself, based on your
	 * design, class names, method names, etc.
	 * <ul>
	 *   <li>We can pre-define synonyms for tags, and see them consolidated
	 *       to a chosen master tag.</li>
	 *   <li>We can pre-define preferred capitalization for tags,
	 *       instead of having everything pushed to lower case.</li>
	 * </ul>
	 * This test relies on additional setup, to be performed in the 
	 * {@link #runSimulation runSimulation} method, before creating and tagging
	 * tickets:
	 * <ul>
	 *   <li>Create synonyms for "remoting": "RDP" and "remote desktop".</li>
	 *   <li>Pre-set the following capitalizations: "VM", "VPN", "CMA", and "GitHub".</li>
	 * </ul>
	 */
	public static void test8_Synonyms() {
		System.out.println("Running test 8, synonyms ...");

		Tag remoting = Tag.getTag("remoting");
		assertEqual(helpDesk.getTicketsWithAnyTag(remoting).count(), 6L, 
				"There should be 6 tickets with the 'remoting' tag, was %s.");
		
		assertEqual(Tag.getTag("github").getValue(), "GitHub",
				"The tag capitalization GitHub should be used, was %s");
		
		Iterator<Tag> tags = Tag.getTags().iterator();
		assertEqual(tags.next().getValue(), "audio", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "CMA", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "GitHub", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "laptop", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "permissions", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "remoting", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "VM", "Unexpected tag: %s.");
		assertEqual(tags.next().getValue(), "VPN", "Unexpected tag: %s.");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		runSimulation();
		test1_Tickets();
		test2_History();
		test3_Assignment();
		test4_Tags();
		test5_TimeToResolve();
		test6_TextSearch();
		test7_ReopenedTickets();
		test8_Synonyms();
	}
}
