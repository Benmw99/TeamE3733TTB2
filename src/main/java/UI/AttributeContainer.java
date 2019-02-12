package UI;

import Entities.Form;
import Entities.IUser;
import Entities.SearchResult;

import java.applet.AudioClip;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AttributeContainer {
    private static AttributeContainer ourInstance = new AttributeContainer();

    public static AttributeContainer getInstance() {
        return ourInstance;
    }

    List<Form> formQueue;
    Form currentForm;
    IUser currentUser;
    SearchResult currentResults;
    List<AudioClip> sounds;
    int searchPage;
    Stack<String> backlog;

    private AttributeContainer() {
        formQueue = null;
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
