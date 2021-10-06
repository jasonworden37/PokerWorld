import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LinkedList {
    private Node head, tail,dealer,small,big,turn,temp;
    private int size;


    public LinkedList() {
        head = null;
        tail = null;
        dealer = null;
        small = null;
        big = null;
        turn = null;
        size = 0;

    }

    public void add(Player p) {
        Node n = new Node(p);
        if (head == null) {
            head = n;
            dealer = head;


        } else if (tail == null) {
            tail = n;
            head.next = tail;
            tail.next = head;
            small = n;
            turn = small;
            big = head;
            temp = small;
        } else {

            tail.next = n;
            n.next = head;
            tail = n;
            big = small.next;
            turn = big.next;
        }

        size++;

    }

    public void remove(String name) {

        Node curr = head;
        while (!curr.player.getName().equals(name)) {
            curr = curr.next;
            if (curr == head) {
                System.out.println("Couldn't Find Player in LinkedList(1)");
                return;
            }
        }

        if (curr == small) {
            Node t = head;
            while (t.next != dealer) {
                t = t.next;
            }

            dealer = t;

        } else if (curr == big) {
            big = big.next;

        }

        if (curr == head) {
            head = head.next;
            tail.next = head;
        } else if (curr == tail) {
            Node t = head;
            while (t.next != tail) {
                t = t.next;
            }
            t.next = head;
            tail = t;
        } else {
            Node t = head;
            while (t.next != curr) {
                t = t.next;

            }
            t.next = curr.next;
        }
        size--;
    }

    public void nextHand() {
        dealer = dealer.next;
        small = small.next;
        big = big.next;
       turn = big.next;
       temp = small;
        Node n = head;

        while (n.next != head) {
            n.player.setInHand(true);
            n = n.next;
        }
        n.player.setInHand(true);

    }

    public void nextTurn() {
        while (!turn.next.player.isInHand()) {
            turn = turn.next;
        }
        turn = turn.next;

    }

    public void folded(String name) {
        Node n = head;

        while (!n.next.player.getName().equals(name)) {
            n = n.next;
        }
        n = n.next;
        BufferedImage image;
        try {
            image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            n.player.setRight(image,"blank");
            n.player.setLeft(image,"blank");
        } catch (IOException ex) {
            System.out.println("Image Load Exception in LinkedList(1)");
        }
        n.player.setInHand(false);
    }

    public String toString() {

        System.out.println("DEALER: " + dealer.player.getName());
        System.out.println("Small: " + small.player.getName());
        System.out.println("Big: " + big.player.getName());
        String str = "";
        Node n = head;
        while (n.next != head) {
            str += n.player.getName() + " points to -> " + n.next.player.getName() + "\n";
            n = n.next;
        }
        str += n.player.getName() + " points to -> " + n.next.player.getName() + "\n";
        return str;
    }

    public Player get(int index) {
        Node n = head;
        int i = 0;
        while (i != index) {
            i++;
            n = n.next;
        }
        return n.player;
    }

    public int get(Player p) {
        Node n = head;
        int i = 0;
        while (n.player != p) {
            i++;
            n = n.next;
        }
        return i;
    }

    public void deal(String card, int num) {
        BufferedImage image;

        try {
            image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\" + card + ".png"));
            if (num < size ) {
                temp.player.setLeft(image,card);
            } else  {
                temp.player.setRight(image,card);
            }
            temp = temp.next;
        } catch (IOException ex) {
            System.out.println("Image Load Exception in LinkedList(2)");
        }

    }

    public void clearCards() {
        BufferedImage image;
        BufferedImage chips;
        Node n = head;
        try {
            image = ImageIO.read(new File("C:\\Users\\jason\\Pictures\\PNG\\yellow_back.png"));
            chips = null;
            while (n.next != head) {
                n.player.setChips(chips);
                n.player.setRight(image,"blank");
                n.player.setLeft(image,"blank");
                n = n.next;
            }
            n.player.setChips(chips);
            n.player.setRight(image,"blank");
            n.player.setLeft(image,"blank");
        } catch (IOException ex) {
            System.out.println("Image Load Exception in LinkedList(3)");
        }




    }

    public void setChipsOnScreent(BufferedImage image) {

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getDealer() {
        return dealer;
    }

    public void setDealer(Node dealer) {
        this.dealer = dealer;
    }

    public Node getSmall() {
        return small;
    }

    public void setSmall(Node small) {
        this.small = small;
    }

    public Node getBig() {
        return big;
    }

    public void setBig(Node big) {
        this.big = big;
    }

    public Node getTurn() {
        return turn;
    }
    public void AutoTurn(){
        turn = small;
    }

    public void setTurn(Node turn) {
        this.turn = turn;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /* Linked list Node*/
    class Node {
        Player player;
        Node next;
        int bal;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(Player p) {
            player = p;
        }
    }
}
