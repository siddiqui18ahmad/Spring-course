package com.ahmad.ticketbooking.service;

import com.ahmad.ticketbooking.dao.TicketBookingDao;
import com.ahmad.ticketbooking.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingDao ticketBookingDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketBookingDao.save(ticket);
    }
    public Ticket getTicketById(Integer ticketId) {
        return ticketBookingDao.findOne(ticketId);
    }
    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingDao.findAll();
    }
    public void deleteTicket(Integer ticketId) {
        ticketBookingDao.delete(ticketId);
    }
    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Ticket ticketFromDb = ticketBookingDao.findOne(ticketId);
        ticketFromDb.setEmail(newEmail);
        Ticket upadedTicket;
        upadedTicket = ticketBookingDao.save(ticketFromDb);
        return upadedTicket;
    }
}
