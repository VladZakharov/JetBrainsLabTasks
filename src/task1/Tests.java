package task1;

import java.util.Random;

/**
 * Created by vlad on 11.09.15.
 */
public class Tests {

    public static void main(String[] args){
        makeTest(10000,1000);
    }

    public static void makeTest(int numOfIterations, int stringLenght){
        //неохото искать коды в интернете)
        char[] array = {'a','b','c','d','e','f','g','h','i','g','k','l','m','n','o','p','7','1','0','3'};
        for (int i = 0; i < numOfIterations; i++) {
            String string = "";
            for (int j = 0; j < stringLenght; j++)
                string += array[ getRandomInt(0, array.length-1) ];

            int result = Start.process(string);

            if (result == -1){
                if (!checkOnRepeats(string)){
                    System.out.println("Test failed");
                    return;
                }
            } else {
                if (!checkLonely(string,result)){
                    System.out.println("Test failed");
                    return;
                }

                if (!checkPreviousChars(string,result)){
                    System.out.println("Test failed");
                    return;
                }
            }
        }
        System.out.println("Test OK");
    }

    /**
     * @param min
     * @param max
     * @return рандомный int в области [ min, max ].
     */
    private static int getRandomInt(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    /**
     * @param str
     * @return true, если в строке нет повторяющихся символов; иначе - false.
     */
    private static boolean checkOnRepeats(String str){
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++)
            if (checkLonely(str, i)) return false;
        return true;
    }

    /**
     * @param str
     * @param index
     * @return true, если символ стоящий на позиции index в строке str встречается в этой строке только один раз.
     * Иначе - false.
     */
    private static boolean checkLonely(String str, int index){
        char[] charArray = str.toCharArray();
        char charForCheck = charArray[index];
        for (char ch : charArray)
            if (charForCheck == ch) return false;
        return true;
    }

    /**
     * @param str
     * @param index
     * @return true, если в строке str символы от 0 до index встречаются более одного раза.
     * Иначе - false;
     */
    private static boolean checkPreviousChars(String str, int index){
        char[] charArray = str.toCharArray();
        for (int i = 0; i < index; i++)
            if (checkLonely(str, i)) return false;
        return true;
    }

}
