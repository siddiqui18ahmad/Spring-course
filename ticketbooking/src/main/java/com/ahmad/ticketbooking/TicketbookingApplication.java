package com.ahmad.ticketbooking;

import com.ahmad.ticketbooking.model.Ticket;
import com.ahmad.ticketbooking.service.TicketBookingService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class TicketbookingApplication implements CommandLineRunner {

    @Autowired
    private TicketBookingService ticketBookingService;

    public static void main(String[] args) {
        SpringApplication.run(TicketbookingApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Ticket ticket = new Ticket();
        ticket.setBookingDate(new Date());
        ticket.setDestStation("Mumbai");
        ticket.setSourceStation("Pune");
        ticket.setPassengerName("KK");
        ticket.setEmail("kk@yahoo.com");

        ticketBookingService.createTicket(ticket);
    }
}
