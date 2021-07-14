import java.util.List;

/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class MasterControl {
    public static void main(String[] args) {
        MasterControl mc = new MasterControl();
        mc.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());
    }

    public void start(ScannerWrapper scanner, SystemWrapper sys) {
        // Get the file contents
        Input input = new Input();
        List<String> fileContents = input.read(scanner, sys);

        // Shift the liens
        CircularShifter shifter = new CircularShifter();
        List<String> shiftedLines = shifter.shiftLines(fileContents);

        // Alphabetize them
        Alphabetizer alpha = new Alphabetizer();
        List<String> sortedLines = alpha.sort(shiftedLines);

        // Write to output file
        Output out = new Output();
        out.write(sortedLines, sys);
    }
}
