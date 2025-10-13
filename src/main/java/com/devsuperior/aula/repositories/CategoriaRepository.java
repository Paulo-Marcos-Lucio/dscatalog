package com.devsuperior.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.aula.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
