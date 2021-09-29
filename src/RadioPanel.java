import sun.awt.image.ImageWatched;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RadioPanel extends JPanel {
    private RadioButton r;
    private ArrayList<JRadioButton> rb = new ArrayList<>();
    private ButtonGroup buttonGroup;
    public RadioPanel(LinkedList players) {
        super(new GridLayout(1, players.getSize()));
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < players.getSize();i++) {
            r = new RadioButton(players.get(i).getName());
            add(r);
            buttonGroup.add(r);
            rb.add(r);
        }

    }

    public ArrayList<JRadioButton> getRb() {
        return rb;
    }

    public void rem(LinkedList players) {
        for (int i = 0; i < rb.size();i++) {
            if (rb.get(i).isSelected()) {
                players.remove(players.get(i).getName());
                players.nextTurn();
                rb.remove(i);
                remove(i);

                break;
            }
        }


//        buttonGroup.remove();
    }

    public int winner() {
        for (int i = 0; i < rb.size();i++) {
            if (rb.get(i).isSelected()) {
                return i;

            }
        }
        return -1;
    }

    public void setRb(ArrayList<JRadioButton> rb) {
        this.rb = rb;
    }
}
