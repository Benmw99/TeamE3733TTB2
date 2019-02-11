package Entities;

import java.sql.Timestamp;

public class AdvancedSearch {
    //Gotta be a Boolean so it can be null
    public Boolean source;  //true for domestic, false for imported
    public String serialNumber;
    public AlcoholType alcoholType;
    public String brandName;
    public String fancifulName;
    //wine only
    public int vintageYear;
    public float pH;
    public String grapeVarietal;
    public String appellation;
    //typeOfApplication
    public Timestamp timestamp;
    public int ttbID;
    //Number of results to return
    public int numResults;
    //Alcohol type but numeric for the DB
    public int type;

    public AdvancedSearch() {
        this.source = null;
        this.serialNumber = null;
        this.alcoholType = null;
        this.brandName = null;
        this.fancifulName = null;
        this.vintageYear = 0;
        this.pH = 0;
        this.grapeVarietal = null;
        this.appellation = null;
        this.timestamp = null;
        this.ttbID = 0;
        this.numResults = 0;
    }

    public Boolean isSource() {
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
        this.type = alcoholType.toInt();
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
            this.timestamp.equals(aSearch.timestamp) &&
            this.ttbID == aSearch.ttbID &&
            this.numResults == aSearch.numResults);
    }

}
