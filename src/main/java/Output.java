import java.util.List;

/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class Output {
    public void write(List<String> lines, SystemWrapper sys) {
        for(String line : lines){
            sys.println(line);
        }
    }
}
