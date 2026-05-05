package com.fitlife.reservation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "gimnasio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gimnasio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gimnasio")
    private Long idGimnasio;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;
    
    @Column(name = "comuna", nullable = false, length = 100)
    private String comuna;
    
    @Column(name = "coordenadas_gps", length = 100)
    private String coordenadasGps;
}
