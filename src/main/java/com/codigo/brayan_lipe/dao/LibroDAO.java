package com.codigo.brayan_lipe.dao;

import com.codigo.brayan_lipe.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDAO extends JpaRepository<Libro, Long> {
}
