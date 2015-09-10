package task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by vlad on 10.09.15.
 */
public class Start {

    public static void main(String[] args) throws IOException {
        String path = null;
        if (args != null){
            path = args[0];
        } else {
            path = new String("");
        }
        OutputStream outputStream = null;
        Sorter studentsSorter = new Sorter();
        studentsSorter.process(new FileInputStream(path), outputStream);

    }

}
