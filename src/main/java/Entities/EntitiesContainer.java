package Entities;

public class EntitiesContainer {

    static private String lore =
             "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
            +"And so it was told, In the beginning there were   \n"
            +"three almighty gods: the ManufacturerController   \n"
            +"the AgentController, and the CivilController.     \n"
            +"These three deities lived in harmony within the   \n"
            +"spaghetti, along with the Database Singleton that \n"
            +"lurked in the darkest depths of the code. One day \n"
            +"the mighty Wong commanded that the gods classes   \n"
            +"be destroyed, which cast the codebase into chaos. \n"
            +"The power of the god controllers was split among  \n"
            +"the many lesser controllers for each page, but a  \n"
            +"power vacuum soon formed. From the ashes of the   \n"
            +"former god classes, the AttributeContainer emerged.\n"
            +"This ushered in the Era of the new gods, and soon \n"
            +"after there was an omnipotent singleton to preside\n"
            +"over each of the 4 realms\n"
            +"\n"
            +"Then a robot got yeeted into existence and we won.\n"
            +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n"
                     +"\n";



    private static EntitiesContainer ourInstance = new EntitiesContainer();

    public static EntitiesContainer getInstance() {
        System.out.println(lore);
        return ourInstance;
    }

    private EntitiesContainer() {
    }




}
