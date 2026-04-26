import javax.swing.*;

public class AppFrame extends JFrame {

    public AppFrame(String titlu, int w, int h) {
        setTitle(titlu);
        setSize(w, h);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void afiseaza() {
        setVisible(true);
    }
}