/**
 * Created by vlad on 10.09.15.
 */
public class Start {

    public static void main(String[] args){
        if (args != null){
            System.out.println("Input string: " + args[0]);
            System.out.println( process(args[0]) );
        }
//        else
    }

    private static int process(String data){

        char[] array = data.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (contains(array, i)) continue;
            else return i;
        }
        return -1;
    }

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