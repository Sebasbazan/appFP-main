package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtExamen1, txtExamen2, txtExamen3, txtPropinaTotal;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm08 frame = new frm08();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm08() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblExamen1 = new JLabel("Nota Examen 1:");
        lblExamen1.setBounds(30, 30, 150, 30);
        getContentPane().add(lblExamen1);

        txtExamen1 = new JTextField();
        txtExamen1.setBounds(200, 30, 100, 30);
        getContentPane().add(txtExamen1);

        JLabel lblExamen2 = new JLabel("Nota Examen 2:");
        lblExamen2.setBounds(30, 70, 150, 30);
        getContentPane().add(lblExamen2);

        txtExamen2 = new JTextField();
        txtExamen2.setBounds(200, 70, 100, 30);
        getContentPane().add(txtExamen2);

        JLabel lblExamen3 = new JLabel("Nota Examen 3:");
        lblExamen3.setBounds(30, 110, 150, 30);
        getContentPane().add(lblExamen3);

        txtExamen3 = new JTextField();
        txtExamen3.setBounds(200, 110, 100, 30);
        getContentPane().add(txtExamen3);

        btnCalcular = new JButton("Calcular Propina");
        btnCalcular.setBounds(200, 150, 100, 30);
        getContentPane().add(btnCalcular);

        JLabel lblPropinaTotal = new JLabel("Propina Total:");
        lblPropinaTotal.setBounds(30, 190, 150, 30);
        getContentPane().add(lblPropinaTotal);

        txtPropinaTotal = new JTextField();
        txtPropinaTotal.setBounds(200, 190, 100, 30);
        txtPropinaTotal.setFocusable(false);
        getContentPane().add(txtPropinaTotal);

        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPropinaTotal();
            }
        });
    }

    
    private void calcularPropinaTotal(){
        try{
           
            double propinaBase = 20.0;
            double propinaTotal = propinaBase;

            double examen1 = Double.parseDouble(txtExamen1.getText());
            double examen2 = Double.parseDouble(txtExamen2.getText());
            double examen3 = Double.parseDouble(txtExamen3.getText());

            
            if(examen1>=11){
                propinaTotal +=5;
            }

            if (examen2 >= 11) {
                propinaTotal += 5;
            }
            if (examen3 >= 11) {
                propinaTotal +=5;
            }

            txtPropinaTotal.setText(String.format("S/. %.2f", propinaTotal));

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese notas válidas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}