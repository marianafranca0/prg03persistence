/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author waria
 * @param <Entity>
 */

public interface GenericIDao<Entity extends PersistenceEntity>{
   
    public abstract Entity save(Entity objeto);
    public abstract Entity update(Entity objeto);
    public abstract void delete(Entity objeto);
    public abstract List<Entity> findAll();
    public abstract Entity findById(Long id);
}
