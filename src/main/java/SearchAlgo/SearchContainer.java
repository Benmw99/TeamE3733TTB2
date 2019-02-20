package SearchAlgo;

import Entities.SearchResult;
import UI.AttributeContainer;

public class SearchContainer {
    public SearchResult searchResult;
    public int maxPages;
    public int currentPage;


    private static SearchContainer ourInstance = new SearchContainer();

    public static SearchContainer getInstance() {
        return ourInstance;
    }

    private SearchContainer() {
        this.searchResult = new SearchResult();
        this.currentPage = 1;  //index starting at 1 for sake of UI simplicity
        this.maxPages = 1;
    }

    public void setPages(){
        this.maxPages = (int)Math.ceil(searchResult.getResults().size() / 50.0);
        this.currentPage = 1;
    }

    public void loadQueue(){
        int begin = (currentPage - 1)*50;
        int end;
        if(currentPage == maxPages){
            end = searchResult.getResults().size();
        }else{
            end = (begin + 50);
        }
        AttributeContainer.getInstance().formQueue = searchResult.getResults().subList(begin,end);
    }





}
