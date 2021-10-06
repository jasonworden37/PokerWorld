import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import static java.awt.Color.orange;

public class Control extends JFrame {
    private Label label;
    private pot pot;
    private int amount = 0,pot1 = 0,turn = 0;
    private LinkedList players;
    public Button buttons;
    public Hand hand = new Hand() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };
    public static ArrayList<String[]> ans;

    public Control(LinkedList players) {
        this.players = players;
        setTitle("Control");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Bottom Buttons
        buttons = new Button();


        buttons.getTf().addActionListener(new tfListener());
        buttons.getHun().addActionListener(new hundListener());
        buttons.getFhun().addActionListener(new fhundListener());
        buttons.getThous().addActionListener(new thousListener());
        buttons.getFthous().addActionListener(new fthousListener());
        buttons.getClear().addActionListener(new clearListener());
        buttons.getCheck().addActionListener(new checkListener());
        buttons.getBet().addActionListener(new betListener());
        buttons.getCall().addActionListener(new callListener());
        buttons.getFold().addActionListener(new foldListener());

        add(buttons, BorderLayout.SOUTH);

        JButton stats = new JButton("Stats");


        stats.setBackground(orange);
        stats.setForeground(Color.white);
        stats.setPreferredSize(new Dimension(600, 400));
        stats.setFont(new Font("Arial", Font.BOLD, 96));
        stats.addActionListener(new statsListener());


        label = new Label(players);
        add(label, BorderLayout.WEST);

        pot = new pot();
        pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
        add(pot, BorderLayout.EAST);
        add(stats, BorderLayout.NORTH);
        setVisible(true);
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
        String chipString = "";
        public void actionPerformed(ActionEvent e) {

            buttons.greayCheckButton();
            buttons.unGrayCallButton();
            TestMain.numTurnsNeeded = TestMain.numPlayersinHand - 1;
            players.getTurn().player.setBalance(players.getTurn().player.getBalance() - (amount - players.getTurn().player.getAmountBet()));
            pot1 += amount - players.getTurn().player.getAmountBet();
            players.getTurn().player.setAmountBet(amount);
            label.getLabels().get(players.get(players.getTurn().player)).setText(players.getTurn().player.getName() + "'s balance: " + Integer.toString(players.getTurn().player.getBalance()));
            pot.getPot1().setText("Pot1: " + Integer.toString(pot1));

            int temp = players.getTurn().player.getAmountBet();
            if(temp > 5000)chipString ="blueChip";
            else if(temp > 1000)chipString ="blackChip";
            else if(temp > 500)chipString ="greenChip";
            else if(temp > 100)chipString ="redChip";
            else chipString ="whiteChip";
            try {
                chips = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\chips\\" + chipString+ ".png"));
            } catch (IOException ex) {
                System.out.println("Image Load Exception in Control(1)");
            }

            players.getTurn().player.setChips(chips);
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            label.updateUI();
            pot.updateUI();
        }
    }

    public class callListener implements ActionListener {
        private BufferedImage chips;
        String chipString = "";
        public void actionPerformed(ActionEvent e) {

            TestMain.numTurnsNeeded--;
            players.getTurn().player.setBalance(players.getTurn().player.getBalance() - (amount - players.getTurn().player.getAmountBet()));
            pot1 += amount - players.getTurn().player.getAmountBet();
            players.getTurn().player.setAmountBet(amount);
            label.getLabels().get(players.get(players.getTurn().player)).setText(players.getTurn().player.getName() + "'s balance: " + Integer.toString(players.getTurn().player.getBalance()));
            pot.getPot1().setText("Pot1: " + Integer.toString(pot1));

            int temp = players.getTurn().player.getAmountBet();
            if(temp > 5000)chipString ="blueChip";
            else if(temp > 1000)chipString ="blackChip";
            else if(temp > 500)chipString ="greenChip";
            else if(temp > 100)chipString ="redChip";
            else chipString ="whiteChip";
            try {
                chips = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\chips\\" + chipString + ".png"));
            } catch (IOException ex) {
                System.out.println("Image Load Exception in Control(2)");
            }
            players.getTurn().player.setChips(chips);
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            label.updateUI();
            pot.updateUI();
        }
    }

    public void clearBetAmounts() {
        for (int i = 0; i < players.getSize(); i++) {
            players.get(i).setAmountBet(0);
        }
    }

    public class foldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            TestMain.numTurnsNeeded--;
            TestMain.numPlayersinHand--;
            players.folded(players.getTurn().player.getName());
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            pot.updateUI();
        }
    }

    public class checkListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            TestMain.numTurnsNeeded--;
            players.nextTurn();
            pot.getTurn().setText("Players turn: " + players.getTurn().player.getName());
            pot.updateUI();
        }
    }

    public class statsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            StatsFrame stats = new StatsFrame(players);

        }
    }


    public void handOver() {
        ans = new ArrayList<String[]>();
        int num = 10000000;
        for (int i = 0; i < players.getSize(); i++) {
            num = 0;
            if (players.get(i).isInHand()) {
                String[] cards = players.get(i).getStringCards();
                String[] boards = TestMain.table.getTable().getB().getBoardsString();
                String[] fin = {cards[0], cards[1], boards[0], boards[1], boards[2], boards[3], boards[4]};
                ans.clear();
                printCombination(fin, fin.length, 5);
                //System.out.println("-------------------------" + players.get(i).getName() + "----------------");
                Card card = new Card(5, 0x8000);
                for (int k = 0; k < ans.size(); k++) {
                    Card[] temp = new Card[ans.get(k).length];
                    for (int t = 0; t < ans.get(k).length; t++) {
                        char pos1 = ans.get(k)[t].charAt(0);
                        char pos2 = ans.get(k)[t].charAt(1);

                        if (pos1 == '1' && pos2 == '0') {
                            pos1 = 'T';
                            pos2 = ans.get(k)[t].charAt(2);
                        }
                        String str = String.valueOf(pos1).toUpperCase() + String.valueOf(pos2).toLowerCase();
                        temp[t] = card.fromString(str);
                        //System.out.print(str + ",");
                    }
                    //System.out.println("");
                    num = hand.evaluate(temp);
                    //System.out.println("num " + num);
                    if (num < players.get(i).getRanking()) {
                        players.get(i).setRanking(num);
                    }
                }

                //go through each combination and run it through tables and get each players best hand
            } else {
                players.get(i).setRanking(10000000);
            }

        }
        int rank = 10000000;
        //check who has the best hand

        ArrayList<Player> winners = new ArrayList<>();
        for (int i = 0; i < players.getSize(); i++) {
            if (players.get(i).isInHand()) {
                //System.out.println("PLayer " + players.get(i).getName() + " ,final rank " + players.get(i).getRanking());
                if (players.get(i).getRanking() < rank) {
                    rank = players.get(i).getRanking();
                    winners.clear();

                    winners.add(players.get(i));


                } else if (players.get(i).getRanking() == rank) {

                    winners.add(players.get(i));
                }
            }
        }


        int winAmt = pot1 / winners.size();
        for (int i = 0; i < winners.size(); i++) {
            System.out.println("Winner is " + winners.get(i).getName());
            winners.get(i).setBalance(winners.get(i).getBalance() + winAmt);
            label.getLabels().get(players.get(winners.get(i))).setText(winners.get(i).getName() + "'s balance: " + Integer.toString(winners.get(i).getBalance()));
        }
        label.updateUI();
        pot1 = 0;
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


    public void lastPlayer() {
        int index = 0;
        for (int i = 0; i < players.getSize(); i++) {
            if (players.get(i).isInHand()) {
                index = 1;
            }
        }
        players.get(index).setBalance(players.get(index).getBalance() + pot1);
        label.getLabels().get(players.get(players.get(index))).setText(players.get(index).getName() + "'s balance: " + Integer.toString(players.get(index).getBalance()));
        label.updateUI();
        pot1 = 0;
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

    static void combinationUtil(String arr[], String data[], int start,
                                int end, int index, int r) {
        if (index == r) {
            String[] temp = new String[r];
            for (int j = 0; j < r; j++)
                temp[j] = data[j];
            ans.add(temp);

            return;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }

    }

    static void printCombination(String arr[], int n, int r) {
        String data[] = new String[r];
        combinationUtil(arr, data, 0, n - 1, 0, r);

    }

    public void setSelected(int num){
        pot.getCurr().setText("Selected: " + Integer.toString(num));
        pot.updateUI();
        amount = num;

    }


}
