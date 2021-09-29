import javax.swing.*;
import java.awt.*;

public class playerLabel extends JLabel {
    private String name;
    private int bal;
    private Color n = new Color(36, 55, 77);

    public playerLabel(String name, int bal) {
        this.bal = bal;
        this.name = name;
        setText(name + "'s balance: " + Integer.toString(bal));
        setForeground(n);
        setFont(new Font("Arial", Font.BOLD, 96));
    }


}
