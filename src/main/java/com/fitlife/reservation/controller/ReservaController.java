package com.fitlife.reservation.controller;

import com.fitlife.reservation.dto.ReservaRequest;
import com.fitlife.reservation.dto.ReservaResponse;
import com.fitlife.reservation.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> createReserva(@Valid @RequestBody ReservaRequest request) {
        ReservaResponse response = reservaService.createReserva(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReservaResponse>> getReservasByUsuario(@PathVariable Long idUsuario) {
        List<ReservaResponse> reservas = reservaService.getReservasByUsuario(idUsuario);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/horario/{idHorario}")
    public ResponseEntity<List<ReservaResponse>> getReservasByHorario(@PathVariable Long idHorario) {
        List<ReservaResponse> reservas = reservaService.getReservasByHorario(idHorario);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/horario/{idHorario}/count")
    public ResponseEntity<Long> countReservasByHorario(@PathVariable Long idHorario) {
        Long count = reservaService.countReservasByHorario(idHorario);
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{idReserva}")
    public ResponseEntity<ReservaResponse> updateReserva(
            @PathVariable Long idReserva,
            @Valid @RequestBody ReservaRequest request) {
        ReservaResponse response = reservaService.updateReserva(idReserva, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idReserva}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long idReserva) {
        reservaService.deleteReserva(idReserva);
        return ResponseEntity.noContent().build();
    }
}
