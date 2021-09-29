
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Label extends JPanel {
    private playerLabel l;
    private ArrayList<JLabel> labels = new ArrayList<>();

    public Label(LinkedList players) {
        super(new GridLayout(players.getSize(), 1));

        for (int i = 0; i < players.getSize(); i++) {
            l = new playerLabel(players.get(i).getName(), players.get(i).getBalance());
            add(l);
            labels.add(l);


        }

    }

    public ArrayList<JLabel> getLabels() {
        return labels;
    }

    public void rem(ArrayList<JRadioButton> rb) {
        for (int i = 0; i < labels.size();i++) {
            if (rb.get(i).isSelected()) {
                labels.remove(i);
                remove(i);

                break;
            }
        }
    }

    public void setlb(ArrayList<JLabel> rb) {
        this.labels = rb;
    }
}
