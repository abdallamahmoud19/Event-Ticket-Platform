package com.avdo.tickets.services;

import com.avdo.tickets.domain.CreateEventRequest;
import com.avdo.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest eventRequest);
}
