/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

/**
 *
 * @author waria
 */

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Classe que recebe ações da VIEW e repassa para o SERVICE
//---------------------------------------------------------

@Controller
public class CursoController implements CursoIController{
   
    @Autowired
    private CursoIService service;
    
    @Override
    public Curso save(String nome, int semestres){
        return service.save(nome, semestres);
    }
    
    @Override
    public Curso update(Curso curso, String nome, int semestres){
        return service.update(curso, nome, semestres);
    }
    
    @Override
    public void delete(Long id){
        service.delete(id);
    }
    
    @Override
    public List<Curso> findAll(){
        return service.findAll();
    }
    
    @Override
    public Curso findById(Long id){
        return service.findById(id);
    }
}
