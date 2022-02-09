package edu.pja.mas.s19183.mas.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Ticket number is mandatory")
    @Size(min = 2, max = 64)
    private String ticketNumber;

    @Min(0)
    private double cost;

    @ManyToOne
    @JoinColumn(name = "passsengerroute_id", nullable = false)
    @NotNull
    @EqualsAndHashCode.Exclude
    private PassengerRoute soldTickets;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    @NotNull
    private Passenger hasTicket;
}
