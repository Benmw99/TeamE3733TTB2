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

    @OneToOne()
    @JoinColumn(name = "TTB_ID")
    private Form form;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    public WineFormItems() {
    }

    public WineFormItems(int vintageYear, float pH, String grapeVarietal, String appellation, Form form) {
        this.vintageYear = vintageYear;
        this.pH = pH;
        this.grapeVarietal = grapeVarietal;
        this.appellation = appellation;
        this.form = form;
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

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
