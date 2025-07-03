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
import jakarta.persistence.*;
import java.util.List;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.CursoSave;


public class CursoListar extends JFrame {
    
        private JTable tabela;
        private DefaultTableModel modelo;

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

       // carregarCursos();

       
       // BOTÕES DE AÇÃO -----------------
        btnRemover.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um curso.");
                return;
            }

            Long id = (Long) modelo.getValueAt(linha, 0);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();

            try {
                Curso curso = em.find(Curso.class, id);
                int confirmar = JOptionPane.showConfirmDialog(this,
                    "Remover o curso \"" + curso.getNome() + "\"?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);

                if (confirmar == JOptionPane.YES_OPTION) {
                    em.getTransaction().begin();
                    em.remove(curso);
                    em.getTransaction().commit();
                    modelo.removeRow(linha);
                    JOptionPane.showMessageDialog(this, "Curso removido!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            } finally {
                em.close();
                emf.close();
            }
        });

        btnEditar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um curso.");
                return;
            }

            Long id = (Long) modelo.getValueAt(linha, 0);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();

            try {
                Curso curso = em.find(Curso.class, id);
                String novoNome = JOptionPane.showInputDialog("Nome:", curso.getNome());
                String novoSemestre = JOptionPane.showInputDialog("Semestres:", curso.getSemestres());

                if (novoNome != null && novoSemestre != null) {
                    em.getTransaction().begin();
                    curso.setNome(novoNome);
                    curso.setSemestres(Integer.parseInt(novoSemestre));
                    em.merge(curso);
                    em.getTransaction().commit();

                    modelo.setValueAt(novoNome, linha, 1);
                    modelo.setValueAt(Integer.parseInt(novoSemestre), linha, 2);
                    JOptionPane.showMessageDialog(this, "Curso atualizado!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            } finally {
                em.close();
                emf.close();
            }
        });

        setVisible(true);
    }

    // método
    private void carregarCursos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        List<Curso> cursos = em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();

        for (Curso c : cursos) {
            modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getSemestres()});
        }

        em.close();
        emf.close();
    }
    

    // exibe a tela
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CursoListar());
}
}





