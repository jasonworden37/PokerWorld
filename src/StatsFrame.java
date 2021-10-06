import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsFrame extends JFrame {
    private LinkedList players;
    private Color navy = new Color(36, 55, 77);
    private Color red = new Color(178, 34, 34);
    private Color green = new Color(0, 100 ,0);
    private Color blue = new Color(25, 25, 112);
    private Color grey = new Color(26, 26, 26);
    private Color purple = new Color(221, 153, 255);
    private Color orange = new Color(255, 191, 128);
    private Color white = new Color(255,255,255);
    public StatsFrame(LinkedList players) {
        this.players = players;
        setTitle("Player Statistics");
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screensize.width, screensize.height);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(players.getSize()/2,2));
        for (int i =0; i < players.getSize(); i++){
            JButton button = new JButton(players.get(i).getName());
            button.setBackground(navy);
            button.setForeground(Color.white);
            button.setPreferredSize(new Dimension(600,400));
            button.setFont(new Font("Arial", Font.BOLD, 96));
            button.addActionListener(new ButtonListener());
            panel.add(button);

        }
       /* JLabel numHands = new JLabel("Number of Hands: ");
        JLabel bestHand = new JLabel("Best Hand: []");
        JLabel bigPot = new JLabel("Biggest Pot won: ");
        bigPot.setFont(new Font("Arial", Font.BOLD, 96));
        bestHand.setFont(new Font("Arial", Font.BOLD, 96));
        numHands.setFont(new Font("Arial", Font.BOLD, 96));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(numHands);
        panel.add(bestHand);
        panel.add(bigPot);*/
//        JPanel border = new JPanel();
//        border.setBorder(new LineBorder(n));
        getRootPane().setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50, white));
//        add(border);
        add(panel);

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = getTitle().toLowerCase();
            //if this person has a csv file, open it and put it in a view
            //if they do not, create one for them, with default values and put it in the same view


        }
    }
}
