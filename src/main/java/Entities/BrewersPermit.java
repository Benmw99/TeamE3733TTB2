package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BREWERSPERMIT")
public class BrewersPermit implements Serializable {
    @Column(name = "Brewers_No")
    private String brewersNo;

    @Column(name = "isPrimary")
    private boolean isPrimary;

    //@Column(name = "TTB_ID")
    //private int ttbid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "TTB_ID", nullable=false, insertable =  false, updatable = false)
    private Form form;

    public BrewersPermit() {
    }

    public BrewersPermit(String brewersNo, boolean isPrimary) {
        this.brewersNo = brewersNo;
        this.isPrimary = isPrimary;
    }

    public BrewersPermit(String brewersNo, boolean isPrimary, Form form) {
        this.brewersNo = brewersNo;
        this.isPrimary = isPrimary;
        //this.ttbid = ttbid;
        this.form = form;
    }

    public String getBrewersNo() {
        return brewersNo;
    }

    public void setBrewersNo(String brewersNo) {
        this.brewersNo = brewersNo;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
    //TODO: TODOs and github issues are dead nothing i write here matters

    //public int getTtbid() {
    //    return ttbid;
    //}

    //public void setTtbid(int ttbid) {
    //    this.ttbid = ttbid;
    //}

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

    /**
     * The equality function for Brewers Permits
     * @param to_check the one to compare to
     * @return the obvious, true for equality
     */
    boolean equals(BrewersPermit to_check){
        boolean equality = this.brewersNo.equals(to_check.brewersNo) &&
                ((this.isPrimary && to_check.isPrimary) || (this.isPrimary && to_check.isPrimary));
        return equality;
    }

}
