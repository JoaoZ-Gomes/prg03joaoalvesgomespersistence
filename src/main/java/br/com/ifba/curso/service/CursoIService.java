package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

// Interface de Service com métodos de regra de negócio
public interface CursoIService {
    void salvarCurso(Curso curso);
    void atualizarCurso(Curso curso);
    void removerCurso(Curso curso);
    List<Curso> listarTodos();
    Curso buscarPorId(Long id);
}
