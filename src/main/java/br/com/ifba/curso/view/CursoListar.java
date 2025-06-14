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
import br.com.ifba.CursoSave;
import br.com.ifba.curso.entity.Curso;

public class CursoListar extends JFrame {
    
    private JTextField txtProcurar;
    private JButton btnCadastrar, btnEditar, btnRemover;
    private JTable tabela;
    private DefaultTableModel modelo;

    public CursoListar() {
        setSize(600, 400); // DEFINIÇÕES do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // campo "Procurar"
        JLabel buscaLabel = new JLabel("Procurar:");
        buscaLabel.setBounds(20, 20, 80, 25);
        txtProcurar = new JTextField();
        txtProcurar.setBounds(100, 20, 200, 25);
        add(buscaLabel);
        add(txtProcurar);

        // BOTÕES ----------
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(320, 20, 100, 30);
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(430, 20, 100, 30);
        btnRemover = new JButton("Remover");
        btnRemover.setBounds(540, 20, 100, 30);

        add(btnCadastrar);
        add(btnEditar);
        add(btnRemover);

        // tabela com os cursos
        modelo = new DefaultTableModel(new Object[][]{
            {"ADS", "6"},
            {"MI", "6",},
            {"SI", "8"},
        }, new String[]{"Cursos","Qtd Semestres"});
 
        // cria a tabela de acordo com o modelo
        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 60, 580, 250);
        add(scrollPane);

        // botões para abrir telas
        btnCadastrar.addActionListener(e -> new CursoSave());
        btnEditar.addActionListener(e -> new Curso());
        btnRemover.addActionListener(e -> JOptionPane.showMessageDialog(this,"Deseja remover o curso?","Confirmação", JOptionPane.WARNING_MESSAGE));

        setVisible(true);
    }

    // cria e exibe a tela
    public static void main(String[] args) {
        new CursoListar();
    }
}