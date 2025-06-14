/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

/**
 *
 * @author waria
 */

import javax.swing.*;

public class Curso extends JFrame {
    public Curso() {
        setSize(300, 250); // DEFINIÇÕES do JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // campo "Nome"
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 80, 25);
        JTextField nomeField = new JTextField();
        nomeField.setBounds(100, 20, 150, 25);
        add(nomeLabel);
        add(nomeField);

        // campo "Semestres"
        JLabel semestreLabel = new JLabel("Semestres:");
        semestreLabel.setBounds(20, 100, 80, 25);
        JTextField semestreField = new JTextField();
        semestreField.setBounds(100, 100, 150, 25);
        add(semestreLabel);
        add(semestreField);

        // BOTÕES Salvar e Cancelar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(50, 180, 90, 30);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(150, 180, 90, 30);
        btnCancelar.addActionListener(e -> dispose());
        
        // adicionam os botões na tela
        add(btnSalvar);
        add(btnCancelar);

        setVisible(true);
    }
}