package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class PageSwitcher {
    static Stage stage;

    public static void setStage(Stage stage) {
        PageSwitcher.stage = stage;
    }

    public void pageSwitch(String filename) throws IOException {
        pageSwitch(null, filename, stage);
    }
    public void pageSwitch(ActionEvent event, String filename) throws IOException {
        pageSwitch(event, filename, stage);
    }

    public void pageSwitch(ActionEvent event, String filename, Stage stage) throws IOException {

        //////////////////////////////////////////////////////
        //  PAGE SWITCHING
        //////////////////////////////////////////////////////
        Parent root;
//        Stage stage;
//        stage=(Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
   //     System.out.println(new File("src/main/java/UI/WelcomePage.fxml").toURI());
  //      System.out.println(getClass().getResource("/src/main/java/UI/WelcomePage.fxml"));
        loader.setLocation(new File("src/main/java/UI/" + filename).toURI().toURL());
        AttributeContainer ac = AttributeContainer.getInstance();
        ac.backlog.push(filename);
        root = loader.load();
        Scene scene = new Scene(root, 1360, 760);
        stage.setScene(scene);
        stage.show();
        //////////////////////////////////////////////////////
        //  DATA SHARING & CONTROLLER INITIALIZATION
        //////////////////////////////////////////////////////
        PageControllerUI controller = loader.getController();
//        controller.setStage_DontTouch(stage);
        AttributeContainer.getInstance().backlog.push("");
        AttributeContainer.getInstance().current_page = controller;
        controller.onLoad();



    }
}
