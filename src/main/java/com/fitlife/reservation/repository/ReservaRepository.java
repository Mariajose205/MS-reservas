package com.fitlife.reservation.repository;

import com.fitlife.reservation.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    Optional<Reserva> findByIdUsuarioAndIdHorario(Long idUsuario, Long idHorario);
    
    List<Reserva> findByIdUsuario(Long idUsuario);
    
    List<Reserva> findByIdHorario(Long idHorario);
    
    @Query("SELECT r FROM Reserva r WHERE r.fechaCreacion BETWEEN :startDate AND :endDate")
    List<Reserva> findByFechaCreacionBetween(@Param("startDate") LocalDateTime startDate, 
                                            @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.idHorario = :idHorario")
    Long countByIdHorario(@Param("idHorario") Long idHorario);
}
