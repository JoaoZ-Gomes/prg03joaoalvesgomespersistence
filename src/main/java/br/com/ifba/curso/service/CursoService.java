package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

public class CursoService implements CursoIService {

    private final CursoIDao cursoDao;

    public CursoService() {
        this.cursoDao = new CursoDao();
    }

    @Override
    public void salvarCurso(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    public void atualizarCurso(Curso curso) {
        cursoDao.update(curso);
    }

    @Override
    public void removerCurso(Curso curso) {
        cursoDao.delete(curso.getId());
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoDao.findAll();
    }

    @Override
    public Curso buscarPorId(Long id) {
        return cursoDao.findById(id);
    }
}
