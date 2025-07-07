package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

// Implementação do Service do Curso, com regras de negócio básicas
public class CursoService implements CursoIService {

    private final CursoIDao cursoDao;

    // Construtor - inicializa o DAO
    public CursoService() {
        this.cursoDao = new CursoDao();
    }

    @Override
    public void salvarCurso(Curso curso) {
        // Validação de regra de negócio: nome não pode ser vazio
        if (curso.getNome() == null || curso.getNome().trim().isEmpty()) {
            throw new RuntimeException("O nome do curso é obrigatório.");
        }
        // Validação: carga horária deve ser positiva
        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() <= 0) {
            throw new RuntimeException("A carga horária deve ser maior que zero.");
        }
        cursoDao.save(curso); // Salva no banco
    }

    @Override
    public void atualizarCurso(Curso curso) {
        // Validação: ID deve existir para atualizar
        if (curso.getId() == null) {
            throw new RuntimeException("ID do curso não pode ser nulo para atualizar.");
        }
        // Reutiliza validações de salvar
        salvarCurso(curso);
    }

    @Override
    public void removerCurso(Curso curso) {
        // Validação: precisa ter ID para remover
        if (curso.getId() == null) {
            throw new RuntimeException("ID do curso não pode ser nulo para remover.");
        }
        cursoDao.delete(curso.getId()); // Remove pelo ID
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoDao.findAll(); // Busca todos os cursos
    }

    @Override
    public Curso buscarPorId(Long id) {
        if (id == null) {
            throw new RuntimeException("ID não pode ser nulo para buscar curso.");
        }
        return cursoDao.findById(id);
    }
}
