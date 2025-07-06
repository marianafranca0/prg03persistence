/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

/**
 *
 * @author waria
 */

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import javax.persistence.*;
import java.util.List;

public class GenericDao<T extends PersistenceEntity> {
     
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("gerenciamento_cursos");
    private static final EntityManager em = emf.createEntityManager();


      private final Class<T> typeClass = null;

    
       public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.getTransaction().commit();
    }

    public T findById(Long id) {
        return em.find(typeClass, id);
    }

    public List<T> findAll() {
        return em.createQuery("FROM " + typeClass.getSimpleName(), typeClass).getResultList();
    }
}





    
