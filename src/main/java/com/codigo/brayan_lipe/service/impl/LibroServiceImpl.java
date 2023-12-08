package com.codigo.brayan_lipe.service.impl;

import com.codigo.brayan_lipe.dao.LibroDAO;
import com.codigo.brayan_lipe.entity.Libro;
import com.codigo.brayan_lipe.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroDAO libroDAO;

    @Override
    public List<Libro> obtenerLibros() {
        return libroDAO.findAll();
    }

    @Override
    public Libro obtenerLibroPorId(Long id) throws Exception {
        Optional<Libro> libro = libroDAO.findById(id);
        if(libro.isPresent()){
            return libro.get();
        }else{
            throw new Exception("El libro a detallar no existe");
        }
    }

    @Override
    public Libro crearLibro(Libro libro) {
        return libroDAO.save(libro);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libro) throws Exception {
        Optional<Libro> foundLibro = libroDAO.findById(id);
        if(foundLibro.isPresent()){
            foundLibro.get().setTitulo(libro.getTitulo() ==null || libro.getTitulo().trim().isEmpty() || libro.getTitulo().isBlank() ? foundLibro.get().getTitulo() : libro.getTitulo());
            foundLibro.get().setEstado(libro.getEstado() == null ? foundLibro.get().getEstado() : libro.getEstado());
            return libroDAO.save(foundLibro.get());
        }else{
            throw new Exception("El libro a actualizar no existe");
        }
    }

    @Override
    public boolean eliminarLibroPorId(Long id) throws Exception {
        Optional<Libro> foundLibro = libroDAO.findById(id);
        if (foundLibro.isPresent()) {
            libroDAO.delete(foundLibro.get());
            return true;
        } else {
            throw new Exception("El libro a eliminar no existe");
        }
    }
}
