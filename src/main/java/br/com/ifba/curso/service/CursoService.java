/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

/**
 *
 * @author waria
 */

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Classe que faz VALIDAÇÕES e contém as REGRAS DE NEGÓCIO
//---------------------------------------------------------

@Service
public class CursoService implements CursoIService{
    
    @Autowired
    private CursoRepository repository;
    
    @Override
    public Curso save(String nome, int semestres){
        // utiliza o método de validação da classe StringUtil
        if(StringUtil.isNullOrEmpty(nome)){
            throw new IllegalArgumentException("nome do curso deve ser preenchido.");
        }if(semestres <= 0){
            throw new IllegalArgumentException("quantidade de semestres deve ser maior que 0.");
        }
        Curso curso  = new Curso();
        curso.setNome(nome);
        curso.setSemestres(semestres);
        return repository.save(curso);
    }
    
    @Override
    public Curso update(Curso curso, String nome, int semestres){
        if(StringUtil.isNullOrEmpty(nome)){
            throw new IllegalArgumentException("nome do curso deve ser preenchido.");
        }if(semestres <= 0){
            throw new IllegalArgumentException("semestre inválido.");
        }
        curso.setNome(nome);
        curso.setSemestres(semestres);
        return repository.save(curso);
    }
    
    @Override
    public List<Curso> findAll(){
        return repository.findAll();
    }
    @Override
    public Curso findById(Long id){
        return repository.findById(id).orElse(null);
    }
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    
    }
}

