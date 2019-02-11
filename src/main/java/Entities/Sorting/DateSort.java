package Entities.Sorting;

import Entities.Form;

import java.util.Comparator;

public class DateSort implements Comparator<Form> {
    public int compare(Form f1, Form f2){
        return f1.getApproval().getTimestamp().compareTo(f2.getApproval().getTimestamp());
    }

}
