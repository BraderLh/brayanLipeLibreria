package com.codigo.brayan_lipe.service.impl;

import com.codigo.brayan_lipe.dao.AutorDAO;
import com.codigo.brayan_lipe.entity.Autor;
import com.codigo.brayan_lipe.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorDAO autorDAO;

    @Override
    public List<Autor> obtenerAutores() {
        return autorDAO.findAll();
    }

    @Override
    public Autor obtenerAutorPorId(Long id) throws Exception {
        Optional<Autor> autor = autorDAO.findById(id);
        if (autor.isPresent()) {
            return autor.get();
        } else {
            throw new Exception("El autor a detallar no existe");
        }
    }

    @Override
    public Autor crearAutor(Autor autor) {
        return autorDAO.save(autor);
    }

    @Override
    public Autor actualizarAutor(Long id, Autor autor) throws Exception {
        Optional<Autor> foundAutor = autorDAO.findById(id);
        if (foundAutor.isPresent()) {
            foundAutor.get().setNombre(autor.getNombre() == null || autor.getNombre().trim().isEmpty() || autor.getNombre().isBlank() ? foundAutor.get().getNombre() : autor.getNombre());
            foundAutor.get().setEstado(autor.getEstado() == null ? foundAutor.get().getEstado() : autor.getEstado());
            return autorDAO.save(foundAutor.get());
        } else {
            throw new Exception("El autor a actualizar no existe");
        }
    }

    @Override
    public boolean eliminarAutorPorId(Long id) throws Exception {
        Optional<Autor> foundAutor = autorDAO.findById(id);
        if (foundAutor.isPresent()) {
            autorDAO.delete(foundAutor.get());
            return true;
        } else {
            throw new Exception("El autor a eliminar no existe");
        }
    }
}
