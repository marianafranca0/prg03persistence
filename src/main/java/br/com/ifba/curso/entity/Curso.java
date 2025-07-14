/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

/**
 *
 * @author waria
 */

import jakarta.persistence.Entity;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso extends PersistenceEntity implements Serializable {
  
   @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int semestres;


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
        
    
