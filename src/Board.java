import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel {
    private BufferedImage[] boards = new BufferedImage[5];
    private BufferedImage one;
    private BufferedImage two;
    private BufferedImage three;
    private BufferedImage four;
    private BufferedImage five;
    public Board(BufferedImage one,BufferedImage two,BufferedImage three, BufferedImage four, BufferedImage five) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        boards[0] = this.one;
        boards[1] = this.two;
        boards[2] = this.three;
        boards[3] = this.four;
        boards[4] = this.five;
    }

    public BufferedImage[] getBoards() {
        return boards;
    }

    public void setBoards(BufferedImage[] boards) {
        this.boards = boards;

    }

    public void resetBoard() {
        try {
            boards[0] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            boards[1] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            boards[2] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            boards[3] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            boards[4] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
        } catch (IOException e) {

        }
    }
    public BufferedImage getOne() {
        return one;
    }

    public void setOne(BufferedImage one) {
        boards[0] = one;
    }

    public BufferedImage getTwo() {
        return two;
    }

    public void setTwo(BufferedImage two) {
        boards[1] = two;
    }

    public BufferedImage getThree() {
        return three;
    }

    public void setThree(BufferedImage three) {
        boards[2] = three;
    }

    public BufferedImage getFour() {
        return four;
    }

    public void setFour(BufferedImage four) {
        boards[3] = four;
    }

    public BufferedImage getFive() {
        return five;
    }

    public void setFive(BufferedImage five) {
        boards[4] = five;
    }
}
