import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Sa se creeze un GUI cu o fereastra de login dupa nume de utilizator si parola.
Pe fereastra trebuie sa apara un buton de logare si un buton de inregistare, conturile formate din utilizator si
parola vor fi introduse intr-o baza de date, iar la logarea corecta, se va deschide o a doua fereastra cu un joc
care va avea un scor bazat pe timp si o alta tabela in baza de date cu numele utilizatorului si scor-ul pe care
l-a facut
 */
public class Main {
    public static void main(String[] args) {
        JFrame f1 = new JFrame("Aplicatie");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(400, 400);
        f1.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 400, 400);

        JButton but1 = new JButton("LOGIN");
        JButton but2 = new JButton("REGISTER");
        JButton but3 = new JButton("CLASAMENT");

        but1.setBounds(100, 100, 200, 50);
        but2.setBounds(100, 220, 200, 50);
        but3.setBounds(260, 10, 110, 70);

        panel1.add(but1);
        panel1.add(but2);
        panel1.add(but3);

        f1.add(panel1);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);

        LoginFrame loginFrame = new LoginFrame();
        RegisterFrame registerFrame= new RegisterFrame();
        ClasamentFrame clasamentFrame = new ClasamentFrame();

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.afiseaza();
            }
        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.afiseaza();
            }
        });
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clasamentFrame.afiseaza();
            }
        });
    }
}