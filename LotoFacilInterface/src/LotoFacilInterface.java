import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotoFacilInterface extends JFrame implements ActionListener {
    private JButton btnApostar0a100, btnApostarAZ, btnApostarParImpar;
    private JLabel lblResultado;
    private Random random;

    public LotoFacilInterface() {

        random = new Random();

        setTitle("LOTOFÁCIL");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        btnApostar0a100 = new JButton("Apostar de 0 a 100");
        btnApostarAZ = new JButton("Apostar de A à Z");
        btnApostarParImpar = new JButton("Apostar em Par ou Ímpar");
        lblResultado = new JLabel();

        panel.add(btnApostar0a100);
        panel.add(btnApostarAZ);
        panel.add(btnApostarParImpar);
        panel.add(lblResultado);

        add(panel);

        btnApostar0a100.addActionListener(this);
        btnApostarAZ.addActionListener(this);
        btnApostarParImpar.addActionListener(this);

    }

    public static void main(String[] args) {
        LotoFacilInterface lotofacil = new LotoFacilInterface();
        lotofacil.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnApostar0a100) {
            int numeroApostado = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 0 a 100:"));
            int numeroSorteado = random.nextInt(101);

            if (numeroApostado < 0 || numeroApostado > 100) {
                lblResultado.setText("Aposta inválida.");
            } else {
                if (numeroApostado == numeroSorteado) {
                    lblResultado.setText("Você ganhou R$ 1.000,00 reais.");
                } else {
                    lblResultado.setText("Que pena! O número sorteado foi: " + numeroSorteado + ".");
                }
            }
        } else if (e.getSource() == btnApostarAZ) {
            char letraApostada = JOptionPane.showInputDialog("Digite uma letra de A a Z:").toUpperCase().charAt(0);
            char letraPremiada = 'J';

            if (!Character.isLetter(letraApostada)) {
                lblResultado.setText("Aposta inválida:");
            } else {
                if (letraApostada == letraPremiada) {
                    lblResultado.setText("Você ganhou R$ 500,00 reais.");
                } else {
                    lblResultado.setText("Que pena! O número sorteado foi: " + letraPremiada + ".");
                }
            }
        } else if (e.getSource() == btnApostarParImpar) {
            int numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));

            if (numeroDigitado % 2 == 0) {
                lblResultado.setText("Você ganhou R$ 100,00 reais.");
            } else {
                lblResultado.setText("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        }
    }
}
