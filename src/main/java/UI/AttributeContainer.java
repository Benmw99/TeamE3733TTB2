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

    //Page approval checking
    public boolean page1Complete;
    public boolean page2Complete;
    public boolean page3Complete;
    public boolean page4Complete;
    public boolean page1Incomplete;
    public boolean page2Incomplete;
    public boolean page3Incomplete;
    public boolean page4Incomplete;
    public boolean page1Incorrect;
    public boolean page2Incorrect;
    public boolean page3Incorrect;
    public boolean page4Incorrect;
    //Checking because tab switching calls twice, used to determine proper tab
    public boolean isFirstTab;
    //Checks if FormDisplay is loaded in the reviewing tools or not
    public boolean isInReviewingTools;

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
        System.out.println("Gotta Blast!");
    }
}
