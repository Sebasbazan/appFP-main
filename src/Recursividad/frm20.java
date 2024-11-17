package Recursividad;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class frm20 extends JFrame {
    private JTextField[] txtNumeros;
    private JTextArea txtResultado;
    private JButton btnCalcular, btnLimpiar;

    public frm20() {
        setTitle("Menor, Mayor y Promedio de 10 Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblInstruccion = new JLabel("Ingrese 10 números:");
        lblInstruccion.setBounds(20, 10, 200, 30);
        add(lblInstruccion);

        
        txtNumeros = new JTextField[10];
        for (int i = 0; i < 10; i++) {
            txtNumeros[i] = new JTextField();
            txtNumeros[i].setBounds(20, 50 + (i * 30), 100, 25);
            add(txtNumeros[i]);
        }

        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 50, 120, 30);
        add(btnCalcular);

        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(150, 90, 120, 30);
        add(btnLimpiar);

        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(20, 350, 340, 100);
        add(scrollPane);

        
        btnCalcular.addActionListener(e -> calcularResultados());

        
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void calcularResultados() {
        try {
            int[] numeros = new int[10];
            for (int i = 0; i < 10; i++) {
                numeros[i] = Integer.parseInt(txtNumeros[i].getText().trim());
            }

            int menor = Arrays.stream(numeros).min().orElse(0);
            int mayor = Arrays.stream(numeros).max().orElse(0);
            double promedio = Arrays.stream(numeros).average().orElse(0);

            txtResultado.setText("Resultados:\n");
            txtResultado.append("Menor: " + menor + "\n");
            txtResultado.append("Mayor: " + mayor + "\n");
            txtResultado.append("Promedio: " + promedio + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese números válidos en todos los campos.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        for (JTextField txtNumero : txtNumeros) {
            txtNumero.setText("");
        }
        txtResultado.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frm20 frame = new frm20();
            frame.setVisible(true);
        });
    }
}
