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

public class frm10 extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JLabel lblResultado;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frm10 frame = new frm10();
                    frame.setVisible(true);
                } catch ( Exception e ){
                    e.printStackTrace();
                }
            }
        });
    }

    public frm10(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        //Etiqueta y campo para el numero 
        JLabel lblNumero = new JLabel("Número (4 cifras):");
        lblNumero.setBounds(50, 50, 120, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 50, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        //Boton calcular
        JButton btnCalcular = new JButton("Invertir");
        btnCalcular.setBounds(80, 100, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btnCalcular_actionPerformed();
            }
        });

        //Etiqueta para mostrar el resultado 
        lblResultado = new JLabel("Número invertido: ");
        lblResultado.setBounds(50, 150, 250, 30);
        getContentPane().add(lblResultado);


    }

    protected void btnCalcular_actionPerformed(){

        //Obten el numero ingresado 
        String numero = txtNumero.getText();

        //Verifica que el numero tiene 4 cifras 
        if (numero.length() == 4 && numero.matches("\\d+")) {
            //Invertir el resultado 
            String numeroInvertido = new StringBuilder(numero).reverse().toString();
            //Mostrar el resultado 
            lblResultado.setText("Número invertido: " + numeroInvertido);
        } else {
            lblResultado.setText("Por favor, ingrese un número de 4 cifras.");
    }


}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(JTextField txtNumero) {
        this.txtNumero = txtNumero;
    }

    public JLabel getLblResultado() {
        return lblResultado;
    }
    public void setLblResultado(JLabel lblResultado) {
        this.lblResultado = lblResultado;
    }
}
