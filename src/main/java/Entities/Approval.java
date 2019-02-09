package Entities;

import java.sql.Date;

public class Approval {
    private ApprovalStatus page1;
    private ApprovalStatus page2;
    private ApprovalStatus page3;
    private ApprovalStatus page4;

    private boolean approved;
    private Date dateApproved;
    private String agentApprovalName;
    private Date expDate;
    private String qualifications;

    public Approval() {
    }

    public Approval(ApprovalStatus page1, ApprovalStatus page2, ApprovalStatus page3, ApprovalStatus page4, boolean approved, Date dateApproved, String agentApprovalName, Date expDate, String qualifications) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        this.page4 = page4;
        this.approved = approved;
        this.dateApproved = dateApproved;
        this.agentApprovalName = agentApprovalName;
        this.expDate = expDate;
        this.qualifications = qualifications;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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
}
