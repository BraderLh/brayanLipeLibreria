package com.codigo.brayan_lipe.dao;

import com.codigo.brayan_lipe.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<Autor, Long> {
}
