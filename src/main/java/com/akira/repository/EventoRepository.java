package com.akira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akira.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
