package com.picoplaca.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "restriccion")
@Data
public class Restriccion implements Serializable{

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private int ultimoDigito;

    private String diaSemana;

    private LocalTime startTimeMorning;
    private LocalTime endTimeMorning;

    private LocalTime startTimeAfternoon;
    private LocalTime endTimeAfternoon;
    
	

    // Getters and Setters
}

	
