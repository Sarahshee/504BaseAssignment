import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class Input {
    public List<String> read(ScannerWrapper scanner, SystemWrapper sys) {
        List<String> contents = new ArrayList<>();
        String file = "kwic.txt";
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(file));
            String line = br.readLine();
            while(line != null) {
                contents.add(line);
                line = br.readLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return contents;
    }
}
