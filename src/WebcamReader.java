import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class WebcamReader extends JFrame implements Runnable, ThreadFactory {


    private static final long serialVersionUID = 6441489157408381878L;


    public static String cards;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private static int num = 0;
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private String card = "";


    public WebcamReader(int num) {
        super();
        this.num = num;



        setLayout(new FlowLayout());
        setTitle("Read QR / Bar Code With Webcam");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        Dimension size = WebcamResolution.QVGA.getSize();

        Dimension d = new Dimension(640,480);
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(d);

        JPanel p = new JPanel();
        JLabel p1 = new JLabel("Jason");
        p.add(p1);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(screenSize);
        panel.setFPSDisplayed(true);


        add(panel);
        add(p);

        pack();
        setVisible(false);

        executor.execute(this);
//        


    }

    @Override
    public void run() {




        Scanner s = new Scanner(System.in);
        boolean quit = false;
        int count = 0;
        int count2 = 0;
        File scan = new File("beep-3.WAV");
        String temp = "";


        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Result result = null;
            BufferedImage image = null;



            if (webcam.isOpen()) {

                if ((image = webcam.getImage()) == null) {
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                    // fall thru, it means there is no QR code in image
                }
            }

            if (result != null) {
                if (!temp.equals(result.getText())) {

                    playSound(scan);
                    temp = result.getText();

                    card = result.getText();


                }


            }




        } while (!quit);



    }

    public static void playSound(File sound) {

        try {

            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);


        } catch (Exception e) {
            System.out.println("Boo");
        }
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "example-runner");
        t.setDaemon(true);
        return t;
    }

    public String getCard()
    {
        return card;
    }




}