import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static boolean hand = true;
    public static Control control;
    public static FrameTable table;

    public static int numPlayersinHand = 0,numTurnsNeeded = 0;


    public static Board b;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner s = new Scanner(System.in);
        String name,temp = "";
        int balance = 0;
        boolean allSameBal = false;
        System.out.println("How many players are playing?");
        int numOfPlayers = s.nextInt();
        System.out.println("Is everyone starting with the same amount of money?");
        name = s.next();

        if (name.toLowerCase().charAt(0) == 'y') {
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

        System.out.println("what are the blinds you are starting with?");
        int small = s.nextInt();
        int big = s.nextInt();

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));

        } catch (IOException e) {
            System.out.println("Image Load Exception in TestMain(1)");
        }
        list.get(0).setX(1600);
        list.get(0).setY(1700);
        list.get(0).setChipx(1700);
        list.get(0).setChipy(1400);
        list.get(0).setX2(1830);
        list.get(0).setY2(1400);

        list.get(1).setX(800);
        list.get(1).setY(1700);
        list.get(1).setChipx(900);
        list.get(1).setChipy(1400);
        list.get(1).setX2(1030);
        list.get(1).setY2(1400);

        if (numOfPlayers > 2) {
            list.get(2).setX(200);
            list.get(2).setY(1400);
            list.get(2).setChipx(700);
            list.get(2).setChipy(1250);
            list.get(2).setX2(830);
            list.get(2).setY2(1250);
        }
        if (numOfPlayers > 3) {
            list.get(3).setX(200);
            list.get(3).setY(700);
            list.get(3).setChipx(0);
            list.get(3).setChipy(1000);
            list.get(3).setX2(130);
            list.get(3).setY2(1000);
        }
        if (numOfPlayers > 4) {
            list.get(4).setX(800);
            list.get(4).setY(400);
            list.get(4).setChipx(900);
            list.get(4).setChipy(700);
            list.get(4).setX2(1030);
            list.get(4).setY2(700);
        }
        if (numOfPlayers > 5) {
            list.get(5).setX(1500);
            list.get(5).setY(400);
            list.get(5).setChipx(1600);
            list.get(5).setChipy(700);
            list.get(5).setX2(1730);
            list.get(5).setY2(700);
        }
        if (numOfPlayers > 6) {
            list.get(6).setX(2300);
            list.get(6).setY(400);
            list.get(6).setChipx(2400);
            list.get(6).setChipy(700);
            list.get(6).setX2(2530);
            list.get(6).setY2(700);
        }
        if (numOfPlayers > 7) {
            list.get(7).setX(3000);
            list.get(7).setY(700);
            list.get(7).setChipx(2900);
            list.get(7).setChipy(1000);
            list.get(7).setX2(3030);
            list.get(7).setY2(1000);
        }
        if (numOfPlayers > 8) {
            list.get(8).setX(3000);
            list.get(8).setY(1400);
            list.get(8).setChipx(2900);
            list.get(8).setChipy(1250);
            list.get(8).setX2(3030);
            list.get(8).setY2(1250);
        }
        if (numOfPlayers > 9) {
            list.get(9).setX(2400);
            list.get(9).setY(1700);
            list.get(9).setChipx(2500);
            list.get(9).setChipy(1400);
            list.get(9).setX2(2630);
            list.get(9).setY2(1400);
        }
        b = new Board(image, image, image, image, image);
        control = new Control(list);
        table = new FrameTable(list, b);
        String card = "";
        //Background background = new Background();
        WebcamReader w = new WebcamReader(numOfPlayers);
        int dealt = 0;
        int num = 0;
        numPlayersinHand = numOfPlayers;
        do {
            dealt = 0;
            num = 0;
            hand = true;
            numPlayersinHand = numOfPlayers;
            numTurnsNeeded = numPlayersinHand;
            while (hand) {
                //DEALING
                control.buttons.gray();
                control.setSelected(big);
                control.clearBetAmounts();
                table.getPlay().getSmall().player.setBalance(table.getPlay().getSmall().player.getBalance() - small);
                table.getPlay().getBig().player.setBalance(table.getPlay().getBig().player.getBalance() - big);
                table.getPlay().getSmall().player.setAmountBet(small);
                table.getPlay().getBig().player.setAmountBet(big);
                control.setSelected(big);
                control.getLabel().updateUI();
                table.getTable().updateUI();
                do {
                    do {
                        control.getLabel().updateUI();
                        table.getTable().updateUI();
                    } while (w.getCard().equals("") || w.getCard().equals(temp));

                    temp = w.getCard();
                    card = w.getCard();
                    list.deal(card, num);
                    num++;
                    dealt++;

                } while (dealt != list.getSize() * 2);

                control.buttons.Ungray();
                control.buttons.greayCheckButton();
                while (numTurnsNeeded > 0) {
                    //System.out.println("Waiting on ," + numTurnsNeeded + " more turns");
                    control.getLabel().updateUI();
                    table.getTable().updateUI();
                }
                control.buttons.gray();
                if(numPlayersinHand == 1){
                    control.lastPlayer();
                }
                numTurnsNeeded = numPlayersinHand;
                int flop = 0;
                list.AutoTurn();

                do {
                    do {
                        control.getLabel().updateUI();
                        table.getTable().updateUI();
                    } while (w.getCard().equals("") || w.getCard().equals(temp));
                    temp = w.getCard();
                    card = w.getCard();
                    try {
                        image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
                        if (flop == 0) {
                            b.setOne(image,card);
                        } else if (flop == 1) {
                            b.setTwo(image,card);
                        } else if (flop == 2) {
                            b.setThree(image,card);
                        } else {
                            System.out.println("error with flop in TestMain");
                        }

                    } catch (IOException ex) {
                        System.out.println("Image Load Exception in TestMain(2)");
                    }

                    flop++;
                } while (flop != 3);
                control.clearBetAmounts();
                list.AutoTurn();
                control.setSelected(big);
                control.buttons.Ungray();
                control.buttons.grayCallButton();
                while (numTurnsNeeded > 0) {
                    //System.out.println("Waiting on ," + numTurnsNeeded + " more turns");
                    control.getLabel().updateUI();
                    table.getTable().updateUI();
                }
                if(numPlayersinHand == 1){
                    control.lastPlayer();
                }
                numTurnsNeeded = numPlayersinHand;
                control.buttons.gray();
                do {
                    control.getLabel().updateUI();
                    table.getTable().updateUI();
                } while (w.getCard().equals("") || w.getCard().equals(temp));
                temp = w.getCard();
                card = w.getCard();

                try {
                    image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
                    b.setFour(image,card);

                } catch (IOException ex) {
                    System.out.println("Image Load Exception in TestMain(3)");
                }

                //wait
                control.clearBetAmounts();
                list.AutoTurn();
                control.setSelected(big);
                numTurnsNeeded = numPlayersinHand;
                control.buttons.Ungray();
                control.buttons.grayCallButton();
                while (numTurnsNeeded > 0) {
                    //System.out.println("Waiting on ," + numTurnsNeeded + " more turns");
                    control.getLabel().updateUI();
                    table.getTable().updateUI();
                }
                if(numPlayersinHand == 1){
                    control.lastPlayer();
                }
                control.buttons.gray();
                do {
                    control.getLabel().updateUI();
                    table.getTable().updateUI();
                } while (w.getCard().equals("") || w.getCard().equals(temp));
                temp = w.getCard();
                card = w.getCard();

                try {
                    image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
                    b.setFive(image,card);

                } catch (IOException ex) {
                    System.out.println("Image Load Exception in TestMain(4)");
                }
                control.clearBetAmounts();
                list.AutoTurn();
                control.setSelected(big);
                numTurnsNeeded = numPlayersinHand;
                control.buttons.Ungray();
                while (numTurnsNeeded > 0) {
                   //System.out.println("Waiting on ," + numTurnsNeeded + " more turns");
                    control.getLabel().updateUI();
                    table.getTable().updateUI();
                }
                if(numPlayersinHand == 1){
                    control.lastPlayer();
                }
                //System.out.println("hand over!!!");


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                    control.handOver();
                    control.getLabel().updateUI();
                    table.getTable().updateUI();




                hand = false;
                //LAST LINE
            }

        } while (true);
    }


}
