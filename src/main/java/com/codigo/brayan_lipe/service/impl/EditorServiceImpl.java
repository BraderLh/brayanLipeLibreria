package com.codigo.brayan_lipe.service.impl;

import com.codigo.brayan_lipe.dao.EditorDAO;
import com.codigo.brayan_lipe.entity.Editor;
import com.codigo.brayan_lipe.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorServiceImpl implements EditorService {
    @Autowired
    private EditorDAO editorDAO;

    @Override
    public List<Editor> obtenerEditores() {
        return editorDAO.findAll();
    }

    @Override
    public Editor obtenerEditorPorId(Long id) throws Exception {
        Optional<Editor> editor = editorDAO.findById(id);
        if (editor.isPresent()) {
            return editor.get();
        } else {
            throw new Exception("El editor a detallar no existe");
        }
    }

    @Override
    public Editor crearEditor(Editor editor) {
        return editorDAO.save(editor);
    }

    @Override
    public Editor actualizarEditor(Long id, Editor editor) throws Exception {
        Optional<Editor> foundEditor = editorDAO.findById(id);
        if (foundEditor.isPresent()) {
            foundEditor.get().setNombre(editor.getNombre() == null || editor.getNombre().isBlank() || editor.getNombre().trim().isEmpty() ? foundEditor.get().getNombre() : editor.getNombre());
            foundEditor.get().setEstado(editor.getEstado() == null ? foundEditor.get().getEstado() : editor.getEstado());
            return editorDAO.save(foundEditor.get());
        } else {
            throw new Exception("El editor a detallar no existe");
        }
    }

    @Override
    public boolean eliminarEditorPorId(Long id) throws Exception {
        Optional<Editor> foundEditor = editorDAO.findById(id);
        if (foundEditor.isPresent()) {
            editorDAO.delete(foundEditor.get());
            return true;
        } else {
            throw new Exception("El editor a detallar no existe");
        }
    }
}
