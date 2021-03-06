import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Table extends JPanel {
    private ArrayList<BufferedImage> cards = new ArrayList<>();
    private BufferedImage imagePoker, dealer, small,big;
    public LinkedList players;
    public Board b;
    private Color navy = new Color(0, 0, 51);
    private Color gold = new Color(102, 102, 0);
    private int center = 110;


    public Table(LinkedList players, Board b) {
        this.players = players;
        this.b = b;
        this.setBackground(navy);

        try {
            imagePoker = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\Table.png"));

           dealer = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\dealer.png"));
           small = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\little.png"));
           big = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\big.png"));
        } catch (IOException ex) {
            System.out.println("Image Load Exception in Table(1)");
        }
    }


    public Board getB(){
        return b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int count = 1250;
        String bal;

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2d.translate(-imagePoker.getWidth(null) / 2, -imagePoker.getHeight(null) / 2);
        g2d.drawImage(imagePoker, 0, 0, null);

        if(players.getSize() == 2){
            g.drawImage(small, players.getSmall().player.getX2(),  players.getSmall().player.getY2() , this);
            g.drawImage(big, players.getBig().player.getX2(),  players.getBig().player.getY2() , this);
        } else {
            g.drawImage(dealer, players.getDealer().player.getX2(),  players.getDealer().player.getY2() , this);
            g.drawImage(small, players.getSmall().player.getX2(),  players.getSmall().player.getY2() , this);
            g.drawImage(big, players.getBig().player.getX2(),  players.getBig().player.getY2() , this);
        }


        for (int i = 0; i < players.getSize(); i++) {
            if(players.get(i).getAmountBet() != 0)g.drawImage(players.get(i).getChips(), players.get(i).getChipx(),  players.get(i).getChipy(), this);

            g.drawImage(players.get(i).getCards()[0], players.get(i).getX(), players.get(i).getY(), this);
            g.drawImage(players.get(i).getCards()[1], players.get(i).getX() + 200, players.get(i).getY(), this);


            center -= players.get(i).getName().length() * 15;
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            if(players.get(i).getAmountBet() != 0 )g.drawString(Integer.toString(players.get(i).getAmountBet()),players.get(i).getChipx() - 60,players.get(i).getChipy() + 100);
            g.drawString(players.get(i).getOption(), players.get(i).getX(), players.get(i).getY());

            g.setColor(gold);
            g.setFont(new Font("Arial", Font.BOLD, 72));


            g.setColor(Color.WHITE);
            g.drawString(players.get(i).getName(), players.get(i).getX(), players.get(i).getY());


            bal = Integer.toString(players.get(i).getBalance());

            g.drawString("$" + bal, players.get(i).getX(), players.get(i).getY() + 380);
            g.drawString(players.get(i).getRank(), players.get(i).getX(), players.get(i).getY() + 440);
        }
        for (int i = 0; i < b.getBoards().length; i++) {
            g.drawImage(b.getBoards()[i], count, 1050, this);
            count += 200;
        }

    }
}