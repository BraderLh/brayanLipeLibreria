package com.codigo.brayan_lipe.controller;

import com.codigo.brayan_lipe.entity.Libro;
import com.codigo.brayan_lipe.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = libroService.obtenerLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) throws Exception {
        Libro libro = libroService.obtenerLibroPorId(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibroPorId(@PathVariable Long id, @RequestBody Libro libro) throws Exception {
        Libro libroActualizado = libroService.actualizarLibro(id, libro);
        return new ResponseEntity<>(libroActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibroPorId(@PathVariable Long id) throws Exception {
        String msmDeleting = libroService.eliminarLibroPorId(id) ? "Eliminacion exitosa" : "Eliminacion fallida";
        return new ResponseEntity<>(msmDeleting, HttpStatus.OK);
    }
}
