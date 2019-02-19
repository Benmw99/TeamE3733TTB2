package Entities;

public class EntitiesContainer {

    static private String lore =
             "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +"And so it was told, In the beginning there were   "
            +"three almighty gods: the ManufacturerController   "
            +"the AgentController, and the CivilController.     "
            +"These three deities lived in harmony within the   "
            +"spaghetti, along with the Database Singleton that "
            +"lurked in the darkest depths of the code. One day "
            +"the mighty Wong commanded that the gods classes   "
            +"be destroyed, which cast the codebase into chaos. "
            +"The power of the god controllers was split among  "
            +"the many lesser controllers for each page, but a  "
            +"power vacuum soon formed. From the ashes of the   "
            +"former god classes, the AttributeContainer emerged."
            +"This ushered in the Era of the new gods, and soon "
            +"after there was an omnipotent singleton to preside"
            +"over each of the 4 realms"
            +""
            +"Then a robot got yeeted into existence and we won."
            +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";



    private static EntitiesContainer ourInstance = new EntitiesContainer();

    public static EntitiesContainer getInstance() {
        System.out.println(lore);
        return ourInstance;
    }

    private EntitiesContainer() {
    }




}
