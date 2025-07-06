/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

/**
 *
 * @author waria
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import br.com.ifba.infrastructure.entity.PersistenceEntity;

@Entity
public class Curso extends PersistenceEntity {
  
    private Long id;

    private String nome;
    private int semestres;

    // Getters e setters
    @Override
    public Long getId() { 
        return id; 
    }
    public String getNome() { 
        return nome;
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public int getSemestres() {
        return semestres; 
    }
    public void setSemestres(int semestres) { 
        this.semestres = semestres; 
    }
}
        
    
