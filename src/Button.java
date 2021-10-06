import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JPanel {
    private JButton fold;
    private JButton check;
    private JButton bet;
    private JButton call;
    private JButton newHand;
    private JButton tf;
    private JButton hun;
    private JButton fhun;
    private JButton thous;
    private JButton fthous;
    private JButton clear;
    private JButton remove;




    private Color n = new Color(36, 55, 77);
    private Color red = new Color(178, 34, 34);
    private Color green = new Color(0, 100 ,0);
    private Color blue = new Color(25, 25, 112);
    private Color grey = new Color(26, 26, 26);
    private Color purple = new Color(221, 153, 255);
    private Color orange = new Color(255, 191, 128);

    public Button() {
        super(new GridLayout(2,5));


        tf = new JButton();
        tf.setText("$25");
        tf.setBackground(orange);
        tf.setForeground(Color.white);
        tf.setPreferredSize(new Dimension(600,400));
        tf.setFont(new Font("Arial", Font.BOLD, 96));

        hun = new JButton();
        hun.setText("$100");
        hun.setBackground(red);
        hun.setForeground(Color.white);
        hun.setPreferredSize(new Dimension(600,400));
        hun.setFont(new Font("Arial", Font.BOLD, 96));

        fhun = new JButton();
        fhun.setText("$500");
        fhun.setBackground(green);
        fhun.setForeground(Color.white);
        fhun.setPreferredSize(new Dimension(600,400));
        fhun.setFont(new Font("Arial", Font.BOLD, 96));

        thous = new JButton();
        thous.setText("$1000");
        thous.setBackground(grey);
        thous.setForeground(Color.white);
        thous.setPreferredSize(new Dimension(600,400));
        thous.setFont(new Font("Arial", Font.BOLD, 96));

        fthous = new JButton();
        fthous.setText("$5000");
        fthous.setBackground(blue);
        fthous.setForeground(Color.white);
        fthous.setPreferredSize(new Dimension(600,400));
        fthous.setFont(new Font("Arial", Font.BOLD, 96));

        clear = new JButton();
        clear.setText("Clear");
        clear.setBackground(purple);
        clear.setForeground(Color.white);
        clear.setPreferredSize(new Dimension(600,400));
        clear.setFont(new Font("Arial", Font.BOLD, 96));

        fold = new JButton();
        fold.setText("Fold");
        fold.setBackground(n);
        fold.setForeground(Color.white);
        fold.setPreferredSize(new Dimension(600, 300));
        fold.setFont(new Font("Arial", Font.ITALIC, 96));

        bet = new JButton();
        bet.setText("Raise");
        bet.setBackground(n);
        bet.setForeground(Color.white);
        bet.setPreferredSize(new Dimension(600,400));
        bet.setFont(new Font("Arial", Font.ITALIC, 96));


        check = new JButton();
        check.setText("Check");
        check.setBackground(n);
        check.setForeground(Color.white);
        check.setPreferredSize(new Dimension(600,400));
        check.setFont(new Font("Arial", Font.ITALIC, 96));

        call = new JButton();
        call.setText("Call");
        call.setBackground(n);
        call.setForeground(Color.white);
        call.setPreferredSize(new Dimension(600,400));
        call.setFont(new Font("Arial", Font.ITALIC, 96));




        this.add(tf);
        this.add(hun);
        this.add(fhun);
        this.add(thous);
        this.add(fthous);

        this.add(check);
        this.add(fold);
        this.add(bet);
        this.add(call);
        this.add(clear);



    }


    public void greayCheckButton() {
        check.setEnabled(false);
    }

    public void grayCallButton() {
        call.setEnabled(false);
    }

    public void unGrayCallButton() {
        call.setEnabled(true);
    }
    public void Ungray() {
        check.setEnabled(true);
        bet.setEnabled(true);
        call.setEnabled(true);
        fold.setEnabled(true);

    }
    public void gray(){
        check.setEnabled(false);
        bet.setEnabled(false);
        call.setEnabled(false);
        fold.setEnabled(false);

    }

    public JButton getFold() {
        return fold;
    }

    public JButton getCheck() {
        return check;
    }

    public JButton getBet() {
        return bet;
    }

    public JButton getCall() {
        return call;
    }

    public JButton getTf() {
        return tf;
    }

    public JButton getHun() {
        return hun;
    }

    public JButton getFhun() {
        return fhun;
    }

    public JButton getThous() {
        return thous;
    }

    public JButton getFthous() {
        return fthous;
    }

    public JButton getClear() {
        return clear;
    }


}
