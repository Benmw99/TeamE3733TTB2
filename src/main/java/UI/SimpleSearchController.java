package UI;

import DB.Database;
import Entities.*;
import SearchAlgo.SearchContainer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SimpleSearchController extends PageControllerUI implements Initializable {

    @FXML
    JFXButton searchButton;

    @FXML
    JFXButton randomDrink;

    @FXML
    JFXTextField searchBy;

    @FXML
    JFXButton goBack;

    @FXML
    JFXButton goAdvSearch;

    @FXML
    StackPane UsernameStackPane;

    @FXML
    JFXButton UsernameButton;

    @FXML
    Text title;

    @FXML
    Text descriptor;

    @Override
    protected void onLeave() {
    }

    @Override
    void onLoad() {
        /*
        searchButton.setFont(new Font("Roboto Light", 18));
        randomDrink.setFont(new Font("Roboto Light", 18));
        searchBy.setFont(new Font("Roboto Light", 24));
        goAdvSearch.setFont(new Font("Roboto Light", 18));
        title.setFont(new Font("Roboto Light", 48));
        descriptor.setFont(new Font("Roboto Light", 24));
        UsernameButton.setFont(new Font("Roboto Light", 18));
        */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (attributeContainer.currentUser != null) {
//            System.out.println("This is true");
            UsernameStackPane.setOpacity(1);
            UsernameButton.setText(attributeContainer.currentUser.getLogin());
        } else {
            UsernameStackPane.toBack();
        }
    }

    public void pourMeADrink(ActionEvent event) {
        AttributeContainer.getInstance().currentForm = Database.getDatabase().dbSelect.randomForm();
        goToPage("ViewSelectedForm.fxml");

    }

    public void search(ActionEvent event) {
        if (searchBy.getText() != null && !searchBy.getText().trim().isEmpty()) {
            AttributeContainer.getInstance().query = searchBy.getText().trim();
            SearchContainer.getInstance().searchResult = new SearchResult();
            List<Form> forms = Database.getDatabase().dbSelect.simpleSearch(searchBy.getText().trim());
            SearchContainer.getInstance().searchResult.setResults(forms);
            SearchContainer.getInstance().query = searchBy.getText().trim();
            SearchContainer.getInstance().setPages();
            SearchContainer.getInstance().currentPage = 1;
            if (SearchContainer.getInstance().searchResult.getResults().size() != 0) {
                SearchContainer.getInstance().loadQueue();
            }
            goToPage("HomeSearch.fxml");
        }
    }


    public void advancedSearch(ActionEvent actionEvent) {
        AttributeContainer.getInstance().query = "";
        goToPage("HomeSearch.fxml");
    }

    public void login(ActionEvent actionEvent) {
        attributeContainer.currentUser = null;
        SearchContainer.getInstance().searchResult = new SearchResult();
        SearchContainer.getInstance().currentPage = 1;
        AttributeContainer.getInstance().formQueue = new ArrayList<Form>();
        AttributeContainer.getInstance().currentResults = new SearchResult();
        AttributeContainer.getInstance().query = "";
        goToPage("Login.fxml");
    }

    @FXML
    public void toProfile() {
        goToPage("Profile.fxml");
    }


    @FXML
    void uploadLabelImage() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG Files", "*.png")
                , new FileChooser.ExtensionFilter("JPEG Files", "*.jpg")
        );

        try {
            fileChooser.setTitle("Select label image");
            File selectedFile = fileChooser.showOpenDialog(PageSwitcher.stage);
            System.out.println(selectedFile);
            LabelImage labelImage = new LabelImage();
            InputStream is = new FileInputStream(selectedFile);
            labelImage.setImage(IOUtils.toByteArray(is));
            labelImage.setImageName(selectedFile.getName());
            attributeContainer.labelImage = labelImage;
            attributeContainer.labelImageFile = selectedFile;
            Form reverseImage = new Form();
            reverseImage.setLogoText("");
            GoogleVision gv = new GoogleVision();
            try {
                gv.detectLogoText(selectedFile.getAbsolutePath(), reverseImage, true);
            } catch (Exception e){
                e.printStackTrace();
            }
                AdvancedSearch as = new AdvancedSearch();
            as.setLogoText(reverseImage.getLogoText());
            Database db = Database.getDatabase();
            SearchContainer.getInstance().searchResult = new SearchResult();
            SearchContainer.getInstance().searchResult.setResults(db.dbSelect.searchBy(as).getResults());
            SearchContainer.getInstance().searchResult.setSearch(as);
    //        SearchContainer.getInstance().searchResult.setQuery(as.getBrandName());
            SearchContainer.getInstance().setPages();
            SearchContainer.getInstance().currentPage = 1;
            if(SearchContainer.getInstance().searchResult.getResults().size() != 0) {
                SearchContainer.getInstance().loadQueue();
            }
            goToPage("HomeSearch.fxml");
    //        AttributeContainer.getInstance().backlog.pop();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}