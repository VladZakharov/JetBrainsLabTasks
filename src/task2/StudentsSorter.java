package task2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by vlad on 10.09.15.
 */


public interface StudentsSorter {
    void process(InputStream input, OutputStream output) throws IOException;
}