/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.view;

/**
 *
 * @author waria
 */
import br.com.ifba.curso.controller.CursoIController;
import javax.swing.*; // importa a biblioteca Swing 
import br.com.ifba.curso.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoSave extends JFrame {

        @Autowired
        private CursoIController controller;
   
        private Curso cursoEditar;
        
        private CursoListar telaCursoListar;
        
        public void setTelaCursoListar(CursoListar tela){
            this.telaCursoListar = tela;
        }
        
        private final JTextField nomeField = new JTextField();
        private final JTextField semestreField = new JTextField();

        // DEFINIÇÕES DO JFrame QUE ABRE A JANELA CADASTRO DE CURSOS
        public CursoSave(){
        setSize(300, 250); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
     
        // campo "Nome"
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 80, 25);
        //JTextField nomeField = new JTextField();
        nomeField.setBounds(100, 20, 150, 25);
        add(nomeLabel);
        add(nomeField);

        // campo "Semestres"
        JLabel qtdLabel = new JLabel("Semestres:");
        qtdLabel.setBounds(20, 60, 80, 25);
       // JTextField semestreField = new JTextField();
        semestreField.setBounds(100, 60, 150, 25);
        add(qtdLabel);
        add(semestreField);

        // botão salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(50, 180, 90, 30);
        btnSalvar.addActionListener(e -> salvarAtualizar());
        add(btnSalvar);
       } 
        
       // define o estado da tela -- cadastrar ou editar --
       public void setCurso(Curso curso){
           this.cursoEditar = curso;
           
           if (curso == null) {
            setTitle("Cadastrar Curso");
            nomeField.setText("");
            semestreField.setText("");
        }  else {
            setTitle("Editar Curso");
            nomeField.setText(curso.getNome());
            semestreField.setText(String.valueOf(curso.getSemestres()));
        }
          setVisible(true);
    }
       
       //---- método que salva ou atualiza um curso ----- 
        private void salvarAtualizar(){
            try {
            String nome = nomeField.getText();
            int semestres = Integer.parseInt(semestreField.getText());

            if (cursoEditar == null) {
                controller.save(nome, semestres);
                JOptionPane.showMessageDialog(this,"curso salvo com sucesso");
            }else {
                cursoEditar.setNome(nome);
                cursoEditar.setSemestres(semestres);
                controller.update(cursoEditar, nome, semestres);
                JOptionPane.showMessageDialog(this,"curso editado com sucesso");

           } 
            if(telaCursoListar != null){
                telaCursoListar.carregarCursos();
            }
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "erro!" + ex.getMessage());
        }
       
       }
}



    

