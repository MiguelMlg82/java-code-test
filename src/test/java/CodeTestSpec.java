import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

import org.junit.Test;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
    	// arrange
    	final String[] EXPECTED = {"A", "B", "C"};
    	
    	// act
    	final String[] actual = CodeTest.uppercaseArray(new String[] {"a", "b", "c"});
    	
    	// assert
    	assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
    	// arrange
    	final int EXPECTED = 2;
    	
    	// act
    	final int actual = CodeTest.findWordCount(new String("The cat jumped over the mat"), "the");
    	
    	// assert
    	assertEquals(EXPECTED, actual);
    }

    @Test
    public void composeU_returnsExpectedResult() {
    	// arrange
    	final int EXPECTED = 6;
    	
    	// act
    	final Function<Integer, Integer> func1 = x -> x + 1;
    	final Function<Integer, Integer> func2 = x -> x * 2;
    	final Function<Integer, Integer> resultFunc = CodeTest.composeU(func1, func2);
    	
    	// assert
    	assertEquals(EXPECTED, resultFunc.apply(2));
    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
    	String testString = "test\nString";
    	
    	InputStream stream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
    	BufferedReader bf = new BufferedReader(new InputStreamReader(stream));
    	
    	try {
    		assertEquals("test", bf.readLine());
			assertEquals("String", bf.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleInvalidArgument_returnsExpectedResult() {
    	CodeTest.handleInvalidArgument();
    }

    @Test
    public void puzzle_returnsExpectedResult() {
    	PrintStream save_out = System.out;
    	final ByteArrayOutputStream out = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(out));

        System.out.println("1,3,5,5,Snap");
        assertEquals("1,3,5,5,Snap\r\n", out.toString());

        System.setOut(save_out);
    }
}
