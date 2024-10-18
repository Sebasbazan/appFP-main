package Condicionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm22 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCantidadA;
    private JTextField txtCantidadB;
    private JTextField txtImporteBruto;
    private JTextField txtDescuento;
    private JTextField txtTotalPagar;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm22 frame = new frm22();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm22() {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

    
        JLabel lblCantidadA = new JLabel("Cantidad Producto A:");
        lblCantidadA.setBounds(30, 30, 150, 30);
        getContentPane().add(lblCantidadA);

        txtCantidadA = new JTextField();
        txtCantidadA.setBounds(200, 30, 150, 30);
        getContentPane().add(txtCantidadA);

     
        JLabel lblCantidadB = new JLabel("Cantidad Producto B:");
        lblCantidadB.setBounds(30, 70, 150, 30);
        getContentPane().add(lblCantidadB);

        txtCantidadB = new JTextField();
        txtCantidadB.setBounds(200, 70, 150, 30);
        getContentPane().add(txtCantidadB);

       
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);

      
        JLabel lblImporteBruto = new JLabel("Importe Bruto:");
        lblImporteBruto.setBounds(30, 150, 150, 30);
        getContentPane().add(lblImporteBruto);

        txtImporteBruto = new JTextField();
        txtImporteBruto.setBounds(200, 150, 150, 30);
        txtImporteBruto.setFocusable(false);
        getContentPane().add(txtImporteBruto);

    
        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(30, 190, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 190, 150, 30);
        txtDescuento.setFocusable(false);
        getContentPane().add(txtDescuento);

        
        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(30, 230, 150, 30);
        getContentPane().add(lblTotalPagar);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(200, 230, 150, 30);
        txtTotalPagar.setFocusable(false);
        getContentPane().add(txtTotalPagar);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCompra();
            }
        });
    }


    private void calcularCompra() {
        try {
            int cantidadA = Integer.parseInt(txtCantidadA.getText());
            int cantidadB = Integer.parseInt(txtCantidadB.getText());

           
            double precioA = 25.0;
            double precioB = 30.0;

            
            double importeBrutoA = cantidadA * precioA;
            double importeBrutoB = cantidadB * precioB;
            double importeBrutoTotal = importeBrutoA + importeBrutoB;

        
            double descuentoA = 0;
            if (cantidadA > 50) {
                descuentoA = importeBrutoA * 0.15;
            }

        
            double descuentoB = 0;
            if (cantidadB > 60) {
                descuentoB = importeBrutoB * 0.10;
            }

         
            double descuentoTotal = descuentoA + descuentoB;

           
            double totalPagar = importeBrutoTotal - descuentoTotal;

         
            txtImporteBruto.setText(String.format("%.2f", importeBrutoTotal));
            txtDescuento.setText(String.format("%.2f", descuentoTotal));
            txtTotalPagar.setText(String.format("%.2f", totalPagar));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}