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

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtKilometros, txtPies, txtMillas;
    JLabel lblMetrosResultado, lblYardasResultado;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frm03 frame = new frm03();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }            
        });
    }

    public frm03(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblKilometros = new JLabel("Kilometros:" );
        lblKilometros.setBounds(50, 50, 120, 30);
        getContentPane().add(lblKilometros);

        txtKilometros = new JTextField();
        txtKilometros.setBounds(180, 50, 100, 30);
        txtKilometros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtKilometros.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtKilometros);

        JLabel lblPies = new JLabel("Pies:" );
        lblPies.setBounds(50, 100, 120, 30);
        getContentPane().add(lblPies);

        txtPies = new JTextField();
        txtPies.setBounds(180, 100, 100, 30);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPies.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPies);

        JLabel lblMillas = new JLabel("Millas:" );
        lblMillas.setBounds(50, 150, 120, 30);
        getContentPane().add(lblMillas);

        txtMillas = new JTextField();
        txtMillas.setBounds(180, 150, 100, 30);
        txtMillas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMillas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMillas);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 200, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btnCalcular_actionPerformed();
            }
        });

        lblMetrosResultado = new JLabel("Total en Metros:");
        lblMetrosResultado.setBounds(350, 50, 120, 30);
        getContentPane().add(lblMetrosResultado);

        lblYardasResultado = new JLabel("Total en Yardas:");
        lblYardasResultado.setBounds(350, 100, 120, 30);
        getContentPane().add(lblYardasResultado);

    }

    protected void btnCalcular_actionPerformed(){

        double Kilometros = Double.parseDouble(txtKilometros.getText());
        double Pies = Double.parseDouble(txtPies.getText());
        double millas = Double.parseDouble(txtMillas.getText());

        double totalMetros = (Kilometros * 1000) + (Pies / 3.2808) + (millas * 1609);

        double totalYardas = totalMetros * 1.09361;
        
        lblMetrosResultado.setText("Total en Metros: " + String.format("%.2f", totalMetros));
        lblYardasResultado.setText("Total en Yardas: " + String.format("%.2f", totalYardas));
    }
}

