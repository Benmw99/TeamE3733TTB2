package SearchAlgo;


import UI.AttributeContainer;
import UI.PageSwitcher;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class PageNumberUpdater implements PageObserver {

    @Override
    public void notify(Object object) {
        SearchContainer s = SearchContainer.getInstance();
        String k = (String)object;
        try {
            int i = parsePageNum(k);
//            System.out.println(i);
            if (i > s.maxPages)  {i = s.maxPages;}
            while(i < 1) {//handle negatives
                i = i + s.maxPages;
                if (i == 0) {i = 1;}
                }
//            System.out.println(i);
            SearchContainer.getInstance().currentPage = i;
            SearchContainer.getInstance().loadQueue();
            new PageSwitcher().pageSwitch("HomeSearch.fxml");
            AttributeContainer.getInstance().backlog.pop();

        }
        catch(NumberFormatException e){
            System.out.println(e);
            System.out.println("Invalid string, not changing page");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }



    private int parsePageNum(String k) throws NumberFormatException{
        k = StringUtils.strip(k);
        int num = 1;
        if(k.equals("end")||k.equals("END")||k.equals("End")||k.equals("last")||k.equals("LAST")||k.equals("Last")){
            num = -1;
        }
        else if(k.equals("first")||k.equals("First")||k.equals("FIRST")){
            num = 1;
        }
        else {
            num = Integer.parseInt(k);
        }
        return num;
    }

}
