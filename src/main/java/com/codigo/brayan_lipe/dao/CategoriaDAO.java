package com.codigo.brayan_lipe.dao;

import com.codigo.brayan_lipe.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Long> {
}
