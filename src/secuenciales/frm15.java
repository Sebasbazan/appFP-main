package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("unused")
public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtJuan, txtRosa, txtDaniel;
    JTextArea txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm15 frame = new frm15();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm15() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 320, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        
        JLabel lblJuan = new JLabel("Aporte Juan ($):");
        lblJuan.setBounds(30, 30, 120, 30);
        getContentPane().add(lblJuan);

        txtJuan = new JTextField();
        txtJuan.setBounds(150, 30, 100, 30);
        txtJuan.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtJuan);

        JLabel lblRosa = new JLabel("Aporte Rosa ($):");
        lblRosa.setBounds(30, 70, 120, 30);
        getContentPane().add(lblRosa);

        txtRosa = new JTextField();
        txtRosa.setBounds(150, 70, 100, 30);
        txtRosa.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtRosa);

        JLabel lblDaniel = new JLabel("Aporte Daniel (S/.):");
        lblDaniel.setBounds(30, 110, 120, 30);
        getContentPane().add(lblDaniel);

        txtDaniel = new JTextField();
        txtDaniel.setBounds(150, 110, 100, 30);
        txtDaniel.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDaniel);

        
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(90, 150, 120, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

       
        txtResultado = new JTextArea();
        txtResultado.setBounds(30, 190, 250, 100);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);
    }

    protected void calcular() {
        double aporteJuan = Double.parseDouble(txtJuan.getText());
        double aporteRosa = Double.parseDouble(txtRosa.getText());
        double aporteDaniel = Double.parseDouble(txtDaniel.getText());

        
        double aporteDanielDolares = aporteDaniel / 3.00;

        
        double capitalTotal = aporteJuan + aporteRosa + aporteDanielDolares;

        
        double porcentajeJuan = (aporteJuan / capitalTotal) * 100;
        double porcentajeRosa = (aporteRosa / capitalTotal) * 100;
        double porcentajeDaniel = (aporteDanielDolares / capitalTotal) * 100;

        
        txtResultado.setText(String.format("Total: $%.2f\nJuan: %.2f%%\nRosa: %.2f%%\nDaniel: %.2f%%", 
            capitalTotal, porcentajeJuan, porcentajeRosa, porcentajeDaniel));
    }
}
