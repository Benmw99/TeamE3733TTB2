package SearchAlgo;

import java.util.List;

public class Context {

    private IFuzzyMatching growthAlgorithm;

    public Context(){}

    public Context(IFuzzyMatching growthAlgorithm) {
        this.growthAlgorithm = growthAlgorithm;
    }

    public void setContext(IFuzzyMatching growthAlgorithm){
        this.growthAlgorithm = growthAlgorithm;
    }

    public List<String> run(List<String> input, int maxDistance, String query){
        return growthAlgorithm.run(input, maxDistance, query);
    }
}
