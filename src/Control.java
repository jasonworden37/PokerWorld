import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.orange;

public class Control extends JFrame {
    private RadioPanel rpanel;
    private Label label;
    private pot pot;
    private int amount = 0;
    private int pot1 = 0;
    private int turn = 0;
    private LinkedList players;

    public Control(LinkedList players) {
        this.players = players;
        setTitle("Control");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Bottom Buttons
        Button buttons = new Button();

        buttons.getRemove().addActionListener(new RemoveListener());
        buttons.getTf().addActionListener(new tfListener());
        buttons.getHun().addActionListener(new hundListener());
        buttons.getFhun().addActionListener(new fhundListener());
        buttons.getThous().addActionListener(new thousListener());
        buttons.getFthous().addActionListener(new fthousListener());
        buttons.getClear().addActionListener(new clearListener());
        buttons.getCheck().addActionListener(new checkListener());
        buttons.getBet().addActionListener(new betListener());
        buttons.getFold().addActionListener(new foldListener());
        buttons.getNewHand().addActionListener(new newHandListener());
        add(buttons, BorderLayout.SOUTH);

        JButton stats = new JButton("Stats");


        stats.setBackground(orange);
        stats.setForeground(Color.white);
        stats.setPreferredSize(new Dimension(600, 400));
        stats.setFont(new Font("Arial", Font.BOLD, 96));
        stats.addActionListener(new statsListener());

        rpanel = new RadioPanel(players);
        add(rpanel, BorderLayout.NORTH);

        label = new Label(players);
        add(label, BorderLayout.WEST);

        pot = new pot();
        pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
        add(pot, BorderLayout.EAST);
        add(stats,BorderLayout.CENTER);
        setVisible(true);
    }

    public void resetControl() {

    }

    public RadioPanel getRpanel() {
        return rpanel;
    }

    public void setRpanel(RadioPanel rpanel) {
        this.rpanel = rpanel;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getTurn() {
        return players.getTurn().player.getName();
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public class RemoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            label.rem(rpanel.getRb());
            rpanel.rem(players);
            label.updateUI();
            rpanel.updateUI();


        }
    }

    public class tfListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            amount += 25;
            pot.getCurr().setText("Selected: " + Integer.toString(amount));
            pot.updateUI();
        }
    }

    public class hundListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            amount += 100;
            pot.getCurr().setText("Selected: " + Integer.toString(amount));
            pot.updateUI();
        }
    }

    public class fhundListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            amount += 500;
            pot.getCurr().setText("Selected: " + Integer.toString(amount));
            pot.updateUI();
        }
    }

    public class thousListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            amount += 1000;
            pot.getCurr().setText("Selected: " + Integer.toString(amount));
            pot.updateUI();
        }
    }

    public class fthousListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            amount += 5000;
            pot.getCurr().setText("Selected: " + Integer.toString(amount));
            pot.updateUI();
        }
    }

    public class clearListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            amount = 0;
            pot.getCurr().setText("Selected: " + Integer.toString(amount));
            pot.updateUI();
        }
    }

    public class betListener implements ActionListener {
        private BufferedImage chips;
        public void actionPerformed(ActionEvent e) {
            try {
                chips = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\chips.png"));
            } catch (IOException ex) {
                System.out.println("opos next");
            }
            players.getTurn().player.setBalance(players.getTurn().player.getBalance() - amount);
            pot1 += amount;
            label.getLabels().get(players.get(players.getTurn().player)).setText(players.getTurn().player.getName() + "'s balance: " + Integer.toString(players.getTurn().player.getBalance()));
            pot.getPot1().setText("Pot1: " + Integer.toString(pot1));
            players.getTurn().player.setChips(chips);
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            label.updateUI();
            pot.updateUI();
        }
    }

    public class foldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            players.folded(players.getTurn().player.getName());
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            pot.updateUI();
        }
    }

    public class checkListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            pot.updateUI();
        }
    }

    public class statsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            StatsFrame statsFrame = new StatsFrame(players.get(rpanel.winner()));

        }
    }

    public class newHandListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (rpanel.winner() == -1) {

            } else {
                players.get(rpanel.winner()).setBalance(players.get(rpanel.winner()).getBalance() + pot1);

                label.updateUI();
                pot1 = 0;
                label.getLabels().get(rpanel.winner()).setText(players.get(rpanel.winner()).getName() + "'s balance: " + Integer.toString(players.get(rpanel.winner()).getBalance()));
                pot.getPot1().setText("Pot1: " + Integer.toString(pot1));
                players.clearCards();
                TestMain.b.resetBoard();
                players.nextHand();
                System.out.println(players.getTurn().player.getName());
                pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
                label.updateUI();
                pot.updateUI();
                TestMain.hand = false;
                TestMain.table.getTable().updateUI();

            }

        }
    }


}
