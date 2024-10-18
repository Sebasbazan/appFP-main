package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtRadio, txtAltura;
    JLabel lblAreaTotalResultado, lblVolumenResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm08 frame = new frm08();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm08() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiqueta y campo para el radio
        JLabel lblRadio = new JLabel("Radio(r)");
        lblRadio.setBounds(50, 50, 80, 30);
        getContentPane().add(lblRadio);

        txtRadio = new JTextField();
        txtRadio.setBounds(130, 50, 100, 30);
        txtRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRadio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtRadio);

        // Etiqueta y campo para la altura
        JLabel lblAltura = new JLabel("Altura(h)");
        lblAltura.setBounds(50, 100, 80, 30);
        getContentPane().add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(130, 100, 100, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAltura.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAltura);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 150, 150, 30);
        getContentPane().add(btnCalcular);
        
        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());

        // Etiquetas para mostrar resultados
        lblAreaTotalResultado = new JLabel("Área Total: ");
        lblAreaTotalResultado.setBounds(250, 50, 250, 30);
        getContentPane().add(lblAreaTotalResultado);

        lblVolumenResultado = new JLabel("Volumen: ");
        lblVolumenResultado.setBounds(250, 100, 250, 30);
        getContentPane().add(lblVolumenResultado);
    }

    protected void btnCalcular_actionPerformed() {
        double radio = Double.parseDouble(txtRadio.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        // Cálculo de área y volumen
        double areaBase = Math.PI * Math.pow(radio, 2);
        double areaLateral = 2 * Math.PI * radio * altura;
        double areaTotal = areaBase + areaLateral;

        double volumen = areaBase * altura;

        // Mostrar los resultados
        lblAreaTotalResultado.setText("Área Total: " + String.format("%.2f", areaTotal));
        lblVolumenResultado.setText("Volumen: " + String.format("%.2f", volumen));
    }
}
