/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

/**
 *
 * @author waria
 */
import br.com.ifba.curso.controller.CursoController;
import javax.swing.*; // importa a biblioteca Swing 
import br.com.ifba.curso.entity.Curso;

public class CursoSave extends JFrame {

        // definição do objeto controller
        private final CursoController controller = new CursoController();
   
    
        // DEFINIÇÕES DO JFrame QUE ABRE A JANELA CADASTRO DE CURSOS
        public CursoSave(){
        setSize(300, 250); 
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
                controller.save(nome, semestres);
                JOptionPane.showMessageDialog(null, "curso salvo com sucesso!");
                dispose();

            } catch (Exception ex) { // mostra no console um possivel erro ao salvar
                JOptionPane.showMessageDialog(null, "erro ao salvar: " + ex.getMessage());
            }
        });
         add(btnSalvar);


        setVisible(true);
    }
        // DEFINIÇÕES DO JFrame QUE ABRE A JANELA DE EDITAR E ATUALIZAR CURSO
        public CursoSave(Curso curso) {
            setSize(300, 250);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(null);

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(20, 20, 80, 25);
            JTextField nomeField = new JTextField(curso.getNome());
            
            nomeField.setBounds(100, 20, 150, 25);
            add(nomeLabel);
            add(nomeField);

            JLabel qtdLabel = new JLabel("Semestres:");
            qtdLabel.setBounds(20, 60, 80, 25);
            JTextField semestreField = new JTextField(String.valueOf(curso.getSemestres()));
            semestreField.setBounds(100, 60, 150, 25);
            
            add(qtdLabel);
            add(semestreField);

            // botão que salva/atualiza o curso
            JButton btnSalvar = new JButton("Atualizar");
            btnSalvar.setBounds(50, 180, 90, 30);
            btnSalvar.addActionListener(e -> {
        try {
            curso.setNome(nomeField.getText());
            curso.setSemestres(Integer.parseInt(semestreField.getText()));
            controller.update(curso, curso.getNome(), curso.getSemestres());
            JOptionPane.showMessageDialog(null,"curso editado");
            dispose();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"erro ao editar" + ex.getMessage());
}
        });
        add(btnSalvar);
        setVisible(true);
     }     
}


    
