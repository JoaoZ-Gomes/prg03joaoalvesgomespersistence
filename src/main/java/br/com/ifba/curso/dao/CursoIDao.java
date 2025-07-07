package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

// Interface do DAO do Curso (CursoIDao)
public interface CursoIDao {
    void save(Curso curso);
    Curso findById(Long id);
    void update(Curso curso);
     void delete(Long id);  // ou delete(Long id)
    
    List<Curso> findAll();
}
