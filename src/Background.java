//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamPanel;
//import com.github.sarxos.webcam.WebcamResolution;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//
//import static java.awt.Color.orange;
//
//public class Background extends JFrame implements Runnable, ThreadFactory {
//    private static final long serialVersionUID = 6441489157408381878L;
//
//
//    private Executor executor = Executors.newSingleThreadExecutor(this);
//
//    private Webcam webcam = null;
//    private WebcamPanel panel = null;
//
//    public Background(){
//        setLayout(new FlowLayout());
//        setTitle("Background");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(screenSize.width, screenSize.height);
//        Dimension size = WebcamResolution.QVGA.getSize();
//
//        Dimension d = new Dimension(640,480);
//        webcam = Webcam.getWebcams().get(0);
//        webcam.setViewSize(d);
//
//
//        panel = new WebcamPanel(webcam);
//        panel.setPreferredSize(screenSize);
//        panel.setFPSDisplayed(true);
//
//
//
//
//
//        JButton button = new JButton("Test");
//        button.setBackground(orange);
//        button.setForeground(Color.white);
//        button.setPreferredSize(new Dimension(600,400));
//       button.setFont(new Font("Arial", Font.BOLD, 96));
//       panel.add(button);
//
//        add(panel);
//        pack();
//        setVisible(true);
//
//        executor.execute(this);
//
//    }
//
//    @Override
//    public void run() {
//
//    }
//
//    @Override
//    public Thread newThread(Runnable r) {
//        return null;
//    }
//}
