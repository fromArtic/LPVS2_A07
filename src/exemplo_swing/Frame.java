package exemplo_swing;

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
        super.setSize(900, 500);
        
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
            public void enviarFormulario(String n, String o, String i, String s, boolean estr, String p, String g){
                if(!n.isEmpty() && !o.isEmpty()){ //Valida se os campos do formulário não estão vazios
                    textArea.escreverTexto(n + " - " + i + " - " +  g + " - " + s + " - " + o + " - " + p + "\n");
                }
            }
        });
        
        //Exibe o JFrame
        super.setVisible(true);
        //Encerra a operação ao fechar o JFrame
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
