package com.fitlife.reservation.service;

import com.fitlife.reservation.dto.ReservaRequest;
import com.fitlife.reservation.dto.ReservaResponse;
import com.fitlife.reservation.entity.Reserva;
import com.fitlife.reservation.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservaService {

    private final ReservaRepository reservaRepository;
    
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public ReservaResponse createReserva(ReservaRequest request) {
        // Verificar si ya existe una reserva para el mismo usuario y horario
        Optional<Reserva> existingReserva = reservaRepository.findByIdUsuarioAndIdHorario(
            request.getIdUsuario(), request.getIdHorario());
        
        if (existingReserva.isPresent()) {
            throw new RuntimeException("Ya existe una reserva para este usuario y horario");
        }

        Reserva reserva = new Reserva();
        reserva.setIdUsuario(request.getIdUsuario());
        reserva.setIdHorario(request.getIdHorario());
        reserva.setEstado(request.getEstado());
        reserva.setFechaCreacion(LocalDateTime.now());

        Reserva savedReserva = reservaRepository.save(reserva);
        return convertToResponse(savedReserva);
    }

    public List<ReservaResponse> getReservasByUsuario(Long idUsuario) {
        List<Reserva> reservas = reservaRepository.findByIdUsuario(idUsuario);
        return reservas.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public List<ReservaResponse> getReservasByHorario(Long idHorario) {
        List<Reserva> reservas = reservaRepository.findByIdHorario(idHorario);
        return reservas.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public ReservaResponse updateReserva(Long idReserva, ReservaRequest request) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setIdUsuario(request.getIdUsuario());
        reserva.setIdHorario(request.getIdHorario());
        reserva.setEstado(request.getEstado());

        Reserva updatedReserva = reservaRepository.save(reserva);
        return convertToResponse(updatedReserva);
    }

    public void deleteReserva(Long idReserva) {
        if (!reservaRepository.existsById(idReserva)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        reservaRepository.deleteById(idReserva);
    }

    public Long countReservasByHorario(Long idHorario) {
        return reservaRepository.countByIdHorario(idHorario);
    }

    private ReservaResponse convertToResponse(Reserva reserva) {
        ReservaResponse response = new ReservaResponse();
        response.setIdReserva(reserva.getIdReserva());
        response.setIdUsuario(reserva.getIdUsuario());
        response.setIdHorario(reserva.getIdHorario());
        response.setEstado(reserva.getEstado());
        response.setFechaCreacion(reserva.getFechaCreacion());
        return response;
    }
}
