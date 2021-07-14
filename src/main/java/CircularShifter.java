import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class CircularShifter {
    public List<String> shiftLines(List<String> lines) {
        List<String> shifted = new ArrayList<>();

        // Going to move the first word to the end of the line repeatedly
        for (String line : lines) {
            // Get all the words in the line
            List<String> words = Arrays.asList(line.split(" "));
            int numWords = words.size();
            for (int i = 0; i < numWords; ++i)
                shifted.add(rotate(words, i));
        }
        return shifted;
    }

    private String rotate(List<String> words, int index) {
        int len = words.size();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; ++i) {
            // Post-increment passes value of index then increments, different from ++index
            sb.append(words.get(index++));
            // Rotate to the beginning if at the end of the line
            if(index == len) index = 0;
            // Only add blank space if not the last word of the line
            if(i + 1 < len) sb.append(" ");
        }
        return sb.toString();
    }
}

