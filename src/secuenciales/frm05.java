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

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtGigabytes;
    JLabel lblMegabytesResultado, lblKilobytesResultado, lblBytesResultado;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frm05 frame = new frm05();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public frm05(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 550, 270);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblGigabytes = new JLabel("Gigabytes");
        lblGigabytes.setBounds(50, 50, 80, 30);
        getContentPane().add(lblGigabytes);

        txtGigabytes = new JTextField();
        txtGigabytes.setBounds(130, 50, 100, 30);
        txtGigabytes.setHorizontalAlignment(SwingConstants.RIGHT);
        txtGigabytes.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtGigabytes);


        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 100, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btnCalcular_actionPerformed();
            }
        });

        lblMegabytesResultado = new JLabel("Megabytes: " );
        lblMegabytesResultado.setBounds(250, 50, 200, 30);
        getContentPane().add(lblMegabytesResultado);

        lblKilobytesResultado = new JLabel("Kilobytes: " );
        lblKilobytesResultado.setBounds(250, 100, 200, 30);
        getContentPane().add(lblKilobytesResultado);

        lblBytesResultado = new JLabel("Bytes:" );
        lblBytesResultado.setBounds(250, 150, 200, 30);
        getContentPane().add(lblBytesResultado);


    }

    protected void btnCalcular_actionPerformed(){
        double gigabytes = Double.parseDouble(txtGigabytes.getText());


        double megabytes = gigabytes * 1024;
        double kilobytes = megabytes * 1024;
        double bytes = kilobytes * 1024;

        lblMegabytesResultado.setText("Megabytes:" + String.format("%.2f", megabytes));
        lblKilobytesResultado.setText("Kilobytes: " + String.format("%.2f", kilobytes));
        lblBytesResultado.setText("Bytes:" + String.format("%.2f", bytes));

    }
    
}
