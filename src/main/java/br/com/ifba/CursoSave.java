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
import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.entity.Curso;

//janela onde o usuario cadastra novo curso
public class CursoSave extends JFrame {

        // objeto responsavel por salvar o curso no banco
        private final CursoDao dao = new CursoDao() {};
   
    
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
                dao.save(curso);
                JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!");
                dispose();

            } catch (Exception ex) { // mostra no console um possivel erro ao salvar
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
            }
        });
         add(btnSalvar);


        setVisible(true);
   
  
    }
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CursoSave());
}
}

    
