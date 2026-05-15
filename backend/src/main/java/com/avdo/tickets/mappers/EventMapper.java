package com.avdo.tickets.mappers;

import com.avdo.tickets.domain.CreateEventRequest;
import com.avdo.tickets.domain.CreateTicketTypeRequest;
import com.avdo.tickets.domain.UpdateEventRequest;
import com.avdo.tickets.domain.UpdateTicketTypeRequest;
import com.avdo.tickets.domain.dtos.CreateEventRequestDto;
import com.avdo.tickets.domain.dtos.CreateEventResponseDto;
import com.avdo.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.avdo.tickets.domain.dtos.GetEventDetailsResponseDto;
import com.avdo.tickets.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import com.avdo.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.avdo.tickets.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import com.avdo.tickets.domain.dtos.ListEventResponseDto;
import com.avdo.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.avdo.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.avdo.tickets.domain.dtos.UpdateEventRequestDto;
import com.avdo.tickets.domain.dtos.UpdateEventResponseDto;
import com.avdo.tickets.domain.dtos.UpdateTicketTypeRequestDto;
import com.avdo.tickets.domain.dtos.UpdateTicketTypeResponseDto;
import com.avdo.tickets.domain.entities.Event;
import com.avdo.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

  ListEventTicketTypeResponseDto toDto(TicketType ticketType);

  ListEventResponseDto toListEventResponseDto(Event event);

  GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

  UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

  UpdateEventRequest fromDto(UpdateEventRequestDto dto);

  UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

  UpdateEventResponseDto toUpdateEventResponseDto(Event event);

  ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

  GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);
}

