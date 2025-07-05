package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao; // Importa o GenericDao 
import java.util.List;

// DAO específico para a entidade Curso, que estende a classe genérica GenericDao
public class CursoDao extends GenericDao<Curso> {

    // Construtor que inicializa o DAO para trabalhar com a entidade Curso
    public CursoDao() {
        super(Curso.class); // Passa a classe Curso para o GenericDao
    }
    
    // Herda     // - save(Curso curso)
    // - findById(Long id)
    // - update(Curso curso)
    // - delete(Long id)
    // - findAll()
    
    //  adicionar  métodos específicos para Curso que não existam no GenericDao
}