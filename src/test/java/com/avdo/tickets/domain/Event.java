package com.avdo.tickets.domain;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="start", nullable = false)
    private LocalDateTime start;

    @Column(name="end", nullable = false)   
    private LocalDateTime end;

    @Column(name="venue", nullable = false)
    private String venue;

    @Column(name="sales_start", nullable = true)   
    private LocalDateTime salesStart;

    @Column(name="sales_end", nullable = true)   
    private LocalDateTime salesEnd;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatusEnum status;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "organizer_id", nullable = false)    
    private User organizer;


    @ManyToMany(mappedBy="attendingEvents")   
    private List<User> attendees = new ArrayList<>();

    @ManyToMany(mappedBy="staffedEvents")
    private List<User> staff = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
