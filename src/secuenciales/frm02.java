package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm02 extends JFrame{
    private static final long serialVersionUID = 1L;
    JTextField txtMetros;
    JLabel lblCentimetos, lblPulgadas, lblPies, lblYardas;

    /**
     * @param args
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frm02 frame = new frm02();
                    frame.setVisible(true);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public frm02(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMetros = new JLabel("Metros:");
        lblMetros.setBounds(50, 50, 80, 30);
        getContentPane().add(lblMetros);

        txtMetros = new JTextField();
        txtMetros.setBounds(130, 50, 60, 30);
        txtMetros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMetros.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMetros);

        //Etiauetas para mostrar los resultados de la conversión
        lblCentimetos = new JLabel("Centímetros:");
        lblCentimetos.setBounds(50, 90, 200, 30);
        getContentPane().add(lblCentimetos);

        lblPulgadas = new JLabel("Pulgadas:");
        lblPulgadas.setBounds(50, 130, 200, 30);
        getContentPane().add(lblPulgadas);

        lblPies = new JLabel("Pies:");
        lblPies.setBounds(50, 170, 200, 30);
        getContentPane().add(lblPies);

        lblYardas = new JLabel("Yardas:");
        lblYardas.setBounds(50, 210, 200, 30);
        getContentPane().add(lblYardas);

        //Boton para relaizar la conversion
        JButton btnConvertir = new JButton("Concertir");
        btnConvertir.setBounds(150, 250, 100, 30);
        getContentPane().add(btnConvertir);

        //Accion al presionar el boton de convertir
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnConvertir_actionPerformed();
            }
        });
    }  
protected void btnConvertir_actionPerformed(){
    //toma la cantidad de metros ingresada por el usuario
    double metros = Double.parseDouble(txtMetros.getText());

    //Realiza las conversiones a las diferentes unidades
    double Centímetros = metros * 100;
    double pulgadas = Centímetros / 2.54;
    double pies = pulgadas/ 12;
    double Yardas = pies / 3;

    //Formatea los resultados con dos decimales
    DecimalFormat df = new DecimalFormat("####.##");
    lblCentimetos.setText("Centímetros:" + df.format(Centímetros));
    lblPulgadas.setText("Pulgadas:" + df.format(pulgadas));
    lblPies.setText("Pies:" + df.format(pies));
    lblYardas.setText("Yardas:" + df.format(Yardas));
}     
}
