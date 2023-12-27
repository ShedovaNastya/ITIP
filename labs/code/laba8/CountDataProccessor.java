import java.util.List;

public class CountDataProccessor {

    @DataProcessor
    public static void countNumbers(List<Integer> input, List<Integer> output) {
        output.add(input.size());
    }
}
