package com.codigo.brayan_lipe.service.impl;

import com.codigo.brayan_lipe.dao.CategoriaDAO;
import com.codigo.brayan_lipe.entity.Categoria;
import com.codigo.brayan_lipe.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaDAO.findAll();
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) throws Exception {
        Optional<Categoria> categoria = categoriaDAO.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new Exception("La categoria a detallar no existe");
        }
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) throws Exception {
        Optional<Categoria> foundCategoria = categoriaDAO.findById(id);
        if (foundCategoria.isPresent()) {
            foundCategoria.get().setNombre(categoria.getNombre() == null || categoria.getNombre().trim().isEmpty() || categoria.getNombre().isBlank() ? foundCategoria.get().getNombre() : categoria.getNombre());
            foundCategoria.get().setEstado(categoria.getEstado() == null ? foundCategoria.get().getEstado() : categoria.getEstado());
            return categoriaDAO.save(foundCategoria.get());
        } else {
            throw new Exception("La categoria a actualizar no existe");
        }
    }

    @Override
    public boolean eliminarCategoriaPorId(Long id) throws Exception {
        Optional<Categoria> foundCategoria = categoriaDAO.findById(id);
        if (foundCategoria.isPresent()) {
            categoriaDAO.delete(foundCategoria.get());
            return true;
        } else {
            throw new Exception("La categoria a eliminar no existe");
        }
    }
}
