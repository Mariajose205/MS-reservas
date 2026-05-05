package com.fitlife.reservation.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;
    
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
    
    @Column(name = "id_horario", nullable = false)
    private Long idHorario;
    
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    public Reserva() {}
    
    public Reserva(Long idReserva, Long idUsuario, Long idHorario, String estado, LocalDateTime fechaCreacion) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idHorario = idHorario;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
    
    public Long getIdReserva() {
        return idReserva;
    }
    
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Long getIdHorario() {
        return idHorario;
    }
    
    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        if (estado == null) {
            estado = "ACTIVA";
        }
    }
}
