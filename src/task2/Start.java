package task2;

import java.io.*;

/**
 * Created by vlad on 10.09.15.
 */
public class Start {

    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0] != null){
            String outputPath = createOutputPath(args[0],"out.txt");
            OutputStream outputStream = new FileOutputStream(outputPath);
            Sorter studentsSorter = new Sorter();
            studentsSorter.process(new FileInputStream(args[0]), outputStream);
            System.out.println("Program execution result was written to " + outputPath);
        } else {
            System.out.println("Restart program with path to file as argument");
        }

    }

    /**
     * @param inputPath путь к входному файлу.
     * @param outputFileName название выходного файла.
     * @return путь к выходному файлу.
     */
    private static String createOutputPath(String inputPath, String outputFileName){
        String[] tempArray = inputPath.split("/");
        String result = "";
        for (int i = 0; i < tempArray.length - 1; i++)
            result += (tempArray[i]+"/");
        result += outputFileName;
        return result;
    }

}
