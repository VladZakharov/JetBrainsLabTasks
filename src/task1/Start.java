package task1;

/**
 * Created by vlad on 10.09.15.
 */
public class Start {

    public static void main(String[] args){

        if (args.length > 0 && args[0] != null){
            System.out.println("Your string: " + args[0]);
            System.out.println("Program execution result: " + process(args[0]));
        } else {
            System.out.println("Restart program with input string as argument");
        }

    }

    /**
     * @param data произвольная строка
     * @return индекс первого не повторяющегося символа в ней, -1, если все символы в строке повторяются, -2, если строка null.
     */
    static int process(String data){
        if (data == null) return -2;
        char[] array = data.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (contains(array, i)) continue;
            else return i;
        }
        return -1;
    }

    /**
     * @param array строка, как массив символов.
     * @param index индекс проверяемого символа в этой строке.
     * @return true, если символ повторяется в этой строке. Иначе - false.
     */
    private static boolean contains(char[] array, int index){
        char compared = array[index++];
        for (int i = index; i < array.length; i++)
            if (compared == array[i]) return true;
        index -= 2;
        for (int i = index; i >= 0; i--)
            if (compared == array[i]) return true;
        return false;
    }

}