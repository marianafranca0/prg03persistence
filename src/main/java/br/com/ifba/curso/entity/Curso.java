/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

/**
 *
 * @author waria
 */

import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int semestres;

    // Getters e setters
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
        
    
