package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

// Interface que define as ações do Controller
public interface CursoIController {
    void salvarCurso(Curso curso);
    void atualizarCurso(Curso curso);
    void removerCurso(Curso curso);
    List<Curso> listarTodos();
    Curso buscarPorId(Long id);
}
