package com.codigo.brayan_lipe.controller;

import com.codigo.brayan_lipe.entity.Editor;
import com.codigo.brayan_lipe.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/editor")
public class EditorController {
    @Autowired
    private EditorService editorService;

    @GetMapping
    public ResponseEntity<List<Editor>> listarEditores() {
        List<Editor> editors = editorService.obtenerEditores();
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editor> obtenerEditorPorId(@PathVariable Long id) throws Exception {
        Editor editor = editorService.obtenerEditorPorId(id);
        return new ResponseEntity<>(editor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Editor> crearEditor(@RequestBody Editor editor) {
        Editor nuevoEditor = editorService.crearEditor(editor);
        return new ResponseEntity<>(nuevoEditor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editor> actualizarEditorPorId(@PathVariable Long id, @RequestBody Editor editor) throws Exception {
        Editor editorActualizado = editorService.actualizarEditor(id, editor);
        return new ResponseEntity<>(editorActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEditorPorId(@PathVariable Long id) throws Exception {
        String msmDeleting = editorService.eliminarEditorPorId(id) ? "Eliminacion exitosa" : "Eliminacion fallida";
        return new ResponseEntity<>(msmDeleting, HttpStatus.OK);
    }
}
