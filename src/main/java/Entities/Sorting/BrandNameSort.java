package Entities.Sorting;

import Entities.Form;

import java.util.Comparator;

public class BrandNameSort implements Comparator<Form> {
    public int compare(Form f1, Form f2){
        return f1.getBrandName().compareTo(f2.getBrandName());
    }

}
