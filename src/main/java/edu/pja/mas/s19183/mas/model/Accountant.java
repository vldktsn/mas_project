package edu.pja.mas.s19183.mas.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Accountant extends Worker{

    @Min(0)
    private int soldTickets;

}
