package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm09 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JLabel lblResultado;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frm09 frame = new frm09();
                    frame.setVisible(true);
                } catch ( Exception e ){
                    e.printStackTrace();
                }
            }
        });
    }

    public frm09(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        //Etiqueta y campo para el numero

        JLabel lblNumero = new JLabel("Número: ");
        lblNumero.setBounds(50, 50, 80, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(130, 50, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        //Boton para calcular 

        JButton btnCalcular = new JButton("Calcular Suma");
        btnCalcular.setBounds(80, 100, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                btnCalcular_actionPerformed();
            }
        });

        // Etiqueta para mostrar el resultado
        lblResultado = new JLabel("Suma: ");
        lblResultado.setBounds(50, 150, 250, 30);
        getContentPane().add(lblResultado);

    }

    protected void btnCalcular_actionPerformed(){
        //Obtener el numero de entrada 
        int numero = Integer.parseInt(txtNumero.getText());

        //Calcular la suma de las cifras 

        int suma = 0;
        while (numero > 0 ) {
            suma += numero % 10; // sumer la ultima cifra 
            numero /= 10; //Elimina la ultima cifra 
        }
        //Mostrar el resultado
        lblResultado.setText("Suma: " + suma );
    }
    
}
