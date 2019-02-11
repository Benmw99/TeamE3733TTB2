package SearchAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevenshteinDistance implements IFuzzyMatching{


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
     *
     * Compute the Levenshtein distance between the specified source
     * string and the specified target string.
     */
    static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + cost(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    public static int cost(char a, char b) {
        if(a ==b){
            return 0;
        }else{
            return 1;
        }
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }


}
