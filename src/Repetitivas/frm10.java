package Repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea txtResultado;
    private JButton btnMostrar;

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
        setTitle("Números de 4 cifras con suma de pares e impares iguales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        btnMostrar = new JButton("Mostrar Números");
        btnMostrar.setBounds(30, 30, 200, 30);
        getContentPane().add(btnMostrar);

        txtResultado = new JTextArea();
        txtResultado.setBounds(30, 80, 420, 250);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarNumeros();
            }
        });
    }

    private void mostrarNumeros() {
        StringBuilder resultado = new StringBuilder();
        int contador = 0;

        for (int i = 1000; i <= 9999; i++) {
            int sumaPares = 0;
            int sumaImpares = 0;
            int numero = i;

            while (numero > 0) {
                int digito = numero % 10;
                if (digito % 2 == 0) {
                    sumaPares += digito;
                } else {
                    sumaImpares += digito;
                }
                numero /= 10;
            }

            if (sumaPares == sumaImpares) {
                resultado.append(i).append("\n");
                contador++;
            }
        }

        resultado.append("\nCantidad de números encontrados: ").append(contador);
        txtResultado.setText(resultado.toString());
    }

}