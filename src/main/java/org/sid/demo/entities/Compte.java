package org.sid.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Compte {
    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private double solde;
    private Date dateCreation;
    private String type;
    private String etat;
    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

}
