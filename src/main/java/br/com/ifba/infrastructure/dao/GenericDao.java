package br.com.ifba.infrastructure.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

// Classe genérica para operações de acesso a dados (DAO)
public class GenericDao<T> {

    // Fábrica de EntityManager (singleton para toda aplicação)
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("prg03JoaoAlvesGomesPresistencia");
    
    // Gerenciador de entidades JPA
    protected EntityManager em = emf.createEntityManager();

    // Classe da entidade que este DAO irá manipular
    private final Class<T> clazz;

    // Construtor que recebe a classe da entidade
    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    // Salva uma nova entidade no banco de dados
    public void save(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Busca uma entidade pelo seu ID
    public T findById(Long id) {
        return em.find(clazz, id);
    }

    // Atualiza uma entidade existente
    public void update(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Remove uma entidade pelo seu ID
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            T entity = em.find(clazz, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Retorna todas as entidades deste tipo
    public List<T> findAll() {
        return em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
    }
}