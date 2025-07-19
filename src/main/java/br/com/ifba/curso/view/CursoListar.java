/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.view;


/**
 *
 * @author waria
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel; // importação para manipular a tabela
import java.util.List;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.controller.CursoIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoListar extends JFrame {
    
        @Autowired
        private CursoIController controller;
        
        @Autowired
        private CursoSave telaCursoSave;
        
        private JTable tabela = null;
        private DefaultTableModel modelo = null;
    
        public CursoListar() {  
        // DEFINIÇÕES do JFrame ----------------------
        setTitle("Lista de Cursos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // botão cadastrar
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(20, 20, 100, 30);
        btnCadastrar.addActionListener(e -> {
            telaCursoSave.setTelaCursoListar(this);
            telaCursoSave.setCurso(null); //--- novo curso ---
            telaCursoSave.setVisible(true);
        });
        add(btnCadastrar);

        // botão editar
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(130, 20, 100, 30);
        btnEditar.addActionListener(e -> {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            Long id = (Long) modelo.getValueAt(linha, 0);
            try{
                Curso curso = controller.findById(id);
                telaCursoSave.setCurso(curso); // curso para edição
                telaCursoSave.setVisible(true);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "erro ao buscar curso");
            }
            carregarCursos();
        }else{
            JOptionPane.showMessageDialog(this,"selecione um curso para editar");
        }
        });
         add(btnEditar);
         
        // botão remover
        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(240, 20, 100, 30);
        btnRemover.addActionListener(e -> {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            Long id = (Long) modelo.getValueAt(linha, 0);
            controller.delete(id); //remove um curso
            carregarCursos();  // atualiza a tabela
       }else{
            JOptionPane.showMessageDialog(this, "selecione um curso para remover");
          }
        });
        add(btnRemover);

        // tabela com os dados
        modelo = new DefaultTableModel(new String[]{"ID", "Curso", "Semestres"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 70, 550, 280);
        add(scrollPane);
        
        carregarCursos(); 
        System.out.println("CursoListar construído.");

    }
        public void carregarCursos() {
        modelo.setRowCount(0);  
        try{
           List<Curso> cursos = controller.findAll(); // busca os cursos salvos 
           for(Curso c : cursos) {
               modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getSemestres()});
            }
       }catch(Exception e) {
           JOptionPane.showMessageDialog(this,"erro!!!" + e.getMessage());
    }
 }
     
}


    
      
   






