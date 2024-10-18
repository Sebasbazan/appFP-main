package secuenciales;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm16  extends JFrame{
    
    
    private static final long serialVersionUID = 1L;
    JTextField txtHoras, txtTarifa;
    JLabel lblResultado;

    public static void main (String[] args){
        EventQueue.invokeLater(() -> {
            try{
                frm16 frame = new frm16();
                frame.setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public frm16(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 510, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        //Etiquetas y campos para horas trabajadas y tarifas
        JLabel lblHoras = new JLabel("Horas Trabajadas: ");
        lblHoras.setBounds(50, 30, 120, 30);
        getContentPane().add(lblHoras);

        txtHoras = new JTextField();
        txtHoras.setBounds(180, 30, 80, 30);
        txtHoras.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtHoras);



        JLabel lblTarifas = new JLabel("Tarifa Horaria: ");
        lblTarifas.setBounds(50, 70, 120, 30);
        getContentPane().add(lblTarifas);

        txtTarifa = new JTextField();
        txtTarifa.setBounds(180, 70, 80, 30);
        txtTarifa.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtTarifa);

        //Boton para calcular 
        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(80, 110, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                calcularSueldo();
            }
        });

        //Etiqueta para mostrar el suelto
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 150, 250, 60);
        getContentPane().add(lblResultado);

    }

    private void calcularSueldo(){
        double horas = Double.parseDouble(txtHoras.getText());
        double tarifa = Double.parseDouble(txtTarifa.getText());

        //Calculo del sueldo

        double sueldoBasico = horas * tarifa;
        double sueldoBruto = sueldoBasico * 1.20; //20% bonificacion
        double sueldoNeto = sueldoBruto * 0.90; //10% descuento

        // Mostrar el resultado
        String resultado = String.format("Sueldo Básico: %.2f | Sueldo Bruto: %.2f | Sueldo Neto: %.2f",
        sueldoBasico, sueldoBruto, sueldoNeto);
        lblResultado.setText(resultado);

        // Ajustar tamaño de la etiqueta para que se muestre todo el texto
        lblResultado.setSize(lblResultado.getPreferredSize());
    }

}
