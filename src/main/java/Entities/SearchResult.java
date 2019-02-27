package Entities;

import java.util.List;

import java.util.ArrayList;

public class SearchResult {
    private List<Form> results;
    private String query;
    private AdvancedSearch search;

    public SearchResult() {
        this.results = null;
        this.query = null;
        this.search = null;
    }

    public SearchResult(List<Form> results, String query, AdvancedSearch search) {
        this.results = results;
        this.query = query;
        this.search = search;
    }

    public SearchResult(List<Form> results) {
        this.results = results;
        this.query = null;
        this.search = null;
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

    @Deprecated
    public void printResults(boolean isCSV){
        System.out.println("This doesn't do anything and shouldn't be called");
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

    boolean resultsEquals(List<Form> aList) {
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
