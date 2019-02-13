package Entities;

import DB.Database;

import javax.persistence.*;
import java.io.InputStream;
import java.util.Objects;

@Entity
@Table(name = "LABEL")
public class LabelImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "TTB_ID")
    private int TTBID;

    @Column(name = "ImageName")
    private String imageName;

    @Lob
    @Column(name = "Image", columnDefinition = "BLOB")
    private byte[] image;

    public LabelImage() {
    }

    public LabelImage(int ID, int TTBID, String imageName, byte[] image) {
        this.ID = ID;
        this.TTBID = TTBID;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getTTBID() {
        return TTBID;
    }

    public void setTTBID(int TTBID) {
        this.TTBID = TTBID;
    }

    public boolean equals(LabelImage aLabel) {
        return (this.ID == aLabel.ID &&
                this.imageName.equals(aLabel.imageName) &&
                this.image.equals(aLabel.image));
    }

    /**
     * Puts the label image into the DB. Make sure the form is properly set up (everything except ID
     * @author Michael.
     */
    public void insert(){
        Database.getDatabase().dbInsert.insertLabelImage(this);
    }

}
