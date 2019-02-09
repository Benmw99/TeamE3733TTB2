package Entities;

import javax.persistence.*;

@Entity
@Table(name = "WINE")
public class WineFormItems {
    @Column(name = "Vintage")
    private int vintageYear;

    @Column(name = "PH")
    private float pH;

    @Column(name = "Grape_Varietals")
    private String grapeVarietal;

    @Column(name = "Wine_Appellation")
    private String appellation;

    @Id
    @Column(name = "TTB_ID")
    private int id;

    public WineFormItems() {
    }

    public WineFormItems(int vintageYear, float pH, String grapeVarietal, String appellation, int id) {
        this.vintageYear = vintageYear;
        this.pH = pH;
        this.grapeVarietal = grapeVarietal;
        this.appellation = appellation;
        this.id = id;
    }

    public WineFormItems getWineFormItems() {
        return this;
    }

    public int getVintageYear() {
        return vintageYear;
    }

    public void setVintageYear(int vintageYear) {
        this.vintageYear = vintageYear;
    }

    public float getpH() {
        return pH;
    }

    public void setpH(float pH) {
        this.pH = pH;
    }

    public String getGrapeVarietal() {
        return grapeVarietal;
    }

    public void setGrapeVarietal(String grapeVarietal) {
        this.grapeVarietal = grapeVarietal;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
