import java.util.List;

/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class Alphabetizer {
    public List<String> sort(List<String> lines) {
        int firstChar = 0;
        int trackingChar = firstChar;
        for(int i = 0; i < lines.size(); ++i) {
            for(int j = 0; j < lines.size(); ++j) {
                // Same word, leave it be, continue loop
                if(lines.get(i).equals(lines.get(j))) continue;
                // Get the first characters of each String
                char a = lines.get(i).charAt(firstChar);
                char b = lines.get(j).charAt(firstChar);
                // when a is > than b, no need to do anything
                // when a < b, need to swap
                if(a < b) swap(lines, i, j);
                // Deal with case where more than first char is needed
                while(a == b && trackingChar < lines.get(i).length() && trackingChar < lines.get(j).length()) {
                    ++trackingChar;
                    a = lines.get(i).charAt(trackingChar);
                    b = lines.get(j).charAt(trackingChar);
                    if(a < b) {
                        swap(lines, i, j);
                        break;
                    }
                }
                trackingChar = 0;
            }
        }
        return lines;
    }

    private void swap(List<String> swapList, int i, int j) {
        String temp = swapList.get(i);
        swapList.set(i, swapList.get(j));
        swapList.set(j, temp);
    }
}
