package SearchAlgo;

import Entities.AdvancedSearch;
import Entities.Form;

import java.util.List;

public class Search {

    public static List<Form> SearchDLBrand(AdvancedSearch advancedSearch, IFuzzyMatching algo){
        DB.Database db = DB.Database.getDatabase();

        Context fuzzyAlgo = new Context();
        fuzzyAlgo.setContext(algo);

        List<String> in = db.dbSelect.searchByLD(advancedSearch);

        //assuming search by brand name with max cost of 2
        List<String> out = fuzzyAlgo.run(in,2,advancedSearch.getBrandName());

        return db.dbSelect.searchByLDBrand(advancedSearch, out);

    }

}
