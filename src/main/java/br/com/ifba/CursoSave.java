/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

/**
 *
 * @author waria
 */
import javax.swing.*; // importa a biblioteca Swing 

public class CursoSave extends JFrame {
    public CursoSave(){
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
        JLabel qtdLabel = new JLabel("Semestres:");
        qtdLabel.setBounds(20, 60, 80, 25);
        JTextField qtdField = new JTextField();
        qtdField.setBounds(100, 60, 150, 25);
        add(qtdLabel);
        add(qtdField);

        // botão salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(50, 180, 90, 30);

        // botão cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(150, 180, 90, 30);
        cancelarButton.addActionListener(e -> dispose());

        // adicionam os botões na tela
        add(btnSalvar); 
        add(cancelarButton);

        setVisible(true);
    }
}