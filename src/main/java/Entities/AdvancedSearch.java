package Entities;

public class AdvancedSearch {
    //Gotta be a Boolean so it can be null
    public Boolean source;  //true for domestic, false for imported
    public String serialNumber;
    public AlcoholType alcoholType;
    public String brandName;
    public String fancifulName;
    //typeOfApplication
    public int ttbID;
    //Number of results to return
    public int numResults;

    //Wine stuff
    public int vintageYear;
    public float pH;
    public String grapeVarietal;
    public String appellation;

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
    }

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
