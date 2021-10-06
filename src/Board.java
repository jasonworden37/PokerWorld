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
    String[] bString;
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
        bString = new String[5];
    }

    public BufferedImage[] getBoards() {
        return boards;
    }

    public void setBoards(BufferedImage[] boards, String[] bString) {
        this.boards = boards;
        this.bString = bString;

    }

    public String[] getBoardsString(){
        return bString;
    }

    public void resetBoard() {
        try {
            for (int i = 0; i < 5; i++) {
                boards[i] = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
                bString[i] = "blank";
            }

        } catch (IOException e) {

        }
    }
    public BufferedImage getOne() {
        return one;
    }

    public void setOne(BufferedImage one,String uno) {
        boards[0] = one;
        bString[0] = uno;

    }

    public BufferedImage getTwo() {
        return two;
    }

    public void setTwo(BufferedImage two,String dos)
    {
        boards[1] = two;
        bString[1] = dos;
    }

    public BufferedImage getThree() {
        return three;
    }

    public void setThree(BufferedImage three,String tres) {
        boards[2] = three;
        bString[2] = tres;
    }

    public BufferedImage getFour() {
        return four;
    }

    public void setFour(BufferedImage four,String quatro) {
        boards[3] = four;
        bString[3] = quatro;
    }

    public BufferedImage getFive() {
        return five;
    }

    public void setFive(BufferedImage five, String cinco) {
        boards[4] = five;
        bString[4] = cinco;

    }
}
