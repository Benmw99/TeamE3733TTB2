package Entities;

import java.sql.Timestamp;
import java.util.Calendar;

public class Approval {

    private ApprovalStatus page1;
    private ApprovalStatus page2;
    private ApprovalStatus page3;
    private ApprovalStatus page4;

    private boolean approved;
    private Timestamp timestamp;
    private String agentApprovalName;
    private Timestamp expDate;
    private String qualifications;

    public Approval(boolean approved, Timestamp timestamp, String agentApprovalName, Timestamp expDate, String qualifications) {
        this.approved = approved;
        this.timestamp = timestamp;
        this.agentApprovalName = agentApprovalName;
        this.expDate = expDate;
        this.qualifications = qualifications;
        this.page1 = null;
        this.page2 = null;
        this.page3 = null;
        this.page4 = null;
    }

    public ApprovalStatus getPage4() {
        return page4;
    }

    public void setPage4(ApprovalStatus page4) {
        this.page4 = page4;
    }

    public Approval(ApprovalStatus page1, ApprovalStatus page2, ApprovalStatus page3, ApprovalStatus page4, boolean approved, Timestamp timestamp, String agentApprovalName, Timestamp expDate, String qualifications) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        this.page4 = page4;
        this.approved = approved;
        this.timestamp = timestamp;
        this.agentApprovalName = agentApprovalName;
        this.expDate = expDate;
        this.qualifications = qualifications;
    }

    public Approval() {
        this.approved = false;
        this.timestamp = null;
        this.agentApprovalName = null;
        this.expDate = null;
        this.qualifications = null;
        this.page1 = ApprovalStatus.Incomplete;
        this.page2 = ApprovalStatus.Incomplete;;
        this.page3 = ApprovalStatus.Incomplete;;
        this.page4 = ApprovalStatus.Incomplete;;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getAgentApprovalName() {
        return agentApprovalName;
    }

    public void setAgentApprovalName(String agentApprovalName) {
        this.agentApprovalName = agentApprovalName;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

//methods n the lot

    public void approve(String name, String qualifications){
        agentApprovalName = name;
        this.qualifications = qualifications;
        this.approved = true;
        Calendar Cal = Calendar.getInstance();

        java.util.Date now = Cal.getTime();
        Timestamp currTime = new Timestamp(now.getTime());
        this.timestamp = currTime;

        Cal.add(Calendar.YEAR, 2);
        java.util.Date expire = Cal.getTime();
        Timestamp expirationDate = new Timestamp(expire.getTime());
        this.expDate = expirationDate;

    }

    boolean equals(Approval appr){
        return ((this.approved == appr.approved) &&
            this.timestamp.equals(appr.timestamp) &&
            this.agentApprovalName.equals(appr.agentApprovalName) &&
            this.expDate.equals(appr.expDate) &&
            this.qualifications.equals(appr.qualifications) &&
            this.page1.equals(appr.page1) &&
            this.page1.equals(appr.page2) &&
            this.page1.equals(appr.page3));
    }


}

