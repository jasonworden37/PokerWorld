import javax.swing.*;
import java.awt.*;


public class RadioButton extends JRadioButton {



    private Color n = new Color(36, 55, 77);

    public RadioButton(String name) {
        setText(name);
        setBackground(n);
        setForeground(Color.white);
        setPreferredSize(new Dimension(600, 400));
        setFont(new Font("Arial", Font.BOLD, 96));


    }



}
