package Recursividad;
import java.awt.*;
import javax.swing.*;

public class frm17 extends JFrame {
    private JTextField txtEntrada;
    private JTextField txtBuscar;
    private JTextArea txtResultado;
    private JCheckBox chkSubcadena;

    public frm17() {
        setTitle("Buscar Índice con Recursividad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTexto = new JLabel("Ingrese texto:");
        lblTexto.setBounds(50, 20, 100, 30);
        add(lblTexto);

        txtEntrada = new JTextField();
        txtEntrada.setBounds(150, 20, 380, 30);
        add(txtEntrada);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(50, 60, 100, 30);
        add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(150, 60, 150, 30);
        add(txtBuscar);

        chkSubcadena = new JCheckBox("Buscar subcadena");
        chkSubcadena.setBounds(320, 60, 150, 30);
        add(chkSubcadena);

        JButton btnBuscar = new JButton("Buscar Índice");
        btnBuscar.setBounds(50, 100, 180, 30);
        add(btnBuscar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(250, 100, 180, 30);
        add(btnLimpiar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 140, 480, 250);
        add(scrollPane);

        
        btnBuscar.addActionListener(e -> buscarIndice());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void buscarIndice() {
        String texto = txtEntrada.getText();
        String buscar = txtBuscar.getText();

        if (texto.isEmpty() || buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese texto y el término a buscar",
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        txtResultado.setText("Texto original: " + texto + "\n\n");

        if (chkSubcadena.isSelected()) {
            int indice = indexOfSubstringRecursivo(texto, buscar, 0);
            txtResultado.append("Índice de la subcadena '" + buscar + "': " + indice);
        } else {
            char caracter = buscar.charAt(0);
            int indice = indexOfCharRecursivo(texto, caracter, 0);
            txtResultado.append("Índice del carácter '" + caracter + "': " + indice);
        }
    }

    private int indexOfCharRecursivo(String texto, char caracter, int indice) {
        if (indice >= texto.length()) {
            return -1; 
        }

        if (texto.charAt(indice) == caracter) {
            return indice;
        }

        return indexOfCharRecursivo(texto, caracter, indice + 1);
    }

    private int indexOfSubstringRecursivo(String texto, String subcadena, int indice) {
        if (indice > texto.length() - subcadena.length()) {
            return -1; 
        }

        if (texto.substring(indice, indice + subcadena.length()).equals(subcadena)) {
            return indice;
        }

        return indexOfSubstringRecursivo(texto, subcadena, indice + 1);
    }

    private void limpiarCampos() {
        txtEntrada.setText("");
        txtBuscar.setText("");
        txtResultado.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm17 frame = new frm17();
            frame.setVisible(true);
        });
    }
}
