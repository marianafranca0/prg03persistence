/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;

/**
 *
 * @author waria
 */

import java.util.List;
public interface CursoIController {
    
    public abstract Curso save(String nome, int semestres);
    public abstract Curso update(Curso curso, String nome, int semestres);
    public abstract void delete(Long id);
    public  abstract List<Curso> findAll();
    public abstract Curso findById(Long id);
}
