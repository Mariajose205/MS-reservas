package com.fitlife.reservation.dto;

import java.time.LocalDateTime;

public class ReservaResponse {
    
    private Long idReserva;
    private Long idUsuario;
    private Long idHorario;
    private String estado;
    private LocalDateTime fechaCreacion;
    
    public ReservaResponse() {}
    
    public ReservaResponse(Long idReserva, Long idUsuario, Long idHorario, String estado, LocalDateTime fechaCreacion) {
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
}
