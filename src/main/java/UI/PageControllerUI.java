package UI;


import java.io.IOException;

abstract public class PageControllerUI {

    PageSwitcher pageSwitcher = new PageSwitcher(); // this has the page switching logic

    /** onLeave() runs when a page is about to be navigated away from,
     * and should return an AttributeContainer holding any data from this page
     * that following pages will need
     *
     * You should @Override this in your controller
     *
     * @return AttributeContainer
     */

    AttributeContainer attributeContainer = AttributeContainer.getInstance();

    protected abstract void onLeave();

    /** onLoad() runs when a page is first loaded, and gets an AttributeContainer
     * holding data saved by the previous page
     *
     * You should @Override this in your controller
     *
     * @param
     */
    abstract void onLoad();



    /** goToPage(String filenameFXML) is a function used navigate to a different page
     *
     * it calls onLeave() for the current controller; any attributes that
     * need to be available to the next page's controller should be put in
     * the AttributeContainer it returns
     *
     * it then performs the scene switch to the specified FXML
     * and creates the new controller connected to it
     *
     * it then calls onLoad() for the new controller, and passes
     * in the values previously preserved in the AttributeContainer
     *
     * @param filenameFXML FXML File of the scene you want loaded
     */
    public void goToPage (String filenameFXML) {

        try {
            pageSwitcher.pageSwitch(filenameFXML);
        }
        catch (IOException e){
//            System.out.println(e);
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }



}
