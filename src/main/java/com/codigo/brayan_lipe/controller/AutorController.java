package com.codigo.brayan_lipe.controller;

import com.codigo.brayan_lipe.entity.Autor;
import com.codigo.brayan_lipe.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        List<Autor> autores = autorService.obtenerAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Long id) throws Exception {
        Autor autor = autorService.obtenerAutorPorId(id);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor) {
        Autor nuevoAutor = autorService.crearAutor(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutorPorId(@PathVariable Long id, @RequestBody Autor autor) throws Exception {
        Autor autorActualizado = autorService.actualizarAutor(id, autor);
        return new ResponseEntity<>(autorActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutorPorId(@PathVariable Long id) throws Exception {
        String msmDeleting = autorService.eliminarAutorPorId(id) ? "Eliminacion exitosa" : "Eliminacion fallida";
        return new ResponseEntity<>(msmDeleting, HttpStatus.OK);
    }
}
