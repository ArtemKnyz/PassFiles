package cofenew;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.print.DocFlavor;

public class CofeNew {

    public static void main(String[] args) {

        myThread1 myThread1 = new myThread1("sdf");
        myThread1.start();
//
//        myThread1 myThread2 = new myThread1(2);
//        myThread2.start();
        // TODO code application logic here
        String ACCESS_TOKEN = "KalC9BCt3VAAAAAAAAABwwRN7lncK5br5qwwvGTj5NFZo3MWNTU7-n_itkuUlsCV";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        try {
            //InputStream in = new FileInputStream("test.txt");
            InputStream in = new FileInputStream("now.png");
            //FileMetadata metadata = client.files().uploadBuilder("/test2.txt").uploadAndFinish(in);
            FileMetadata metadata = client.files().uploadBuilder("/now2.png").uploadAndFinish(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
