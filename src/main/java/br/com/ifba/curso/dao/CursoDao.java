package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import java.util.List;

// DAO do Curso agora implementa a interface ICursoDao
public class CursoDao extends GenericDao<Curso> implements CursoIDao {

    public CursoDao() {
        super(Curso.class);
        
    }

    // Se o GenericDao já tem todos os métodos, não precisa reimplementar aqui.
    // Só deixa a porta aberta pra métodos específicos de Curso futuramente.
}
