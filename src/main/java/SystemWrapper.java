/**
 * @author Sean Grimes, sean@seanpgrimes.com
 * @since 7/13/21
 */
public class SystemWrapper {
    private static volatile SystemWrapper _sys;
    private SystemWrapper() { }

    public static SystemWrapper getInstance() {
        if(_sys == null) {
            synchronized (SystemWrapper.class) {
                if(_sys == null) {
                    _sys = new SystemWrapper();
                }
            }
        }
        return _sys;
    }

    public void println(Object out) {
        System.out.println(out);
    }
}
