/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

/**
 *
 * @author waria
 */

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.stereotype.Repository;

// Classe que encapsula operações de ACESSO ao banco de dados
// ** Para qualquer entidade do sistema **
//-----------------------------------------------------------
@SuppressWarnings("unchecked")
@Repository
public class GenericDao<Entity extends PersistenceEntity> 
        implements GenericIDao<Entity> {
        
        // gerenciado pelo contêiner
        @PersistenceContext
        protected EntityManager entityManager;
  
        
     //*garante que as operações sejam executadas dentro
     // de uma transação controlada pelo Spring*
        @Transactional 
        @Override 
        public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }
        @Transactional
        @Override
        public Entity update(Entity entity) {
        entityManager.merge(entity);
        return entity;
    }
       @Transactional
        @Override
        public void delete(Entity entity) {
        entity = findById(entity.getId());
        entityManager.remove(entity);  
    }
    /**
     *
     * @return
     */
        @Override
        public List<Entity> findAll(){
            return entityManager.createQuery("from " + getTypeClass().getSimpleName()).getResultList();
    }
    /**
     *
     * @param id
     * @return
     */
        @Override
        public Entity findById(Long id){
           return (Entity) entityManager.find(getTypeClass(), id);
    }
        protected Class<?> getTypeClass() {
            Class <?> classe = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return classe;
    }
}





    
