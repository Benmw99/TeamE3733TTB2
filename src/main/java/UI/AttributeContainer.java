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

    private AttributeContainer() {
        formQueue = new ArrayList<Form>();
        currentForm = null;
        currentUser = null;
        currentResults = null;
        sounds = new ArrayList<AudioClip>();
        searchPage = 0;
        backlog = new Stack<String>();
    }

    public void wipeSession() {
        formQueue = null;
        currentForm = null;
        currentUser = null;
        currentResults = null;
        sounds = null;
        searchPage = 0;
        backlog.empty();
    }
}
