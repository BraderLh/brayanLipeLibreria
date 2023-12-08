package com.codigo.brayan_lipe.service;

import com.codigo.brayan_lipe.entity.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> obtenerAutores();

    Autor obtenerAutorPorId(Long id) throws Exception;

    Autor crearAutor(Autor autor);

    Autor actualizarAutor(Long id, Autor autor) throws Exception;

    boolean eliminarAutorPorId(Long id) throws Exception;
}
