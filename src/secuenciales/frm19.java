package secuenciales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm19 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtMontoVendido;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm19 frame = new frm19();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm19() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 270);
        setLocationRelativeTo(null);
        setLayout(null);

        // Etiqueta y campo para el monto vendido
        JLabel lblMontoVendido = new JLabel("Monto Total Vendido: ");
        lblMontoVendido.setBounds(50, 30, 180, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(220, 30, 80, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMontoVendido);

        // Botón de calcular 
        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(80, 70, 200, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });

        // Etiqueta para mostrar los resultados 
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 100, 400, 100);
        getContentPane().add(lblResultado);
    }

    private void calcularSueldo() {
        try {
            double montoVendido = Double.parseDouble(txtMontoVendido.getText());
            double sueldoBasico = 500.00;
            double comision = montoVendido * 0.09;

            double sueldoBruto = sueldoBasico + comision;
            double descuento = sueldoBruto * 0.11;
            double sueldoNeto = sueldoBruto - descuento;

            // Mostrar el resultado 
            String resultado = String.format("Comisión: %.2f | Sueldo Bruto: %.2f | Descuento: %.2f | Sueldo Neto: %.2f",
                    comision, sueldoBruto, descuento, sueldoNeto);
            lblResultado.setText(resultado);
            lblResultado.setSize(lblResultado.getPreferredSize());

        } catch (NumberFormatException e) {
            lblResultado.setText("Por favor, ingrese un monto válido.");
        }
    }
}
