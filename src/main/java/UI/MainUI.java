package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Scene scene1;
//        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
//        primaryStage.setTitle("TTB Application");
//        scene1 = new Scene(root, 1360, 760);
//        primaryStage.setScene(scene1);
//
//        primaryStage.show();
        PageSwitcher.setStage(primaryStage);
        PageSwitcher pageSwitcher = new PageSwitcher();
        pageSwitcher.pageSwitch("WelcomePage.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
