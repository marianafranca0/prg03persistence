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
import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.CursoSave;
import br.com.ifba.curso.controller.CursoController;

public class CursoListar extends JFrame {
    
        private JTable tabela = null;
        private DefaultTableModel modelo = null;
     
        private final CursoController controller = new CursoController();
    
        public CursoListar() {  
        // DEFINIÇÕES do JFrame ----------------------
        setTitle("Lista de Cursos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(20, 20, 100, 30);
        btnCadastrar.addActionListener(e -> new CursoSave());
        add(btnCadastrar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(130, 20, 100, 30);
        add(btnEditar);
        btnEditar.addActionListener(e -> {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            Long id = (Long) modelo.getValueAt(linha, 0);
            //Curso curso = dao.findById(id);
            Curso curso = controller.findById(id);
            new CursoSave(curso); //chama o construtor de editar/edição
            carregarCursos();     // atualiza a tabela
    }   else {
        JOptionPane.showMessageDialog(this, "selecione um curso para editar");
    }
    });
        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(240, 20, 100, 30);
        add(btnRemover);
        
        btnRemover.addActionListener(e -> {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            Long id = (Long) modelo.getValueAt(linha, 0);
            Curso curso = controller.findById(id);
            controller.delete(id); //remove um curso
            carregarCursos();  // atualiza a tabela
       }else{
            JOptionPane.showMessageDialog(this, "selecione um curso para remover");
          }
        });

        // tabela com os dados
        modelo = new DefaultTableModel(new String[]{"ID", "Curso", "Semestres"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 70, 550, 280);
        add(scrollPane);
        carregarCursos();
      
        setVisible(true);
    }
        private void carregarCursos() {
        modelo.setRowCount(0);  
    try{
       List<Curso> cursos = controller.findAll(); // busca os cursos salvos 
        for (Curso c : cursos) {
            modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getSemestres()});
        }
    }catch(Exception e) {
         JOptionPane.showMessageDialog(this,"erro!!!" + e.getMessage());
    }
 }
      public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new CursoListar());
}
    }
      
   






