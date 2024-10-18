package secuenciales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm18 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtPrecioUnitario, txtCantidad;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm18 frame = new frm18();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm18() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 550, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        // Etiqueta y campo para el precio unitario
        JLabel lblPrecioUnitario = new JLabel("Precio Unitario: ");
        lblPrecioUnitario.setBounds(50, 30, 120, 30);
        getContentPane().add(lblPrecioUnitario);

        txtPrecioUnitario = new JTextField();
        txtPrecioUnitario.setBounds(180, 30, 80, 30);
        txtPrecioUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPrecioUnitario);

        // Etiqueta y campo para la cantidad
        JLabel lblCantidad = new JLabel("Cantidad: ");
        lblCantidad.setBounds(50, 70, 120, 30);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(180, 70, 80, 30);
        txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCantidad);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular Importe");
        btnCalcular.setBounds(80, 110, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularImporte();
            }
        });

        // Etiqueta para mostrar los resultados
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 150, 400, 60);
        getContentPane().add(lblResultado);
    }

    private void calcularImporte() {
        try {
            double precioUnitario = Double.parseDouble(txtPrecioUnitario.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            // Calcular el importe de la compra
            double importeCompra = precioUnitario * cantidad;

            // Aplicar el primer descuento del 15%
            double descuento1 = importeCompra * 0.15;
            double precioConDescuento1 = importeCompra - descuento1;

            // Aplicar el segundo descuento del 15%
            double descuento2 = precioConDescuento1 * 0.15;
            double importeFinal = precioConDescuento1 - descuento2;

            // Mostrar los resultados
            String resultado = String.format("Importe Compra: %.2f | Descuento: %.2f | Importe a Pagar: %.2f",
                    importeCompra, descuento1 + descuento2, importeFinal);
            lblResultado.setText(resultado);
            
            // Ajustar tamaño de la etiqueta para que se muestre todo el texto
            lblResultado.setSize(lblResultado.getPreferredSize());

        } catch (NumberFormatException e) {
            lblResultado.setText("Por favor, ingrese valores válidos."); 
        }
    }
}
