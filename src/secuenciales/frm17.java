package secuenciales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm17 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtDonacion;
    JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm17 frame = new frm17();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm17() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 750, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        
        //Etiqueta y campo para la donacion total
        JLabel lblDonacion = new JLabel("Monto de Donación Total: ");
        lblDonacion.setBounds(50, 30, 180, 30);
        getContentPane().add(lblDonacion);

        txtDonacion = new JTextField();
        txtDonacion.setBounds(220, 30, 80, 30);
        txtDonacion.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDonacion);

        // Boton de calcular

        JButton btnCalcular = new JButton("Calcular Asignaciones");
        btnCalcular.setBounds(80, 70, 200, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                calcularAsignaciones();
            }
        });

        //Etiqueta para mostrar los resultados
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 110, 300, 100);
        getContentPane().add(lblResultado);

    }

    private void calcularAsignaciones(){
        try{

            double donacionTotal = Double.parseDouble(txtDonacion.getText());

            //Calculo de montos signados 
            double montoCentroSalud = donacionTotal * 0.25;
            double montoComedorInfantil = donacionTotal * 0.35;
            double montoEscuelaInfantil = donacionTotal * 0.25;
            double montoAsilosAncianos = donacionTotal * 0.15;

            //Mostrar el resultado 

            String resultado = String.format("Centro de Salud: %.2f | Comedor Infantil: %.2f | Escuela Infantil: %.2f | Asilo de Ancianos: %.2f",
                    montoCentroSalud, montoComedorInfantil, montoEscuelaInfantil, montoAsilosAncianos);
            lblResultado.setText(resultado);
            lblResultado.setSize(lblResultado.getPreferredSize());

        }catch (NumberFormatException e) {
            lblResultado.setText("Por favor, ingrese un monto válido.");
        }
    }
}    
