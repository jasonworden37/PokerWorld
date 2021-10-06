import javax.swing.*;
import java.awt.*;

public class FrameTable extends JFrame {
    private Table table;
    public FrameTable(LinkedList players, Board b) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Poker");
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screensize.width, screensize.height);
        table = new Table(players, b);
        add(table);
        setVisible(true);
    }

    public LinkedList getPlay(){
        return table.players;
    }
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
