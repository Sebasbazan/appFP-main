package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm30 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCuota;
    private JTextField txtDiaPago;
    private JTextField txtMontoAPagar;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm30 frame = new frm30();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm30() {
        // Configuración de la ventana
        setTitle("Cálculo de Cuotas Mensuales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para la cuota
        JLabel lblCuota = new JLabel("Cuota Mensual:");
        lblCuota.setBounds(30, 30, 150, 30);
        getContentPane().add(lblCuota);

        txtCuota = new JTextField();
        txtCuota.setBounds(180, 30, 100, 30);
        getContentPane().add(txtCuota);

        // Etiqueta y campo de texto para el día de pago
        JLabel lblDiaPago = new JLabel("Día de Pago:");
        lblDiaPago.setBounds(30, 70, 150, 30);
        getContentPane().add(lblDiaPago);

        txtDiaPago = new JTextField();
        txtDiaPago.setBounds(180, 70, 100, 30);
        getContentPane().add(txtDiaPago);

        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(180, 110, 100, 30);
        getContentPane().add(btnCalcular);

        // Etiqueta y campo de texto para el monto a pagar
        JLabel lblMontoAPagar = new JLabel("Monto a Pagar:");
        lblMontoAPagar.setBounds(30, 150, 150, 30);
        getContentPane().add(lblMontoAPagar);

        txtMontoAPagar = new JTextField();
        txtMontoAPagar.setBounds(180, 150, 100, 30);
        txtMontoAPagar.setFocusable(false);
        getContentPane().add(txtMontoAPagar);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMonto();
            }
        });
    }

    private void calcularMonto(){
        try{
            double cuota = Double.parseDouble(txtCuota.getText());
            int diaPago = Integer.parseInt(txtDiaPago.getText());

            if (cuota < 0 || diaPago < 1 || diaPago > 31) {
                throw new IllegalArgumentException();
            }

            double montoAPagar;

            if ( diaPago <= 10 ){
                double descuento = Math.max(5, cuota * 0.02);
                montoAPagar = cuota - descuento;
            }else if (diaPago <= 20){
                montoAPagar = cuota ;
            }else{
                double recargo = Math.max(10, cuota * 0.03);
                montoAPagar = cuota + recargo;
            }

            txtMontoAPagar.setText(String.format("%.2f", montoAPagar));
            
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, "La cuota debe ser mayor o igual a 0 y el día de pago debe ser válido (1-31).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
