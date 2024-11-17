package Repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JTextField txtInicio;
    private JTextField txtFin;
    private JTextArea txtResultado;
    private JButton btnGenerar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm06 frame = new frm06();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm06() {
        setTitle("Generador de Tablas de Multiplicar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número (n):");
        lblNumero.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNumero);

        JLabel lblInicio = new JLabel("Tabla desde (x):");
        lblInicio.setBounds(30, 70, 150, 30);
        getContentPane().add(lblInicio);

        txtInicio = new JTextField();
        txtInicio.setBounds(200, 70, 150, 30);
        getContentPane().add(txtInicio);

        JLabel lblFin = new JLabel("Tabla hasta (y):");
        lblFin.setBounds(30, 110, 150, 30);
        getContentPane().add(lblFin);

        txtFin = new JTextField();
        txtFin.setBounds(200, 110, 150, 30);
        getContentPane().add(txtFin);

        btnGenerar = new JButton("Generar Tabla");
        btnGenerar.setBounds(200, 150, 150, 30);
        getContentPane().add(btnGenerar);

        txtResultado = new JTextArea();
        txtResultado.setBounds(30, 200, 350, 150);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarTablaMultiplicar();
            }
        });
    }

    private void generarTablaMultiplicar(){
        try{
            int n = Integer.parseInt(txtNumero.getText());
            int x = Integer.parseInt(txtInicio.getText());
            int y = Integer.parseInt(txtFin.getText());

            if ( x > y){
                JOptionPane.showMessageDialog(this, "El valor de inicio (x) debe ser menor o igual al de fin (y).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder resultado = new StringBuilder();
            for( int i = x; i <= y; i++){
                resultado.append(n).append("x").append(i).append("=").append(n*i).append("\n");
            }

            txtResultado.setText(resultado.toString());

        }catch ( NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
