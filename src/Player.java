import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {

    private String name;
    private int balance;

    private String rank;
    private BufferedImage[] cards = new BufferedImage[2];
    private BufferedImage left;
    private BufferedImage right;
    private BufferedImage chips;
    private JLabel text = new JLabel();
    private String option = "";
    private boolean inHand = true;
    private int x;
    private int y;

    public Player(String name, int balance) {


        this.name = name;
        this.balance = balance;
        rank = "High Card";

        try {
            cards[0] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            cards[1] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            chips = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\"));
        } catch (IOException e) {

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

    public void setLeft(BufferedImage left) {

        cards[0] = left;
    }

    public BufferedImage getRight() {
        return right;
    }

    public void setRight(BufferedImage right) {

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

    public void setOption(String option) {
        this.option = option;
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

        }
        rank = "High Card";
    }




}
