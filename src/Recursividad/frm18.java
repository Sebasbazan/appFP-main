package Recursividad;
import java.awt.*;
import javax.swing.*;

public class frm18 extends JFrame {
    private JTextField txtEntrada;
    private JTextArea txtResultado;

    public frm18() {
        setTitle("Métodos Recursivos de Trim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTexto = new JLabel("Ingrese texto:");
        lblTexto.setBounds(50, 20, 100, 30);
        add(lblTexto);

        txtEntrada = new JTextField();
        txtEntrada.setBounds(150, 20, 380, 30);
        add(txtEntrada);

        JButton btnProcesar = new JButton("Aplicar Trims");
        btnProcesar.setBounds(50, 70, 180, 30);
        add(btnProcesar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(250, 70, 180, 30);
        add(btnLimpiar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(50, 120, 480, 200);
        add(scrollPane);

        
        btnProcesar.addActionListener(e -> aplicarTrims());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void aplicarTrims() {
        String texto = txtEntrada.getText();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un texto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        txtResultado.setText("Texto original: [" + texto + "]\n\n");
        txtResultado.append("ltrim(): [" + ltrimRecursivo(texto, 0) + "]\n");
        txtResultado.append("rtrim(): [" + rtrimRecursivo(texto, texto.length() - 1) + "]\n");
        txtResultado.append("alltrim(): [" + alltrimRecursivo(texto) + "]\n");
    }

    private String ltrimRecursivo(String texto, int indice) {
        if (indice >= texto.length() || texto.charAt(indice) != ' ') {
            return texto.substring(indice);
        }
        return ltrimRecursivo(texto, indice + 1);
    }

    private String rtrimRecursivo(String texto, int indice) {
        if (indice < 0 || texto.charAt(indice) != ' ') {
            return texto.substring(0, indice + 1);
        }
        return rtrimRecursivo(texto, indice - 1);
    }

    private String alltrimRecursivo(String texto) {
        return rtrimRecursivo(ltrimRecursivo(texto, 0), texto.length() - 1);
    }

    private void limpiarCampos() {
        txtEntrada.setText("");
        txtResultado.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm17 frame = new frm17();
            frame.setVisible(true);
        });
    }
}

