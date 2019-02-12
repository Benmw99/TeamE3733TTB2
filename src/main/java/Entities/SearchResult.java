package Entities;

import java.util.List;
import Entities.Sorting.BrandNameSort;
import Entities.Sorting.DateSort;

import java.util.ArrayList;
import java.util.Collections;

public class SearchResult {
    private List<Form> results;
    private String query;
    private AdvancedSearch search;

    public SearchResult() {
    }

    public SearchResult(List<Form> results, String query, AdvancedSearch search) {
        this.results = results;
        this.query = query;
        this.search = search;
    }

    public List<Form> getResults() {
        return results;
    }

    public void setResults(List<Form> results) {
        this.results = results;
    }

    public void addResult(Form form){
        results.add(form);
    }


    public void addResults(ArrayList<Form> forms){
        results.addAll(forms);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void printResults(boolean isCSV){
        DB.Database db = DB.Database.getDatabase();
        db.dbSelect.downloadQuery(this, isCSV);
    }


    public void sortBrandName(){
        Collections.sort(results, new BrandNameSort());
    }

    public void sortDate(){
        Collections.sort(results, new DateSort());
    }


    public AdvancedSearch getSearch() {
        return search;
    }

    public void setSearch(AdvancedSearch search) {
        this.search = search;
    }

    boolean equals(SearchResult aSearchRes){
        return ( resultsEquals(aSearchRes.results) &&
            this.query.equals(aSearchRes.query) &&
            this.search.equals(aSearchRes.search));
    }

    boolean resultsEquals(ArrayList<Form> aList) {
        ArrayList<Form> resultList = new ArrayList<Form>();
        for (Form f : aList) {
            for (Form s : this.results) {
                if (f.equals(s)) {
                    resultList.add(f);
                }
            }
        }
        return (this.results.size() == resultList.size());
    }
}
