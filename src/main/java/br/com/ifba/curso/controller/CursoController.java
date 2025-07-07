package br.com.ifba.curso.controller;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

public class CursoController {

    private final CursoDao cursoDao;

    public CursoController() {
        this.cursoDao = new CursoDao();
    }

    // Salva um novo curso
    public void salvarCurso(Curso curso) {
        cursoDao.save(curso);
    }

    // Busca um curso pelo ID
    public Curso buscarCurso(Long id) {
        return cursoDao.findById(id);
    }

    // Atualiza um curso existente
    public void atualizarCurso(Curso curso) {
        cursoDao.update(curso);
    }

    // Remove um curso pelo ID
    public void removerCurso(Long id) {
        cursoDao.delete(id);
    }

    // Lista todos os cursos do banco
    public List<Curso> listarCursos() {
        return cursoDao.findAll();
    }
}
