import javax.swing.*;

public class ClasamentFrame extends AppFrame {

    private JTextArea text;
    private JButton refresh;

    private Scoruri scorsql = new Scoruri();

    public ClasamentFrame() {
        super("CLASAMENT", 400, 400);

        text = new JTextArea();
        text.setBounds(30, 30, 320, 250);
        text.setEditable(false);

        refresh = new JButton("REFRESH");
        refresh.setBounds(120, 300, 150, 30);

        add(text);
        add(refresh);

        refresh.addActionListener(e -> incarcare());
    }

    @Override
    public void afiseaza() {
        incarcare();
        super.afiseaza();
    }

    private void incarcare() {
        String rezultat = scorsql.clasament();
        text.setText(rezultat);
    }
}