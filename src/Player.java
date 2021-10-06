import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {



    private String rank,option = "", name;
    private BufferedImage[] cards = new BufferedImage[2];
    private BufferedImage left,right,chips;
    private int ranking,x,y,balance, chipx,chipy, x2,y2;
    private JLabel text = new JLabel();
    private boolean inHand = true;


    public int getAmountBet() {
        return amountBet;
    }

    public void setAmountBet(int amountBet) {
        this.amountBet = amountBet;
    }

    private int amountBet;
    String l,r;

    public Player(String name, int balance) {
        amountBet =0;

        this.name = name;
        this.balance = balance;
        rank = "High Card";
        ranking = 10000000;
        try {
            cards[0] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            cards[1] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            chips = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\chips\\whiteChip.png"));
        } catch (IOException e) {
            System.out.println("Image Load Exception in Player(1)");
        }

    }

    public BufferedImage getChips() {
        return chips;
    }

    public void setChips(BufferedImage chips) {
        this.chips = chips;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isInHand() {
        return inHand;
    }

    public void setInHand(boolean inHand) {
        this.inHand = inHand;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public BufferedImage[] getCards() {
        return cards;
    }

    public void setCards(BufferedImage[] cards) {
        this.cards = cards;
    }

    public BufferedImage getLeft() {
        return left;
    }

    public void setLeft(BufferedImage left,String l) {
        this.l = l;
        cards[0] = left;

    }

    public BufferedImage getRight() {
        return right;
    }

    public void setRight(BufferedImage right,String r) {
        this.r = r;
        cards[1] = right;
    }

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public String getOption() {
        return option;
    }

    public int getRanking(){
        return ranking;
    }
    public void setRanking(int num){
        ranking = num;
    }
    public void setOption(String option) {
        this.option = option;
    }

    public String[] getStringCards() {
        String [] card = {l,r};
        return card;
    }

    public void setCards(BufferedImage left, BufferedImage right) {
        cards[0] = left;
        cards[1] = right;
    }


    public void resetCard() {
        try {
            this.cards[0] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            this.cards[1] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
        } catch (IOException e) {
            System.out.println("Image Load Exception in Player(2)");
        }
        rank = "High Card";
    }



    public int getChipx() {
        return chipx;
    }

    public void setChipx(int chipx) {
        this.chipx = chipx;
    }

    public int getChipy() {
        return chipy;
    }

    public void setChipy(int chipy) {
        this.chipy = chipy;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
