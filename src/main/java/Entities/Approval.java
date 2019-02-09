package Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "APPROVAL")
public class Approval {
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

    @Id
    @Column(name = "TTB_ID")
    private int TTBID;

    public Approval() {
    }

    public Approval(ApprovalStatus page1, ApprovalStatus page2, ApprovalStatus page3, ApprovalStatus page4, Date dateApproved, String agentApprovalName, Date expDate, String qualifications, int TTBID) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        this.page4 = page4;
        this.dateApproved = dateApproved;
        this.agentApprovalName = agentApprovalName;
        this.expDate = expDate;
        this.qualifications = qualifications;
        this.TTBID = TTBID;
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

    public int getTTBID() {
        return TTBID;
    }

    public void setTTBID(int TTBID) {
        this.TTBID = TTBID;
    }
}