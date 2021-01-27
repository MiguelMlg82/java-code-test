import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class CodeTest {
    public static void main(String[] args) {
        System.out.println("Please replace this with calls to all completed tests.");
        
        System.out.println("STEP 1");
        String[] myArray = new String[] {"1", "2", "3"};
        String[] result = reverseArray(myArray);
        System.out.println(Arrays.asList(result));
    }

    public static String[] reverseArray(String[] input) {
    	if (input != null) {
        	Collections.reverse(Arrays.asList(input));
        	return input;
        } else {
        	return new String[0];
        }
    }

    public static String[] uppercaseArray(String[] input) {
        // add code here
        return input;
    }

    public static int findWordCount(String text, String wordToFind) {
        // add code here
        return 0;
    }

    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){
        // add code here
        return null;
    }

    public static void writeContentsToConsole() {
        // add code here
    }

    public static void handleInvalidArgument() {
        // add code here
    }

    public static void puzzle() {
        // add code here
    }
}