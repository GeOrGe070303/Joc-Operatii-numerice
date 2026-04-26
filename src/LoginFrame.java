import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends AppFrame {

    private JTextField textuser;
    private JPasswordField textparola;
    public JButton b;

    public User userSql = new User();

    public LoginFrame() {
        super("LOGIN", 400, 400);

        textuser = new JTextField();
        textparola = new JPasswordField();

        textuser.setBounds(100, 100, 200, 20);
        textparola.setBounds(100, 160, 200, 20);

        b = new JButton("LOGIN");
        b.setBounds(100, 260, 200, 30);

        add(textuser);
        add(textparola);
        add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSql.setUsername(textuser.getText());
                userSql.setPassword(new String(textparola.getPassword()));

                boolean ok = userSql.login();
                if (ok) {
                    setVisible(false);
                    JocFrame joc = new JocFrame(userSql.getUsername());
                    joc.afiseaza();
                }
            }
        });
    }
}