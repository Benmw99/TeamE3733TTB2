package UI;

import Entities.EntitiesContainer;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainUI extends Application {

    /**
     * Starts program UI and directs to HomeSearch
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Scene scene1;
//        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
//        primaryStage.setTitle("TTB Application");
//        scene1 = new Scene(root, 1360, 760);
//        primaryStage.setScene(scene1);
//
//        primaryStage.show();
        EntitiesContainer.getInstance();
        PageSwitcher.setStage(primaryStage);
        PageSwitcher pageSwitcher = new PageSwitcher();
        pageSwitcher.pageSwitch("HomeSearch.fxml");
    }

    //Should make it so when the program is shutdown hibernate is shutdown with it
    @Override
    public void stop() throws Exception {
        DB.Database db = DB.Database.getDatabase();
        db.shutdown();
    }

    /**
     * Launches the program UI
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
