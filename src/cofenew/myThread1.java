package cofenew;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class myThread1 extends Thread {

    private String ACCESS_TOKEN;

    public myThread1(String ACCESS_TOKEN) {
        this.ACCESS_TOKEN = ACCESS_TOKEN;

    }

    public void run() {
        for (int i = 0; i < 10; i++) {

            try {

                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String now = dateFormat.format(new Date());
                System.out.println("Current time: " + now);

                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                System.out.println("Resolution is: " + image.getWidth() + "*" + image.getHeight());
                //ImageIO.write(image, "png", new File(now + ".png"));
                // ByteArrayInputStream / ByteArrayOutputStream;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ImageIO.write(image, "png", out);
                
                 InputStream in = new ByteArrayInputStream(out.toByteArray());
                 

                System.out.println(ACCESS_TOKEN + " " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("ПОПАЛ");
                }
            } catch (AWTException ex) {
                Logger.getLogger(myThread1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(myThread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
