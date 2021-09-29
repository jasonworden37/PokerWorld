import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static boolean hand = true;
    public static Control control;
    public static FrameTable table;
    public static Board b;
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner s = new Scanner(System.in);
        String name;
        String temp = "";
        int balance = 0;
        boolean allSameBal = false;
        System.out.println("How many players are playing?");
        int numOfPlayers = s.nextInt();
        System.out.println("Is everyone starting with the same amount of money?");
        name = s.next();

        if (name.charAt(0) == 'Y' || name.charAt(0) == 'y') {
            allSameBal = true;
            System.out.println("How much money do they have ");
            balance = s.nextInt();
        }

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("What is their name?");
            name = s.next();
            if (!allSameBal) {
                System.out.println("How much money do they have ");
                balance = s.nextInt();
            }
            list.add(new Player(name, balance));
        }
        BufferedImage image = null;
        try {
             image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));

        } catch (IOException e) {

        }
        list.get(0).setX(1600);
        list.get(0).setY(1700);

        list.get(1).setX(800);
        list.get(1).setY(1700);





        if (numOfPlayers > 2) {
            list.get(2).setX(200);
            list.get(2).setY(1400);
        }
        if (numOfPlayers > 3) {
            list.get(3).setX(200);
            list.get(3).setY(700);
        }
        if (numOfPlayers > 4) {
            list.get(4).setX(800);
            list.get(4).setY(400);
        }
        if (numOfPlayers > 5) {
            list.get(5).setX(1500);
            list.get(5).setY(400);
        }
        if (numOfPlayers > 6) {
            list.get(6).setX(2300);
            list.get(6).setY(400);
        }
        if (numOfPlayers > 7) {
            list.get(7).setX(3000);
            list.get(7).setY(700);
        }
        if (numOfPlayers > 8) {
            list.get(8).setX(3000);
            list.get(8).setY(1400);
        }
        if (numOfPlayers > 9) {
            list.get(9).setX(2400);
            list.get(9).setY(1700);
        }
         b = new Board(image, image, image, image, image);
         control = new Control(list);
         table = new FrameTable(list, b);
        String card = "";
        //Background background = new Background();
       WebcamReader w = new WebcamReader(numOfPlayers);
        int dealt  = 0;
        int num = 0;
        do {
            dealt = 0;
            num = 0;
            hand = true;
            while (hand) {
                //DEALING
                do {
                    do {
                        control.getLabel().updateUI();
                        control.getRpanel().updateUI();
                        table.getTable().updateUI();
                    } while (w.getCard().equals("") || w.getCard().equals(temp));

                    temp = w.getCard();
                    card = w.getCard();
                    list.deal(card, num);
                    num++;
                    dealt++;

                }while (dealt != list.getSize() * 2);
                int flop = 0;
                do{
                    do {
                        control.getLabel().updateUI();
                        control.getRpanel().updateUI();
                        table.getTable().updateUI();
                    } while (w.getCard().equals("") || w.getCard().equals(temp));
                    temp = w.getCard();
                    card = w.getCard();
                    try {
                        image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
                        if (flop == 0) {
                            b.setOne(image);
                        } else if (flop == 1) {
                            b.setTwo(image);
                        } else if(flop == 2) {
                            b.setThree(image);
                        } else {
                            System.out.println("error");
                        }

                    } catch (IOException ex) {
                        System.out.println("Oopys");
                    }

                    flop++;
                }while (flop != 3);

                do {
                    control.getLabel().updateUI();
                    control.getRpanel().updateUI();
                    table.getTable().updateUI();
                } while (w.getCard().equals("") || w.getCard().equals(temp));
                temp = w.getCard();
                card = w.getCard();

                try {
                    image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
                    b.setFour(image);

                } catch (IOException ex) {
                    System.out.println("Oopys");
                }

                //wait

                do {
                    control.getLabel().updateUI();
                    control.getRpanel().updateUI();
                    table.getTable().updateUI();
                } while (w.getCard().equals("") || w.getCard().equals(temp));
                temp = w.getCard();
                card = w.getCard();

                try {
                    image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
                    b.setFive(image);

                } catch (IOException ex) {
                    System.out.println("Oopys");
                }

                do {
                    control.getLabel().updateUI();
                    control.getRpanel().updateUI();
                    table.getTable().updateUI();
                } while (hand);


                //LAST LINE
                hand = false;
                //LAST LINE
            }

        } while (true);
    }


}
