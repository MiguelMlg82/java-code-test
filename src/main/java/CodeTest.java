import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeTest {
	
	private static final String PATH = "resources/testFile.txt";
	
	private static Integer[] randomSequence;
	
    public static void main(String[] args) {
        System.out.println("Please replace this with calls to all completed tests.");
        
        // Point 1: Reverse an array
        System.out.println("STEP 1");
        String[] myArray = new String[] {"1", "2", "3"};
        String[] result = reverseArray(myArray);
        System.out.println(Arrays.asList(result));
        
        // Point 2: Transform an array of strings to an upper-case array of strings
        System.out.println("STEP 2");
        String[] myArray2 = {"a", "b", "c"};
        String[] result2 = uppercaseArray(myArray2);
        System.out.println(Arrays.asList(result2));
        
        // Point 3: Count the number of unique words in a string
        System.out.println("STEP 3");
        String text = "the cat jumped over the mat";
        text = text.replaceAll("[\\.\\,\\(\\)]", "");
        String[] words = text.split(" ");
        HashMap<String, Integer> counterMap = new HashMap<>();
        for (String word : words) {
        	int cont = findWordCount(text, word);
        	if (!counterMap.containsKey(word)) {
        		counterMap.put(word, cont);
        	}
        }
        String resultString = null;
        for (HashMap.Entry<String, Integer> entry : counterMap.entrySet()) {
        	if (resultString == null) {
        		resultString = "[{" + entry.getKey() + ":" + entry.getValue() + "}";
        	} else {
        		resultString += ", {" + entry.getKey() + ":" + entry.getValue() + "}";
        	}
        }
        resultString += "]";
        System.out.println(resultString);
        
        // Point 4: Unify two unary functions
        System.out.println("STEP 4");
        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> f2 = x -> x * 2;
        System.out.println(composeU(f1, f2).apply(2));
        
        // Point 5: Read a file and prints the content to the console
        System.out.println("STEP 5");
        writeContentsToConsole();
        
        // Point 6: Example of how to handle an invalid argument
        try {
        	handleInvalidArgument();
        } catch (IllegalArgumentException e) {
        	System.out.println("STEP 6");
        	System.out.println("Invalid argument exception thrown");
        }
        
        // Point 7: Using a random sequence of numbers, look for 2 equals and consecutive numbers
        randomSequence = new Integer[] {1,3,5,5,9};
        puzzle();
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
    	int cont = 0;
    	String[] words = text.split(" ");
    	for (String word : words) {
    		if (word.equalsIgnoreCase(wordToFind)) {
    			cont++;
    		}
    	}
    	return cont;
    }

    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){
    	return f1.andThen(f2);
    }

    public static void writeContentsToConsole() {
    	FileInputStream fileInputStream = null;
		BufferedReader reader = null;
		
		try {
			fileInputStream = new FileInputStream(PATH);
			reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
			
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: An unexpected error ocurred while reading the file.");
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println("ERROR: An unexpected error ocurred while closing the file.");
				e.printStackTrace();
			}
		}
    }

    public static void handleInvalidArgument() {
        int index = -1;
        
    	String[] myArray = new String[10];
    	if (index < 0) {
    		throw new IllegalArgumentException("Invalid index value. It should be 0 or higher.");
    	} else {
    		System.out.println(myArray[index]);	
    	}
    }

    public static void puzzle() {
        int prev = 0;
        StringBuilder result = new StringBuilder();
        
        prev = randomSequence[0];
        result.append(prev);
        for (int i = 1; i < randomSequence.length; i++) {
        	if (prev == randomSequence[i]) {
        		result.append(",").append(randomSequence[i])
        			.append(",").append("Snap");
        		break;
        	} else {
        		result.append(",").append(randomSequence[i]);
        		prev = randomSequence[i];
        	}
        }
        System.out.println(result.toString());
    }
}