/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

/**
 *
 * @author waria
 */
import br.com.ifba.curso.view.CursoListar;
import javax.swing.SwingUtilities;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author waria
 */
@SpringBootApplication//(scanBasePackages = "br.com.ifba")
public class Prg03springApplication {
    public static void main(String[] args) {
        
       // -- tratamento de exceções que permitiu a descoberta de erros --
       //    trecho de código sugerido e implementado pelo Copilot(IA)
       try {
           ConfigurableApplicationContext context =
           new SpringApplicationBuilder(Prg03springApplication.class).headless(false).run(args);

           System.out.println("Spring iniciado. Tentando pegar bean CursoListar...");
    
           CursoListar telaCursoListar = context.getBean(CursoListar.class);
           System.out.println("Bean recuperado: " + telaCursoListar);

           SwingUtilities.invokeLater(() -> {
           telaCursoListar.setLocationRelativeTo(null);
           telaCursoListar.setVisible(true);
    });
}    catch (Exception e) {
           System.out.println("Erro ao iniciar Spring ou recuperar bean:");
           e.printStackTrace();
}        
}
}
