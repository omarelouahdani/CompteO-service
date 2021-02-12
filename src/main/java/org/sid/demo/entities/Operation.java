package org.sid.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;
    private Date date;
    private double montant;
    private String type;
    @JsonIgnore
    @ManyToOne
    private Compte compte;
}
