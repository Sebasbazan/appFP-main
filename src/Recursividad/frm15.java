package Recursividad;
import java.awt.*;
import javax.swing.*;

public class frm15 extends JFrame {
    private JTextField txtEntrada;
    private JTextArea txtResultado;
    
    public frm15() {
        setTitle("Convertidor de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        
        // Panel de entrada
        JLabel lblTexto = new JLabel("Ingrese texto:");
        lblTexto.setBounds(50, 20, 100, 30);
        add(lblTexto);
        
        txtEntrada = new JTextField();
        txtEntrada.setBounds(150, 20, 280, 30);
        add(txtEntrada);
        
        // Botones de conversión
        JButton btnMayusculas = new JButton("Convertir a Mayúsculas");
        btnMayusculas.setBounds(50, 60, 180, 30);
        add(btnMayusculas);
        
        JButton btnMinusculas = new JButton("Convertir a Minúsculas");
        btnMinusculas.setBounds(250, 60, 180, 30);
        add(btnMinusculas);
        
        JButton btnAlternado = new JButton("Texto Alternado");
        btnAlternado.setBounds(50, 100, 180, 30);
        add(btnAlternado);
        
        JButton btnCapitalizar = new JButton("Capitalizar");
        btnCapitalizar.setBounds(250, 100, 180, 30);
        add(btnCapitalizar);
        
        // Área de resultados
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 140, 380, 200);
        add(scrollPane);
        
        // Manejadores de eventos
        btnMayusculas.addActionListener(e -> convertirTexto(1));
        btnMinusculas.addActionListener(e -> convertirTexto(2));
        btnAlternado.addActionListener(e -> convertirTexto(3));
        btnCapitalizar.addActionListener(e -> convertirTexto(4));
    }
    
    private void convertirTexto(int opcion) {
        String texto = txtEntrada.getText();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un texto",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        txtResultado.setText("Texto original: " + texto + "\n\n");
        String resultado = "";
        
        switch(opcion) {
            case 1: // Mayúsculas
                resultado = convertirMayusculasRecursivo(texto, 0);
                txtResultado.append("Texto en mayúsculas:\n" + resultado);
                break;
                
            case 2: // Minúsculas
                resultado = convertirMinusculasRecursivo(texto, 0);
                txtResultado.append("Texto en minúsculas:\n" + resultado);
                break;
                
            case 3: // Alternado
                resultado = convertirAlternadoRecursivo(texto, 0, true);
                txtResultado.append("Texto alternado:\n" + resultado);
                break;
                
            case 4: // Capitalizar
                resultado = capitalizarRecursivo(texto, 0, true);
                txtResultado.append("Texto capitalizado:\n" + resultado);
                break;
        }
    }
    
    private String convertirMayusculasRecursivo(String texto, int indice) {
        // Caso base: llegamos al final del texto
        if (indice >= texto.length()) {
            return "";
        }
        
        // Convertir el carácter actual y concatenar con el resto
        return Character.toUpperCase(texto.charAt(indice)) + 
               convertirMayusculasRecursivo(texto, indice + 1);
    }
    
    private String convertirMinusculasRecursivo(String texto, int indice) {
        if (indice >= texto.length()) {
            return "";
        }
        
        return Character.toLowerCase(texto.charAt(indice)) + 
               convertirMinusculasRecursivo(texto, indice + 1);
    }
    
    private String convertirAlternadoRecursivo(String texto, int indice, boolean mayuscula) {
        if (indice >= texto.length()) {
            return "";
        }
        
        char caracterActual = mayuscula ? 
            Character.toUpperCase(texto.charAt(indice)) : 
            Character.toLowerCase(texto.charAt(indice));
        
        return caracterActual + 
               convertirAlternadoRecursivo(texto, indice + 1, !mayuscula);
    }
    
    private String capitalizarRecursivo(String texto, int indice, boolean capitalizar) {
        if (indice >= texto.length()) {
            return "";
        }
        
        char caracterActual = texto.charAt(indice);
        if (capitalizar && Character.isLetter(caracterActual)) {
            caracterActual = Character.toUpperCase(caracterActual);
        } else {
            caracterActual = Character.toLowerCase(caracterActual);
        }
        
        
        boolean siguienteCapitalizar = caracterActual == ' ' || caracterActual == '.' || 
                                     caracterActual == '!' || caracterActual == '?';
        
        return caracterActual + 
               capitalizarRecursivo(texto, indice + 1, siguienteCapitalizar);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm15 frame = new frm15();
            frame.setVisible(true);
        });
    }
}