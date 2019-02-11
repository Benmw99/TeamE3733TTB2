package Entities;

import java.io.InputStream;

public class LabelImage {
    private int ID;
    private String imageName;
    private InputStream image;

    public LabelImage(int ID, String imageName, InputStream image) {
        this.ID = ID;
        this.imageName = imageName;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }


    public boolean equals(LabelImage aLabel) {
        return (this.ID == aLabel.ID &&
                this.imageName.equals(aLabel.imageName) &&
                this.image.equals(aLabel.image));
    }

}
