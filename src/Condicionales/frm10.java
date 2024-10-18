package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField[] txtNotas;
    private JTextField txtNotaMayor, txtNotaMenor, txtPromedio;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm10 frame = new frm10();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm10() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 335, 430);
        setLayout(null);
        setLocationRelativeTo(null);

        // Crear campos de texto para las notas
        txtNotas = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            JLabel lblNota = new JLabel("Nota " + (i + 1) + ":");
            lblNota.setBounds(30, 30 + (i * 30), 150, 30);
            getContentPane().add(lblNota);

            txtNotas[i] = new JTextField();
            txtNotas[i].setBounds(200, 30 + (i * 30), 100, 30);
            getContentPane().add(txtNotas[i]);
        }

        btnCalcular = new JButton("Calcular Promedio");
        btnCalcular.setBounds(200, 200, 100, 30);
        getContentPane().add(btnCalcular);

        JLabel lblNotaMayor = new JLabel("Nota Mayor:");
        lblNotaMayor.setBounds(30, 240, 150, 30);
        getContentPane().add(lblNotaMayor);

        txtNotaMayor = new JTextField();
        txtNotaMayor.setBounds(200, 240, 100, 30);
        txtNotaMayor.setFocusable(false);
        getContentPane().add(txtNotaMayor);

        JLabel lblNotaMenor = new JLabel("Nota Menor:");
        lblNotaMenor.setBounds(30, 270, 150, 30);
        getContentPane().add(lblNotaMenor);

        txtNotaMenor = new JTextField();
        txtNotaMenor.setBounds(200, 270, 100, 30);
        txtNotaMenor.setFocusable(false);
        getContentPane().add(txtNotaMenor);

        JLabel lblPromedio = new JLabel("Promedio Aprobatorio:");
        lblPromedio.setBounds(30, 300, 150, 30);
        getContentPane().add(lblPromedio);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(200, 300, 100, 30);
        txtPromedio.setFocusable(false);
        getContentPane().add(txtPromedio);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPromedio();
            }
        });
    }

    private void calcularPromedio() {
        try {
            double[] notas = new double[5];

            // Leer las notas desde los campos de texto
            for (int i = 0; i < 5; i++) {
                notas[i] = Double.parseDouble(txtNotas[i].getText());
            }

            // Calcular la nota mayor y menor
            double notaMayor = Arrays.stream(notas).max().getAsDouble();
            double notaMenor = Arrays.stream(notas).min().getAsDouble();

            // Mostrar las notas eliminadas
            txtNotaMayor.setText(String.valueOf(notaMayor));
            txtNotaMenor.setText(String.valueOf(notaMenor));

            // Calcular el promedio de las tres notas restantes
            double suma = 0.0;
            int count = 0;
            for (double nota : notas) {
                if (nota != notaMayor && nota != notaMenor) {
                    suma += nota;
                    count++;
                }
            }
            double promedio = suma / count;

            // Mostrar el promedio
            txtPromedio.setText(String.format("%.2f", promedio));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese notas válidas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}