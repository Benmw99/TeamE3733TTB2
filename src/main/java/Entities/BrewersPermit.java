package Entities;

import javax.persistence.*;

@Entity
@Table(name = "BREWERSPERMIT")
public class BrewersPermit {
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
    @JoinColumn(name = "TTB_ID", insertable = false, updatable = false, nullable = false)
    private Form form;

    public BrewersPermit() {
    }

    public BrewersPermit(String brewersNo, boolean isPrimary, int ttbid, Form form) {
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
}
