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
import jakarta.persistence.*;
import br.com.ifba.curso.entity.Curso;

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
        JTextField semestreField = new JTextField();
        semestreField.setBounds(100, 60, 150, 25);
        add(qtdLabel);
        add(semestreField);

        // botão salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(50, 180, 90, 30);
         btnSalvar.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                int semestres = Integer.parseInt(semestreField.getText());

                Curso curso = new Curso();
                curso.setNome(nome);
                curso.setSemestres(semestres);

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                em.persist(curso);
                em.getTransaction().commit();

                em.close();
                emf.close();

                //JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!");
               // dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
            }
        });


        // botão cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(150, 180, 90, 30);
        cancelarButton.addActionListener(e -> dispose());

        // adicionam os botões na tela
        add(btnSalvar); 
        add(cancelarButton);

        setVisible(true);
        
  
    }
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CursoSave());
}
}

    
