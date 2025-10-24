package com.devsuperior.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.aula.entities.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {

}
