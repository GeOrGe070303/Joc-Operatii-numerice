import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends AppFrame {

    private JTextField textuser1;
    private JPasswordField textparola1;
    public JButton b1;

    public User userSql = new User();

    public RegisterFrame() {
        super("REGISTER", 400, 400);

        textuser1 = new JTextField();
        textparola1 = new JPasswordField();

        textuser1.setBounds(100, 100, 200, 20);
        textparola1.setBounds(100, 160, 200, 20);

        b1 = new JButton("REGISTER");
        b1.setBounds(100, 260, 200, 30);

        add(textuser1);
        add(textparola1);
        add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSql.setUsername(textuser1.getText());
                userSql.setPassword(new String(textparola1.getPassword()));

                boolean ok = userSql.register();
                if (ok) {
                    setVisible(false);
                    JocFrame joc = new JocFrame(userSql.getUsername());
                    joc.afiseaza();
                }
            }
        });
    }
}