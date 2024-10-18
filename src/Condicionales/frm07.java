package Condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNum1, txtNum2, txtNum3, txtIntermedio;
    private JButton btnCalcular;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm07 frame = new frm07();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public frm07() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiquetas y campos de texto
        JLabel lblNum1 = new JLabel("Número 1:");
        lblNum1.setBounds(30, 30, 100, 30);
        getContentPane().add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(200, 30, 100, 30);
        getContentPane().add(txtNum1);

        JLabel lblNum2 = new JLabel("Número 2:");
        lblNum2.setBounds(30, 70, 100, 30);
        getContentPane().add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(200, 70, 100, 30);
        getContentPane().add(txtNum2);

        JLabel lblNum3 = new JLabel("Número 3:");
        lblNum3.setBounds(30, 110, 100, 30);
        getContentPane().add(lblNum3);

        txtNum3 = new JTextField();
        txtNum3.setBounds(200, 110, 100, 30);
        getContentPane().add(txtNum3);

        btnCalcular = new JButton("Calcular Intermedio");
        btnCalcular.setBounds(200, 150, 100, 30);
        getContentPane().add(btnCalcular);

        JLabel lblIntermedio = new JLabel("Número Intermedio:");
        lblIntermedio.setBounds(30, 190, 100, 30);
        getContentPane().add(lblIntermedio);

        txtIntermedio = new JTextField();
        txtIntermedio.setBounds(200, 190, 100, 30);
        txtIntermedio.setFocusable(false);
        getContentPane().add(txtIntermedio);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularNumeroIntermedio();
            }
        });
    }

    //metodo para calcular el numero intermedio 
    private void calcularNumeroIntermedio(){
        try{
            int num1 = Integer.parseInt(txtNum1.getText());
            int num2 = Integer.parseInt(txtNum2.getText());
            int num3 = Integer.parseInt(txtNum3.getText());

            int mayor = Math.max(num1, Math.max(num2, num3));
            int menor = Math.min(num1, Math.min(num2, num3));

            //EL INTERMEDIO SE OBTIENE RESTANDO LA SUMA DE LOS TRES NUMERO MENOS EL MAYOR Y MENOR 
            int intermedio = (num1 + num2 + num3) - mayor - menor;

            txtIntermedio.setText(String.valueOf(intermedio));

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}