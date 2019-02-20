package UI;

import Entities.Form;
import Entities.IUser;
import Entities.LabelImage;
import Entities.SearchResult;

import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AttributeContainer {
    private static AttributeContainer ourInstance = new AttributeContainer();
    public List<BufferedImage> imageList;
    public File labelImageFile;

    public static AttributeContainer getInstance() {
        return ourInstance;
    }

    public List<Form> formQueue;
    public Form currentForm;
    public IUser currentUser;
    public SearchResult currentResults;
    public List<AudioClip> sounds;
    public int searchPage;
    public Stack<String> backlog;
    public int numForQueue = 5;
    PageControllerUI current_page;
    LabelImage labelImage;
    char delimeter;

    /**
     * Instantiates new empty AttributeContainer
     */
    private AttributeContainer() {
        formQueue = new ArrayList<Form>();
        currentForm = null;
        currentUser = null;
        currentResults = new SearchResult();
        sounds = new ArrayList<AudioClip>();
        searchPage = 0;
        backlog = new Stack<String>();
        delimeter = ',';
    }

    /**
     * Clears all stored data from AttributeContainer
     */
    public void wipeSession() {
        formQueue = new ArrayList<Form>();
        currentForm = null;
        currentUser = null;
        currentResults = new SearchResult();
        sounds = new ArrayList<AudioClip>();
        searchPage = 0;
        backlog.empty();
        delimeter = ',';
        System.out.println("Gotta Blast!");
    }
}
