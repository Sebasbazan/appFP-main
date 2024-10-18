package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm29 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHorasTrabajadas;
    private JTextField txtTarifaHora;
    private JTextField txtSueldoBruto;
    private JTextField txtDescuento;
    private JTextField txtTotalAPagar;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm29 frame = new frm29();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm29() {
        // Configuración de la ventana
        setTitle("Cálculo de Sueldo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 330);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo de texto para horas trabajadas
        JLabel lblHorasTrabajadas = new JLabel("Horas trabajadas:");
        lblHorasTrabajadas.setBounds(30, 30, 150, 30);
        getContentPane().add(lblHorasTrabajadas);

        txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(180, 30, 100, 30);
        getContentPane().add(txtHorasTrabajadas);

        // Etiqueta y campo de texto para tarifa por hora
        JLabel lblTarifaHora = new JLabel("Tarifa por hora:");
        lblTarifaHora.setBounds(30, 70, 150, 30);
        getContentPane().add(lblTarifaHora);

        txtTarifaHora = new JTextField();
        txtTarifaHora.setBounds(180, 70, 100, 30);
        getContentPane().add(txtTarifaHora);

        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(180, 110, 100, 30);
        getContentPane().add(btnCalcular);

        
        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(30, 150, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(180, 150, 100, 30);
        txtSueldoBruto.setFocusable(false);
        getContentPane().add(txtSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 190, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 190, 100, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotalAPagar = new JLabel("Total a Pagar:");
        lblTotalAPagar.setBounds(30, 230, 150, 30);
        getContentPane().add(lblTotalAPagar);

        txtTotalAPagar = new JTextField();
        txtTotalAPagar.setBounds(180, 230, 100, 30);
        txtTotalAPagar.setFocusable(false);
        getContentPane().add(txtTotalAPagar);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        try {
            int horasTrabajadas = Integer.parseInt(txtHorasTrabajadas.getText());
            double tarifaHora = Double.parseDouble(txtTarifaHora.getText());

            if (horasTrabajadas < 0 || tarifaHora < 0) {
                throw new IllegalArgumentException();
            }

        
            double sueldoBruto;
            if (horasTrabajadas <= 48) {
                sueldoBruto = horasTrabajadas * tarifaHora;
            } else {
                double horasExtras = horasTrabajadas - 48;
                sueldoBruto = (48 * tarifaHora) + (horasExtras * tarifaHora * 1.2);
            }

            
            double descuento = 0;
            if (sueldoBruto > 1500) {
                descuento = sueldoBruto * 0.11; 
            }

           
            double totalAPagar = sueldoBruto - descuento;

            
            txtSueldoBruto.setText(String.format("%.2f", sueldoBruto));
            txtDescuento.setText(String.format("%.2f", descuento));
            txtTotalAPagar.setText(String.format("%.2f", totalAPagar));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Las horas y la tarifa deben ser mayores a cero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}