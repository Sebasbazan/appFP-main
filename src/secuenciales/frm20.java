package secuenciales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm20 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtCantidad;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm20 frame = new frm20();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm20() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 250);
        setLocationRelativeTo(null);
        setLayout(null);

      
        JLabel lblCantidad = new JLabel("Cantidad en Soles: ");
        lblCantidad.setBounds(50, 30, 150, 30);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(220, 30, 80, 30);
        txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCantidad);

        
        JButton btnCalcular = new JButton("Descomponer");
        btnCalcular.setBounds(80, 70, 200, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                descomponerCantidad();
            }
        });

       
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 110, 400, 100);
        getContentPane().add(lblResultado);
    }

    private void descomponerCantidad() {
        try {
            double cantidad = Double.parseDouble(txtCantidad.getText());
            int cantidadEntera = (int) cantidad;

            
            int[] billetes = {200, 100, 50, 20, 10};
            int[] monedas = {5, 2, 1};
            StringBuilder resultado = new StringBuilder("Billetes y Monedas: ");

            
            for (int billete : billetes) {
                int cantidadBilletes = cantidadEntera / billete;
                if (cantidadBilletes > 0) {
                    resultado.append(cantidadBilletes).append(" billete(s) de ").append(billete).append(" | ");
                    cantidadEntera %= billete;
                }
            }

            
            for (int moneda : monedas) {
                int cantidadMonedas = cantidadEntera / moneda;
                if (cantidadMonedas > 0) {
                    resultado.append(cantidadMonedas).append(" moneda(s) de ").append(moneda).append(" | ");
                    cantidadEntera %= moneda;
                }
            }

            lblResultado.setText(resultado.toString());
            lblResultado.setSize(lblResultado.getPreferredSize());
        } catch (NumberFormatException e) {
            lblResultado.setText("Por favor, ingrese un monto válido.");
        }
    }
}
