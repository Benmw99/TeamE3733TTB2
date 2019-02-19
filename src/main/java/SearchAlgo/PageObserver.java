package SearchAlgo;

public interface PageObserver {

    /**
     * Receive notification from observed object
     * @param object Whatever data might be passed in by the observed object
     */
    public void notify(Object object);
}
