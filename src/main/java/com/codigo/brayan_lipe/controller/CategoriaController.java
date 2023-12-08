package com.codigo.brayan_lipe.controller;

import com.codigo.brayan_lipe.entity.Categoria;
import com.codigo.brayan_lipe.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.obtenerCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id) throws Exception {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.crearCategoria(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoriaPorId(@PathVariable Long id, @RequestBody Categoria categoria) throws Exception {
        Categoria categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        return new ResponseEntity<>(categoriaActualizada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoriaPorId(@PathVariable Long id) throws Exception {
        String msmDeleting = categoriaService.eliminarCategoriaPorId(id) ? "Eliminacion exitosa" : "Eliminacion fallida";
        return new ResponseEntity<>(msmDeleting, HttpStatus.OK);
    }
}
