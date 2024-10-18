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

public class frm04 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtPies, txtPulgadas;
    JLabel lblMetrosResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm04 frame = new frm04();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm04() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 280, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblPies = new JLabel("Pies:");
        lblPies.setBounds(50, 50, 80, 30);
        getContentPane().add(lblPies);

        txtPies = new JTextField();
        txtPies.setBounds(130, 50, 100, 30);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPies.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPies);

        JLabel lblPulgadas = new JLabel("Pulgadas:");
        lblPulgadas.setBounds(50, 100, 80, 30);
        getContentPane().add(lblPulgadas);

        txtPulgadas = new JTextField();
        txtPulgadas.setBounds(130, 100, 100, 30);
        txtPulgadas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPulgadas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPulgadas);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 150, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });

        lblMetrosResultado = new JLabel("Estatura en Metros:");
        lblMetrosResultado.setBounds(50, 200, 300, 30);
        getContentPane().add(lblMetrosResultado);
    }

    protected void btnCalcular_actionPerformed() {
        double pies = Double.parseDouble(txtPies.getText());
        double pulgadas = Double.parseDouble(txtPulgadas.getText());

        
        double totalMetros = (pies * 0.3048) + (pulgadas * 0.0254); 

        
        lblMetrosResultado.setText("Estatura en Metros: " + String.format("%.2f", totalMetros));
    }
}
