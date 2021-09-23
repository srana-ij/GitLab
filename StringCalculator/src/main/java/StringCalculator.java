import java.util.stream.IntStream;

/**
 * created by sohel rana on 23-9-2021 for skill test
 */
public class StringCalculator {

    /** method **/

    public int add(String numberString) {
        NumberStringParser numberStringParser = new NumberStringParser(numberString);
        int[] parsedNumbers = numberStringParser.parse();
        return IntStream.of(parsedNumbers).sum();
    }

}
