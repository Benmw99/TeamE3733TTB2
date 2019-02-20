package SearchAlgo;

public interface PageObservable {


    /**
     * Register an object as observing this class
     * @param o Object to register
     */
    void register(PageObserver o);

    /**
     * Notify observers of change
     */
    void notifyObservers();

}
