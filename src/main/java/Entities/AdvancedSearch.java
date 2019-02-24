package Entities;

import java.util.Date;

public class AdvancedSearch {
    //Gotta be a Boolean so it can be null
    public Boolean source;  //false for domestic, true for imported
    public String serialNumber;
    public AlcoholType alcoholType;
    public String brandName;
    public String fancifulName;
    //typeOfApplication
    public int ttbID;
    //Number of results to return
    public int numResults;

    public String stateCountry;
    //Might need to be sql dates
    public Date startDate;
    public Date endDate;

    //Wine stuff
    public int vintageYear;
    public float pH;
    public String grapeVarietal;
    public String appellation;
    //used for all liquor types
    public ApprovalStatus approvalStatus;

    public AdvancedSearch() {
        this.source = null;
        this.serialNumber = null;
        this.alcoholType = null;
        this.brandName = null;
        this.fancifulName = null;
        this.ttbID = 0;
        this.numResults = 0;
        this.vintageYear = 0;
        this.pH = (float)0;
        this.grapeVarietal = null;
        this.appellation = null;
        this.approvalStatus = ApprovalStatus.Complete;
        this.startDate = null;
        this.endDate = null;
        this.stateCountry = null;
    }
//getters and setters
    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
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

    public int getTtbID() {
        return ttbID;
    }

    public void setTtbID(int ttbID) {
        this.ttbID = ttbID;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public String getStateCountry() {
        return stateCountry;
    }

    public void setStateCountry(String stateCountry) {
        this.stateCountry = stateCountry;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * compare advanced search, check if they repeat or if they're equal
     * @param aSearch
     * @return
     */
    boolean equals(AdvancedSearch aSearch){
        return(
            this.serialNumber.equals(aSearch.serialNumber) &&
            this.alcoholType.equals(aSearch.alcoholType) &&
            this.brandName.equals(aSearch.brandName) &&
            this.fancifulName.equals(aSearch.fancifulName) &&
            this.vintageYear == aSearch.vintageYear &&
            this.pH == aSearch.pH &&
            this.grapeVarietal.equals(aSearch.grapeVarietal) &&
            this.appellation.equals(aSearch.appellation)&&
            this.ttbID == aSearch.ttbID &&
            this.numResults == aSearch.numResults);
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
