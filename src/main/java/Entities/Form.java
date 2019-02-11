package Entities;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Form {


    //#######################################################################################################
    //                                  Instance Vars

    private String repID;
    private ArrayList<String> brewersPermit;
    private boolean source;  //false for domestic, true for imported
    private String serialNumber;
    private AlcoholType alcoholType;
    public String brandName;
    private String fancifulName;
    private ArrayList<Address> address;
    private Address mailingAddress;
    private String applicantName;
    private String formula;
    private WineFormItems wineFormItems;
    private String phoneNumber;
    private String email;
    //typeOfApplication
    private String blownBrandedEmbossedInfo;
    private Timestamp dateSubmitted;
    private int ttbID;
    private int companyID;
    private Approval approval;
    private float alcoholContent;
    private ApprovalStatus approvalStatus = ApprovalStatus.Incomplete; //in percent

    //#######################################################################################################
    //                                  constructors

    public Form(){
        this.repID = null;
        this.brewersPermit = new ArrayList<String>();
        this.source = true;
        this.serialNumber = null;
        this.alcoholType = null;
        this.brandName = null;
        this.fancifulName = null;
        this.address = new ArrayList<Address>();
        this.mailingAddress = null;
        this.applicantName = null;
        this.formula = null;
        this.wineFormItems = null;
        this.phoneNumber = null;
        this.email = null;
        this.blownBrandedEmbossedInfo = null;
        this.dateSubmitted = null;
        this.ttbID = 0;
        this.companyID = 0;
        this.approval = null;
        this.alcoholContent = 0;
    }

    //minimal application constructor
    public Form(AlcoholType alcoholType, String brandName, float alcoholContent){
        this.repID = null;
        this.brewersPermit = null;
        this.source = true;
        this.serialNumber = null;
        this.alcoholType = alcoholType;
        this.brandName = brandName;
        this.fancifulName = null;
        this.address = null;
        this.mailingAddress = null;
        this.applicantName = null;
        this.formula = null;
        this.wineFormItems = null;
        this.phoneNumber = null;
        this.email = null;
        this.blownBrandedEmbossedInfo = null;
        this.dateSubmitted = null;
        this.ttbID = 0;
        this.companyID = 0;
        this.approval = null;
        this.alcoholContent = alcoholContent;
    }

    public Form(String repID, ArrayList<String> brewersPermit, boolean source, String serialNumber, AlcoholType alcoholType, String brandName, String fancifulName, ArrayList<Address> address, Address mailingAddress, String applicantName, String formula, WineFormItems wineFormItems, String phoneNumber, String email, String blownBrandedEmbossedInfo, Timestamp dateSubmitted, int ttbID, int companyID, Approval approval, float alcoholContent) {
        this.repID = repID;
        this.brewersPermit = brewersPermit;
        this.source = source;
        this.serialNumber = serialNumber;
        this.alcoholType = alcoholType;
        this.brandName = brandName;
        this.fancifulName = fancifulName;
        this.address = address;
        this.mailingAddress = mailingAddress;
        this.applicantName = applicantName;
        this.formula = formula;
        this.wineFormItems = wineFormItems;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.blownBrandedEmbossedInfo = blownBrandedEmbossedInfo;
        this.dateSubmitted = dateSubmitted;
        this.ttbID = ttbID;
        this.companyID = companyID;
        this.approval = approval;
        this.alcoholContent = alcoholContent;
    }

    //#######################################################################################################
    //                                  getters and setters

    public String getRepID() {
        return repID;
    }

    public void setRepID(String repID) {
        this.repID = repID;
    }

    public ArrayList<String> getBrewersPermit() {
        return brewersPermit;
    }

    public void setBrewersPermit(ArrayList<String> brewersPermit) {
        this.brewersPermit = brewersPermit;
    }

    public boolean isSource() {
        return source;
    }

    public void setSource(boolean source) {
        this.source = source;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public AlcoholType getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(AlcoholType alcoholType) {
        this.alcoholType = alcoholType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFancifulName() {
        return fancifulName;
    }

    public void setFancifulName(String fancifulName) {
        this.fancifulName = fancifulName;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public WineFormItems getWineFormItems() {
        return wineFormItems;
    }

    public void setWineFormItems(WineFormItems wineFormItems) {
        this.wineFormItems = wineFormItems;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlownBrandedEmbossedInfo() {
        return blownBrandedEmbossedInfo;
    }

    public void setBlownBrandedEmbossedInfo(String blownBrandedEmbossedInfo) {
        this.blownBrandedEmbossedInfo = blownBrandedEmbossedInfo;
    }

    public void setBlown(String blown){
        this.blownBrandedEmbossedInfo = blown;
    }

    public Timestamp getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Timestamp dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public int getTtbID() {
        return ttbID;
    }

    public void setTtbID(int ttbID) {
        this.ttbID = ttbID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) { this.approval = approval; }

    public boolean getSource(){ return this.source;}

    public void setSource(Boolean source) { this.source = source;}

    public float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) { this.alcoholContent = alcoholContent; }

    public void setApprovalStatus(ApprovalStatus approvalStatus){ this.approvalStatus = approvalStatus;}

    public ApprovalStatus getApprovalStatus(){ return this.approvalStatus;}
    //#######################################################################################################
    //                                  UI API (to be implemented)
    public void approve(String agentName){//TODO: Implement
    }
    public void reject(String agentName){ //TODO: Implement
    }
    //#######################################################################################################
    //                                  Helper Functions

    boolean equals(Form aform){
        return (this.repID.equals(aform.repID) &&
                brewListEquals(aform.brewersPermit) &&
                this.source == aform.source &&
                this.serialNumber.equals(aform.serialNumber) &&
                this.alcoholType.equals(aform.alcoholType) &&
                this.brandName.equals(aform.brandName) &&
                this.fancifulName.equals(aform.fancifulName) &&
                addressListEquals(aform.address) &&
                this.mailingAddress.equals(aform.mailingAddress) &&
                this.applicantName.equals(aform.applicantName) &&
                this.formula.equals(aform.formula) &&
                this.wineFormItems.equals(aform.wineFormItems) &&
                this.phoneNumber.equals(aform.phoneNumber) &&
                this.email.equals(aform.email) &&
                this.blownBrandedEmbossedInfo.equals(aform.blownBrandedEmbossedInfo) &&
                this.dateSubmitted.equals(aform.dateSubmitted) &&
                this.ttbID == aform.ttbID &&
                this.companyID == aform.companyID &&
                this.approval.equals(aform.approval) &&
                this.alcoholContent == aform.alcoholContent);
    }

    boolean brewListEquals(ArrayList<String> aList) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (String s: aList) {
            for (String t: this.brewersPermit) {
                if (s.equals(t)) {
                    resultList.add(s);
                }
            }
        }
        return(this.brewersPermit.size() == resultList.size());
    }

    boolean addressListEquals(ArrayList<Address> aList) {
        ArrayList<Address> resultList = new ArrayList<Address>();
        for (Address a: aList) {
            for (Address s: this.address) {
                if (a.equals(s)) {
                    resultList.add(a);
                }
            }
        }
        return(this.brewersPermit.size() == resultList.size());
    }

}
