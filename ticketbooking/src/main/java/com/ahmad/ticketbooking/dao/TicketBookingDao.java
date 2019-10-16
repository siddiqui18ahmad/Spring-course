package com.ahmad.ticketbooking.dao;

import com.ahmad.ticketbooking.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}

