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


public class CursoListar extends JFrame {
    
    private final JTable tabela;
    private final DefaultTableModel modelo;
      
    private final CursoDao dao = new CursoDao();
    
    public CursoListar() {
        
        // definição do frame
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

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(240, 20, 100, 30);
        add(btnRemover);

        // tabela com os dados
        modelo = new DefaultTableModel(new String[]{"ID", "Curso", "Semestres"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 70, 550, 280);
        add(scrollPane);

        carregarCursos();
      
        setVisible(true);
    }

    // método
    private void carregarCursos() {
      modelo.setRowCount(0);
      try{
       List<Curso> cursos = dao.findAll();
        for (Curso c : cursos) {
            modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getSemestres()});
        }
    }catch(Exception e) {
         e.printStackTrace();
         JOptionPane.showMessageDialog(this,"erro!!!" + e.getMessage());
    }
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new CursoListar());
}
    }
      
   






