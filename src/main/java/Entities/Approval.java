package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "APPROVAL")
public class Approval implements Serializable {
    @Enumerated
    @Column(name = "Page_1", columnDefinition = "smallint")
    private ApprovalStatus page1;

    @Enumerated
    @Column(name = "Page_2", columnDefinition = "smallint")
    private ApprovalStatus page2;

    @Enumerated
    @Column(name = "Page_3", columnDefinition = "smallint")
    private ApprovalStatus page3;

    @Enumerated
    @Column(name = "Page_4", columnDefinition = "smallint")
    private ApprovalStatus page4;

    @Column(name = "Date_Approved", columnDefinition = "DATE")
    private Date dateApproved;

    @Column(name = "Approving_Agent")
    private String agentApprovalName;

    @Column(name = "Expiration", columnDefinition = "DATE")
    private Date expDate;

    @Column(name = "Qualification")
    private String qualifications;

    @Column(name = "CT")
    private int CT;

    @Column(name = "Origin")
    private int origin;

    @OneToOne()
    @JoinColumn(name = "TTB_ID")
    private Form form;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    public Approval() {
        this.page1 = ApprovalStatus.Incomplete;
        this.page2 = ApprovalStatus.Incomplete;
        this.page3 = ApprovalStatus.Incomplete;
        this.page4 = ApprovalStatus.Incomplete;
        this.dateApproved = null;
        this.agentApprovalName = null;
        this.expDate = null;
        this.qualifications = null;
        this.CT = 0;
        this.origin = 0;
    }

    public Approval(ApprovalStatus page1, ApprovalStatus page2, ApprovalStatus page3, ApprovalStatus page4, Date dateApproved, String agentApprovalName, Date expDate, String qualifications, Form form) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        this.page4 = page4;
        this.dateApproved = dateApproved;
        this.agentApprovalName = agentApprovalName;
        this.expDate = expDate;
        this.qualifications = qualifications;
        this.form = form;
        this.CT = 0;
        this.origin = 0;
    }

    public Approval(ApprovalStatus page1, ApprovalStatus page2, ApprovalStatus page3, ApprovalStatus page4, Date dateApproved, String agentApprovalName, Date expDate, String qualifications, int CT, int OR, Form form) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        this.page4 = page4;
        this.dateApproved = dateApproved;
        this.agentApprovalName = agentApprovalName;
        this.expDate = expDate;
        this.qualifications = qualifications;
        this.CT = CT;
        this.origin = OR;
        this.form = form;
    }

    public ApprovalStatus getPage1() {
        return page1;
    }

    public void setPage1(ApprovalStatus page1) {
        this.page1 = page1;
    }

    public ApprovalStatus getPage2() {
        return page2;
    }

    public void setPage2(ApprovalStatus page2) {
        this.page2 = page2;
    }

    public ApprovalStatus getPage3() {
        return page3;
    }

    public void setPage3(ApprovalStatus page3) {
        this.page3 = page3;
    }

    public ApprovalStatus getPage4() {
        return page4;
    }

    public void setPage4(ApprovalStatus page4) {
        this.page4 = page4;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getAgentApprovalName() {
        return agentApprovalName;
    }

    public void setAgentApprovalName(String agentApprovalName) {
        this.agentApprovalName = agentApprovalName;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public int getCT() {
        return CT;
    }

    public void setCT(int CT) {
        this.CT = CT;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    //methods n the lot

    public void approve(String name, String qualifications){
        agentApprovalName = name;
        this.qualifications = qualifications;
        Calendar Cal = Calendar.getInstance();

        java.util.Date now = Cal.getTime();
        Date currTime = new Date(now.getTime());
        this.dateApproved = currTime;

        Cal.add(Calendar.YEAR, 2);
        java.util.Date expire = Cal.getTime();
        Date expirationDate = new Date(expire.getTime());
        this.expDate = expirationDate;

    }

    boolean equals(Approval appr){
        return ( this.dateApproved.equals(appr.dateApproved) &&
            this.agentApprovalName.equals(appr.agentApprovalName) &&
            this.expDate.equals(appr.expDate) &&
            this.qualifications.equals(appr.qualifications) &&
            this.page1.equals(appr.page1) &&
            this.page1.equals(appr.page2) &&
            this.page1.equals(appr.page3));
    }





    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

