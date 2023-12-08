package com.codigo.brayan_lipe.service;

import com.codigo.brayan_lipe.entity.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> obtenerLibros();

    Libro obtenerLibroPorId(Long id) throws Exception;

    Libro crearLibro(Libro libro);

    Libro actualizarLibro(Long id, Libro libro) throws Exception;

    boolean eliminarLibroPorId(Long id) throws Exception;
}
