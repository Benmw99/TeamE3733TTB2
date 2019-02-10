package SearchAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DamerauLevenshtein implements IFuzzyMatching {


    private final int deleteCost = 1;
    private final int insertCost = 1;
    private final int replaceCost = 1;
    private final int swapCost = 1;

    /**
     *
     * @param input
     *          list of strings to be tested against the query
     * @param maxDistance
     *          maximum "cost" of each string compared to query
     * @param query
     *          query string used as reference
     * @return
     *          list of strings close enough to query by given value of maxDistance
     */
    public List<String> run(List<String> input, int maxDistance, String query){
        ArrayList<String> ret = new ArrayList<>();
        for(int i = 0; i < input.size(); i++){
            if (calculate(input.get(i),query) <= maxDistance ){
                ret.add(input.get(i));
            }
        }
        return ret;
    }


    /**
     * Compute the Damerau-Levenshtein distance between the specified source
     * string and the specified target string.
     */
    public int calculate(String source, String target) {
        if (source.length() == 0) {
            return target.length() * insertCost;
        }
        if (target.length() == 0) {
            return source.length() * deleteCost;
        }
        int[][] table = new int[source.length()][target.length()];
        Map<Character, Integer> sourceIndexByCharacter = new HashMap<Character, Integer>();
        if (source.charAt(0) != target.charAt(0)) {
            table[0][0] = Math.min(replaceCost, deleteCost + insertCost);
        }
        sourceIndexByCharacter.put(source.charAt(0), 0);
        for (int i = 1; i < source.length(); i++) {
            int deleteDistance = table[i - 1][0] + deleteCost;
            int insertDistance = (i + 1) * deleteCost + insertCost;
            int matchDistance = i * deleteCost
                    + (source.charAt(i) == target.charAt(0) ? 0 : replaceCost);
            table[i][0] = Math.min(Math.min(deleteDistance, insertDistance),
                    matchDistance);
        }
        for (int j = 1; j < target.length(); j++) {
            int deleteDistance = (j + 1) * insertCost + deleteCost;
            int insertDistance = table[0][j - 1] + insertCost;
            int matchDistance = j * insertCost
                    + (source.charAt(0) == target.charAt(j) ? 0 : replaceCost);
            table[0][j] = Math.min(Math.min(deleteDistance, insertDistance),
                    matchDistance);
        }
        for (int i = 1; i < source.length(); i++) {
            int maxSourceLetterMatchIndex = source.charAt(i) == target.charAt(0) ? 0
                    : -1;
            for (int j = 1; j < target.length(); j++) {
                Integer candidateSwapIndex = sourceIndexByCharacter.get(target
                        .charAt(j));
                int jSwap = maxSourceLetterMatchIndex;
                int deleteDistance = table[i - 1][j] + deleteCost;
                int insertDistance = table[i][j - 1] + insertCost;
                int matchDistance = table[i - 1][j - 1];
                if (source.charAt(i) != target.charAt(j)) {
                    matchDistance += replaceCost;
                } else {
                    maxSourceLetterMatchIndex = j;
                }
                int swapDistance;
                if (candidateSwapIndex != null && jSwap != -1) {
                    int iSwap = candidateSwapIndex;
                    int preSwapCost;
                    if (iSwap == 0 && jSwap == 0) {
                        preSwapCost = 0;
                    } else {
                        preSwapCost = table[Math.max(0, iSwap - 1)][Math.max(0, jSwap - 1)];
                    }
                    swapDistance = preSwapCost + (i - iSwap - 1) * deleteCost
                            + (j - jSwap - 1) * insertCost + swapCost;
                } else {
                    swapDistance = Integer.MAX_VALUE;
                }
                table[i][j] = Math.min(Math.min(Math
                        .min(deleteDistance, insertDistance), matchDistance), swapDistance);
            }
            sourceIndexByCharacter.put(source.charAt(i), i);
        }
        return table[source.length() - 1][target.length() - 1];
    }

}
