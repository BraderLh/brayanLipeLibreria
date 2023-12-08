package com.codigo.brayan_lipe.service;

import com.codigo.brayan_lipe.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerCategorias();
    Categoria obtenerCategoriaPorId(Long id) throws Exception;
    Categoria crearCategoria(Categoria categoria);
    Categoria actualizarCategoria(Long id, Categoria categoria) throws Exception;
    boolean eliminarCategoriaPorId(Long id) throws Exception;
}
