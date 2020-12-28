package com.ucad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Evaluation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private String numeroEtudiant;
    private String nomMatiere;
    private  double note;
}
