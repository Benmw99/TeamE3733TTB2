package SearchAlgo;

import java.util.List;

public interface IFuzzyMatching {

    public List<String> run(List<String> input, int maxDistance, String query);
}
