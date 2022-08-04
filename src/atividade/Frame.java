package atividade;

/**
 *
 * @author Jv Loreti
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame{
    TextArea textArea;
    AreaDeFormulario areaDeFormulario;
    
    public Frame(){
        //Define as dimensões
        super.setSize(1200, 500);
        
        //Define o layout
        super.setLayout(new BorderLayout());
        
        //Inicializa a área de texto
        textArea = new TextArea();
        //Define a posição da área de texto
        super.add(textArea, BorderLayout.EAST);
        
        //Inicializa a área de formulário
        areaDeFormulario = new AreaDeFormulario();
        //Implementa a área de formulário
        super.add(areaDeFormulario);
        
        //Comunicação entre a área de formulário e de texto
        areaDeFormulario.setFormularioListener(new FormularioListener(){
            @Override
            public void enviarFormulario(String nome, String endereco, String cidade, String estado, String sexo, boolean LPVS2, boolean POOS3, boolean DSIS4){
                if(!nome.isEmpty() && !endereco.isEmpty() && !cidade.isEmpty() && !estado.isEmpty() && !sexo.isEmpty() 
                        && LPVS2 != false || POOS3 != false || DSIS4 != false){ //Valida se os campos do formulário não estão vazios
                    textArea.escreverTexto("Nome: " + nome + "\n" +
                                           "Endereço: " + endereco + "\n" +
                                           "Cidade: " +  cidade +
                                           ", " + estado + "\n" +
                                           "Sexo: " + sexo);
                                            if(LPVS2 == true){
                                                textArea.escreverTexto("\nMatriculado(a) em LPVS2.");
                                            }
                                            if(POOS3 == true){
                                                textArea.escreverTexto("\nMatriculado(a) em POOS3.");
                                            }
                                            if(DSIS4 == true){
                                                textArea.escreverTexto("\nMatriculado(a) em DSIS4.");
                                            }
                                           textArea.escreverTexto("\n\n");
                }
            }
        });
        
        //Exibe o JFrame
        super.setVisible(true);
        //Encerra a operação ao fechar o JFrame
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
