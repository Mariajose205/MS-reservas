package com.fitlife.reservation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "clase")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long idClase;
    
    @Column(name = "id_entrenador", nullable = false)
    private Long idEntrenador;
    
    @Column(name = "id_gimnasio", nullable = false)
    private Long idGimnasio;
    
    @Column(name = "nombre_clase", nullable = false, length = 100)
    private String nombreClase;
    
    @Column(name = "cupos_maximos", nullable = false)
    private Integer cuposMaximos;
}
