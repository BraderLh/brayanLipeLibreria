package com.codigo.brayan_lipe.service;

import com.codigo.brayan_lipe.entity.Editor;

import java.util.List;

public interface EditorService {
    List<Editor> obtenerEditores();
    Editor obtenerEditorPorId(Long id) throws Exception;
    Editor crearEditor(Editor editor);
    Editor actualizarEditor(Long id, Editor editor) throws Exception;
    boolean eliminarEditorPorId(Long id) throws Exception;
}
