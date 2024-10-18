package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCodigo, txtUnidades, txtImporte, txtDescuento, txtTotal;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm09 frame = new frm09();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm09() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 355, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiquetas y campos de texto
        JLabel lblCodigo = new JLabel("Código del Producto:");
        lblCodigo.setBounds(30, 30, 150, 30);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(200, 30, 100, 30);
        getContentPane().add(txtCodigo);

        JLabel lblUnidades = new JLabel("Cantidad de Unidades:");
        lblUnidades.setBounds(30, 70, 150, 30);
        getContentPane().add(lblUnidades);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(200, 70, 100, 30);
        getContentPane().add(txtUnidades);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 110, 100, 30);
        getContentPane().add(btnCalcular);

        JLabel lblImporte = new JLabel("Importe de Compra:");
        lblImporte.setBounds(30, 150, 150, 30);
        getContentPane().add(lblImporte);

        txtImporte = new JTextField();
        txtImporte.setBounds(200, 150, 100, 30);
        txtImporte.setFocusable(false);
        getContentPane().add(txtImporte);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 190, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 190, 100, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotal = new JLabel("Total a Pagar:");
        lblTotal.setBounds(30, 230, 150, 30);
        getContentPane().add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(200, 230, 100, 30);
        txtTotal.setFocusable(false);
        getContentPane().add(txtTotal);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCompra();
            }
        });
    }

    private void calcularCompra() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            int unidades = Integer.parseInt(txtUnidades.getText());

            double precioUnitario = 0.0;
            double porcentajeDescuento = 0.0;

            // Determinar el precio unitario y el porcentaje de descuento según el código
            switch (codigo) {
                case 101:
                    precioUnitario = 17;
                    if (unidades >= 1 && unidades <= 10) porcentajeDescuento = 0.05;
                    break;
                case 102:
                    precioUnitario = 25;
                    if (unidades >= 11 && unidades <= 20) porcentajeDescuento = 0.08;
                    break;
                case 103:
                    precioUnitario = 16;
                    if (unidades >= 21 && unidades <= 30) porcentajeDescuento = 0.10;
                    break;
                case 104:
                    precioUnitario = 27;
                    if (unidades >= 31) porcentajeDescuento = 0.13;
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Código de producto no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            // Calcular importe, descuento y total a pagar
            double importe = precioUnitario * unidades;
            double descuento = importe * porcentajeDescuento;
            double totalPagar = importe - descuento;

            // Mostrar resultados
            txtImporte.setText(String.format("S/. %.2f", importe));
            txtDescuento.setText(String.format("S/. %.2f", descuento));
            txtTotal.setText(String.format("S/. %.2f", totalPagar));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
