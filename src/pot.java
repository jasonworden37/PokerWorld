import javax.swing.*;
import java.awt.*;

public class pot extends JPanel {
    private Color n = new Color(36, 55, 77);
    private JLabel pot1;
    private JLabel pot2;
    private JLabel pot3;
    private JLabel curr;
    private JLabel turn;
    public pot() {
        super(new GridLayout(4, 1));
         pot1 = new JLabel("Pot: ");
         pot2 = new JLabel("Pot Two: ");
         pot3 = new JLabel("Pot Three: ");
         curr = new JLabel("Selected: ");
         turn = new JLabel("Players Turn: ");

         turn.setForeground(n);
        turn.setFont(new Font("Arial", Font.ITALIC, 96));

        curr.setForeground(n);
        curr.setFont(new Font("Arial", Font.ITALIC, 96));

         pot1.setForeground(n);
        pot1.setFont(new Font("Arial", Font.ITALIC, 96));

        pot2.setForeground(n);
        pot2.setFont(new Font("Arial", Font.ITALIC, 96));

        pot3.setForeground(n);
        pot3.setFont(new Font("Arial", Font.ITALIC, 96));

        add(pot1);
        add(pot2);
        add(pot3);
        add(curr);
        add(turn);
    }

    public JLabel getTurn() {
        return turn;
    }

    public void setTurn(JLabel turn) {
        this.turn = turn;
    }

    public JLabel getPot1() {
        return pot1;
    }

    public void setPot1(JLabel pot1) {
        this.pot1 = pot1;
    }

    public JLabel getPot2() {
        return pot2;
    }

    public void setPot2(JLabel pot2) {
        this.pot2 = pot2;
    }

    public JLabel getPot3() {
        return pot3;
    }

    public void setPot3(JLabel pot3) {
        this.pot3 = pot3;
    }

    public JLabel getCurr() {
        return curr;
    }

    public void setCurr(JLabel curr) {
        this.curr = curr;
    }
}
