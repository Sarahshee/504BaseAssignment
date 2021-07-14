import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class ScannerWrapper {
    private static volatile ScannerWrapper _instance;
    // Sorry, I'm not a fan of the Scanner class, it's very particular.
    private BufferedReader _bf;

    private ScannerWrapper() {
        this._bf = new BufferedReader(new InputStreamReader(System.in));
    }

    public static ScannerWrapper getInstance() {
        if (_instance == null) {
            synchronized (ScannerWrapper.class) {
                if (_instance == null) {
                    _instance = new ScannerWrapper();
                }
            }
        }
        return _instance;
    }

    // Pretend it's a scanner, give it a nextLine() function
    // NOTE: This is a good reason to use a singleton wrapper, you can change the underlying implementation (using a
    // BufferedReader instead of Scanner) and the classes using this wrapper don't know the difference.
    public String nextLine() {
        String line = null;
        try {
            line = this._bf.readLine();
            // See TODO in badInput
            // ***** TODO: *********************************************************************************************
            // TODO: You should all decide if returning null is really the right thing to do given your own code
            // ***** TODO: *********************************************************************************************
            if (line == null || line.length() == 0) return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    // Again, pretending it's a real Scanner
    public Integer nextInt() {
        String line = null;
        Integer i = null;
        try {
            line = this._bf.readLine();
            // ***** TODO: *********************************************************************************************
            // TODO: You should all decide if returning null is really the right thing to do given your own code
            // ***** TODO: *********************************************************************************************
            if (line == null || line.length() == 0) return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try the conversion
        try {
            i = Integer.parseInt(line);
        }
        // Can't parse to an int, invalid input
        catch (NumberFormatException e) {
            // ***** TODO: *********************************************************************************************
            // TODO: You should all decide if returning null is really the right thing to do given your own code
            // ***** TODO: *********************************************************************************************
            return null;
        }
        // Valid int, returning it.
        return i;
    }
}
