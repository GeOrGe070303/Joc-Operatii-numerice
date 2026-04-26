import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JocFrame extends AppFrame {

    private static int intrebari = 10;
    private static int tinta = 5;

    private JLabel lbuser;
    private JLabel lbintrebarenr;
    private JLabel lbcorecte;
    private JLabel lbintrebare;
    private JTextField textraspuns;
    private JButton btn;

    private Random rnd = new Random();
    private Scoruri scorsql = new Scoruri();
    private String username;

    private int contintrebare = 1;
    private int consecutive = 0;

    private long timpst = -1;
    private Long timpdr = null;

    private int a, b;
    private char operatie;
    private int rezcorect;

    public JocFrame(String username) {
        super("JOC", 520, 360);
        this.username = username;

        lbuser = new JLabel("User: " + username);
        lbuser.setBounds(20, 20, 300, 25);

        lbintrebarenr = new JLabel("Intrebarea: 1 / " + intrebari);
        lbintrebarenr.setBounds(20, 55, 250, 25);

        lbcorecte = new JLabel("Consecutive corecte: 0 / " + tinta);
        lbcorecte.setBounds(20, 85, 300, 25);

        lbintrebare = new JLabel("");
        lbintrebare.setBounds(20, 130, 480, 30);

        textraspuns = new JTextField();
        textraspuns.setBounds(20, 175, 200, 30);

        btn = new JButton("Submit");
        btn.setBounds(240, 175, 120, 30);

        add(lbuser);
        add(lbintrebarenr);
        add(lbcorecte);
        add(lbintrebare);
        add(textraspuns);
        add(btn);

        intrebare();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raspuns();
            }
        });
    }

    private void intrebare() {
        a = rnd.nextInt(10) + 1;
        b = rnd.nextInt(10) + 1;

        int alegere = rnd.nextInt(3) + 1;
        switch (alegere) {
            case 1:
                operatie = '+';
                break;
            case 2:
                operatie = '-';
                break;
            default:
                operatie = '*';
        }

        switch (operatie) {
            case '+':
                rezcorect = a + b;
                break;
            case '-':
                rezcorect = a - b;
                break;
            default:
                rezcorect = a * b;
                break;
        }

        lbintrebare.setText("Cat face: " + a + " " + operatie + " " + b + " ?");
        textraspuns.setText("");
    }

    private void raspuns() {
        String s = textraspuns.getText();

        int raspuns;
        try {
            raspuns = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return;
        }

        boolean corect = (raspuns == rezcorect);

        if (corect) {
            if (consecutive == 0) {
                timpst = System.currentTimeMillis();
            }
            consecutive++;

            if (consecutive == tinta) {
                timpdr = System.currentTimeMillis() - timpst;
                game();
                return;
            }
        } else {
            consecutive = 0;
            timpst = -1;
        }

        lbcorecte.setText("Consecutive corecte: " + consecutive + " / " + tinta);

        if (contintrebare == intrebari) {
            game();
            return;
        }

        contintrebare++;
        lbintrebarenr.setText("Intrebarea: " + contintrebare + " / " + intrebari);
        intrebare();
    }

    public void game() {
        textraspuns.setEnabled(false);
        btn.setEnabled(false);

        if (timpdr != null) {
            boolean ok = scorsql.salvare(username, timpdr);
            if (ok) {
                dispose();
            }
        }
    }
}