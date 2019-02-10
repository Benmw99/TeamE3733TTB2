package Entities;

import java.util.List;

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

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public AdvancedSearch getSearch() {
        return search;
    }

    public void setSearch(AdvancedSearch search) {
        this.search = search;
    }
}
