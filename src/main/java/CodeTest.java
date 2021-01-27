import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeTest {
    public static void main(String[] args) {
        System.out.println("Please replace this with calls to all completed tests.");
        
        System.out.println("STEP 1");
        String[] myArray = new String[] {"1", "2", "3"};
        String[] result = reverseArray(myArray);
        System.out.println(Arrays.asList(result));
        
        
        System.out.println("STEP 2");
        String[] myArray2 = {"a", "b", "c"};
        String[] result2 = uppercaseArray(myArray2);
        System.out.println(Arrays.asList(result2));
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
    	if (input != null)  {
    		List<String> myArrayList = Arrays.asList(input).stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
            return myArrayList.toArray(new String[myArrayList.size()]);	
    	} else {
    		return new String[0];
    	}
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