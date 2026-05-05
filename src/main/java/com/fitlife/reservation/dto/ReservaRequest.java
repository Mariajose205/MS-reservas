package com.fitlife.reservation.dto;

import jakarta.validation.constraints.NotNull;

public class ReservaRequest {
    
    @NotNull(message = "El ID del usuario es obligatorio")
    private Long idUsuario;
    
    @NotNull(message = "El ID del horario es obligatorio")
    private Long idHorario;
    
    @NotNull(message = "El estado es obligatorio")
    private String estado;
    
    public ReservaRequest() {}
    
    public ReservaRequest(Long idUsuario, Long idHorario, String estado) {
        this.idUsuario = idUsuario;
        this.idHorario = idHorario;
        this.estado = estado;
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
}
