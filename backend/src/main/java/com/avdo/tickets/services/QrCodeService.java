package com.avdo.tickets.services;

import com.avdo.tickets.domain.entities.QrCode;
import com.avdo.tickets.domain.entities.Ticket;
import java.util.UUID;

public interface QrCodeService {

  QrCode generateQrCode(Ticket ticket);

  byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}

