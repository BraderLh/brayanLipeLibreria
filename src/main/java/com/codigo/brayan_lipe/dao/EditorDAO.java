package com.codigo.brayan_lipe.dao;

import com.codigo.brayan_lipe.entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorDAO extends JpaRepository<Editor, Long> {
}
