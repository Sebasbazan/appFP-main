package Recursividad;
import java.awt.*;
import javax.swing.*;

public class frm16 extends JFrame {
    private JTextField txtEntrada;
    private JTextArea txtResultado;
    private JCheckBox chkPalabras;
    
    public frm16() {
        setTitle("Invertir Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        JLabel lblTexto = new JLabel("Ingrese texto:");
        lblTexto.setBounds(50, 20, 100, 30);
        add(lblTexto);
        
        txtEntrada = new JTextField();
        txtEntrada.setBounds(150, 20, 280, 30);
        add(txtEntrada);
        
        
        chkPalabras = new JCheckBox("Invertir palabras individualmente");
        chkPalabras.setBounds(50, 60, 250, 30);
        add(chkPalabras);
        
        
        JButton btnInvertir = new JButton("Invertir Texto");
        btnInvertir.setBounds(50, 100, 180, 30);
        add(btnInvertir);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(250, 100, 180, 30);
        add(btnLimpiar);
        
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 140, 380, 200);
        add(scrollPane);
        
        
        btnInvertir.addActionListener(e -> invertirTexto());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        
        
        txtEntrada.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { actualizarVistaPrevia(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { actualizarVistaPrevia(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { actualizarVistaPrevia(); }
        });
    }
    
    private void invertirTexto() {
        String texto = txtEntrada.getText();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un texto",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        txtResultado.setText("Texto original: " + texto + "\n\n");
        
        if (chkPalabras.isSelected()) {
            String[] palabras = texto.split("\\s+");
            StringBuilder resultado = new StringBuilder();
            
            for (String palabra : palabras) {
                resultado.append(invertirRecursivo(palabra, 0, palabra.length() - 1)).append(" ");
            }
            
            txtResultado.append("Texto con palabras invertidas:\n" + resultado.toString().trim());
        } else {
            String invertido = invertirRecursivo(texto, 0, texto.length() - 1);
            txtResultado.append("Texto invertido:\n" + invertido);
        }
        
        
        analizarTexto(texto);
    }
    
    private String invertirRecursivo(String texto, int inicio, int fin) {
        
        if (inicio >= fin) {
            return texto.substring(inicio, inicio + 1);
        }
        
        
        return texto.charAt(fin) + 
               invertirRecursivo(texto, inicio, fin - 1);
    }
    
    private void analizarTexto(String texto) {
        txtResultado.append("\n\nAnálisis del texto:");
        txtResultado.append("\n- Longitud: " + texto.length() + " caracteres");
        txtResultado.append("\n- Palabras: " + contarPalabrasRecursivo(texto.trim(), 0));
        txtResultado.append("\n- Vocales: " + contarVocalesRecursivo(texto.toLowerCase(), 0));
        txtResultado.append("\n- Consonantes: " + contarConsonantesRecursivo(texto.toLowerCase(), 0));
    }
    
    private int contarPalabrasRecursivo(String texto, int indice) {
        
        if (indice >= texto.length()) {
            return 0;
        }
        
        
        if (texto.charAt(indice) == ' ' && indice + 1 < texto.length()) {
            return 1 + contarPalabrasRecursivo(texto, indice + 1);
        }
        
        return contarPalabrasRecursivo(texto, indice + 1);
    }
    
    private int contarVocalesRecursivo(String texto, int indice) {
        if (indice >= texto.length()) {
            return 0;
        }
        
        char c = texto.charAt(indice);
        int esVocal = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        
        return esVocal + contarVocalesRecursivo(texto, indice + 1);
    }
    
    private int contarConsonantesRecursivo(String texto, int indice) {
        if (indice >= texto.length()) {
            return 0;
        }
        
        char c = texto.charAt(indice);
        int esConsonante = (Character.isLetter(c) && 
                           "aeiou".indexOf(c) == -1) ? 1 : 0;
        
        return esConsonante + contarConsonantesRecursivo(texto, indice + 1);
    }
    
    private void actualizarVistaPrevia() {
        String texto = txtEntrada.getText();
        if (!texto.isEmpty()) {
            invertirTexto();
        } else {
            txtResultado.setText("");
        }
    }
    
    private void limpiarCampos() {
        txtEntrada.setText("");
        txtResultado.setText("");
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm16 frame = new frm16();
            frame.setVisible(true);
        });
    }
}
