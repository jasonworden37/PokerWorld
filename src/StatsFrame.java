import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StatsFrame extends JFrame {
    private Player player;
    private Color n = new Color(36, 55, 77);
    public StatsFrame(Player player) {
        this.player = player;
        setTitle(player.getName());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screensize.width, screensize.height);
        JLabel numHands = new JLabel("Number of Hands: ");
        JLabel bestHand = new JLabel("Best Hand: []");
        JLabel bigPot = new JLabel("Biggest Pot won: ");
        bigPot.setFont(new Font("Arial", Font.BOLD, 96));
        bestHand.setFont(new Font("Arial", Font.BOLD, 96));
        numHands.setFont(new Font("Arial", Font.BOLD, 96));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(numHands);
        panel.add(bestHand);
        panel.add(bigPot);
//        JPanel border = new JPanel();
//        border.setBorder(new LineBorder(n));
        getRootPane().setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50, n));
//        add(border);
        add(panel);

        setVisible(true);
    }
}
