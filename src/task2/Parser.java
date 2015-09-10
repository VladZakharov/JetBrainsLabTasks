package task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vlad on 10.09.15.
 */
public class Parser {

    public static InputStream parse(String path) throws IOException {
        // инициализируем поток на чтение
        InputStream inputstream = new FileInputStream(path);

        // читаем первый символ в байтах (ASCII)
        int data = inputstream.read();
        char content;
        // по байтово читаем весь файл
        while(data != -1) {
            // преобразуем полученный байт в символ
            content = (char) data;
            // выводим посимвольно
            System.out.print(content);
            data = inputstream.read();
        }
        // закрываем поток
        inputstream.close();
        return inputstream;
    }

}
