package Entities;

import java.io.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;

@Entity
@Table(name = "FORM")
public class Form implements Serializable {
    @Column(name = "Rep_ID")
    private String repID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TTB_ID")
    public List<BrewersPermit> brewersPermit;

    @Column(name = "Source")
    private boolean source;  //false for domestic, true for imported

    @Column(name = "Serial_Number")
    private String serialNumber;

    @Enumerated
    @Column(name = "Alcohol_Type", columnDefinition = "smallint")
    private AlcoholType alcoholType;

    @Column(name = "Brand_Name")
    private String brandName;

    @Column(name = "Fanciful_Name")
    private String fancifulName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TTB_ID")
    public List<Address> address;

    @Transient
    private Address mailingAddress;

    @Column(name = "Applicant_Name")
    private String applicantName;

    @Column(name = "Formula")
    private String formula;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TTB_ID", nullable = false)
    private WineFormItems wineFormItems;

    @Column(name = "Phone")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    //typeOfApplication

    @Column(name = "Other_Info")
    private String otherInfo;

    @Column(name = "Date_Submitted", columnDefinition = "DATE")
    private Date dateSubmitted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TTB_ID")
    private int ttbID;

    @Column(name = "Company_ID")
    private int companyID;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TTB_ID", nullable = false)
    private Approval approval;

    @Column(name = "APV")
    private float alcoholContent;

    @Enumerated
    @Column(name = "Approve", columnDefinition = "smallint")
    private ApprovalStatus approvalStatus;

    @Column(name = "WorkingOn")
    private int workingOn;

    @Column(name = "logoText")
    private String logoText;

    @Column(name = "labelText")
    private String labelText;

    public Form() {
    }

    public Form(String repID, List<BrewersPermit> brewersPermit, boolean source, String serialNumber, AlcoholType alcoholType, String brandName, String fancifulName, List<Address> address, Address mailingAddress, String applicantName, String formula, WineFormItems wineFormItems, String phoneNumber, String email, String otherInfo, Date dateSubmitted, int companyID, Approval approval, float alcoholContent, ApprovalStatus approvalStatus, int workingOn, String logoText, String labelText) {
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
        this.otherInfo = otherInfo;
        this.dateSubmitted = dateSubmitted;
        this.companyID = companyID;
        this.approval = approval;
        this.alcoholContent = alcoholContent;
        this.approvalStatus = approvalStatus;
        this.workingOn = workingOn;
        this.logoText = logoText;
        this.labelText = labelText;
    }

    public Form(String repID, List<BrewersPermit> brewersPermit, boolean source, String serialNumber, AlcoholType alcoholType, String brandName, String fancifulName, ArrayList<Address> address, Address mailingAddress, String applicantName, String formula, WineFormItems wineFormItems, String phoneNumber, String email, String otherInfo, Date dateSubmitted, int ttbID, int companyID, Approval approval, float alcoholContent, ApprovalStatus approvalStatus) {
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
        this.otherInfo = otherInfo;
        this.dateSubmitted = dateSubmitted;
        this.ttbID = ttbID;
        this.companyID = companyID;
        this.approval = approval;
        this.alcoholContent = alcoholContent;
        this.approvalStatus = approvalStatus;
    }

    public Form(String repID, List<BrewersPermit> brewersPermit, boolean source, String serialNumber, AlcoholType alcoholType, String brandName, String fancifulName, List<Address> address, String applicantName, String formula, WineFormItems wineFormItems, String phoneNumber, String email, String otherInfo, Date dateSubmitted, int companyID, Approval approval, float alcoholContent, ApprovalStatus approvalStatus) {
        this.repID = repID;
        this.brewersPermit = brewersPermit;
        this.source = source;
        this.serialNumber = serialNumber;
        this.alcoholType = alcoholType;
        this.brandName = brandName;
        this.fancifulName = fancifulName;
        this.address = address;
        this.applicantName = applicantName;
        this.formula = formula;
        this.wineFormItems = wineFormItems;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.otherInfo = otherInfo;
        this.dateSubmitted = dateSubmitted;
        this.companyID = companyID;
        this.approval = approval;
        this.alcoholContent = alcoholContent;
        this.approvalStatus = approvalStatus;
    }

    //Constructor for initial form submission that isn't approved.
    public Form(String repID, List<BrewersPermit> brewersPermit, boolean source, String serialNumber, AlcoholType alcoholType, String brandName, String fancifulName, List<Address> address, Address mailingAddress, String applicantName, String formula, WineFormItems wineFormItems, String phoneNumber, String email, String otherInfo, Date dateSubmitted, int companyID, float alcoholContent) {
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
        this.otherInfo = otherInfo;
        this.dateSubmitted = dateSubmitted;
        this.companyID = companyID;
        this.alcoholContent = alcoholContent;
        this.approvalStatus = ApprovalStatus.Incomplete;
        this.approval = new Approval();
        this.workingOn = 0;
    }

    //Constructor specifically for hibernate to create smaller forms for search results
    public Form(int ttbID, String serialNumber, AlcoholType alcoholType, String brandName, java.util.Date dateSubmitted, ApprovalStatus approvalStatus) {
        if (serialNumber != null) {
            this.serialNumber = serialNumber;
        } else {
            this.serialNumber = "";
        }
        this.alcoholType = alcoholType;
        this.brandName = brandName;
        if (dateSubmitted != null) {
            this.dateSubmitted = new java.sql.Date(dateSubmitted.getTime());
        } else {
            this.dateSubmitted = null;
        }
        this.approvalStatus = approvalStatus;
        this.ttbID = ttbID;
    }

    public Form(int ttbID, String serialNumber, AlcoholType alcoholType, String brandName, ApprovalStatus approvalStatus) {
        this.serialNumber = serialNumber;
        this.alcoholType = alcoholType;
        this.brandName = brandName;
        this.approvalStatus = approvalStatus;
        this.ttbID = ttbID;
    }

    public Form(String brandName) {
        this.brandName = brandName;
    }

    public String getRepID() {
        return repID;
    }

    public void setRepID(String repID) {
        this.repID = repID;
    }

    public List<BrewersPermit> getBrewersPermit() {
        return brewersPermit;
    }

    public void setBrewersPermit(ArrayList<BrewersPermit> brewersPermit) {
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

    public List<Address> getAddress() {
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

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public String getLogoText() {
        return logoText;
    }

    public void setLogoText(String logoText) {
        this.logoText = logoText;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public void setDateSubmitted(Date dateSubmitted) {
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

    public void setAlcoholContent(float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }
    public boolean getSource(){ return this.source;}

    public void setSource(Boolean source) { this.source = source;}

    public float getAlcoholContent() {
        return alcoholContent;
    }


    public void setBrewersPermit(List<BrewersPermit> brewersPermit) {
        this.brewersPermit = brewersPermit;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public int getWorkingOn() {
        return workingOn;
    }

    public void setWorkingOn(int workingOn) {
        this.workingOn = workingOn;
    }




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
                this.otherInfo.equals(aform.otherInfo) &&
                this.dateSubmitted.equals(aform.dateSubmitted) &&
                this.ttbID == aform.ttbID &&
                this.companyID == aform.companyID &&
                this.approval.equals(aform.approval) &&
                this.alcoholContent == aform.alcoholContent);
    }

    boolean brewListEquals(List<BrewersPermit> aList) {
        List<BrewersPermit> resultList = new ArrayList<BrewersPermit>();
        for (BrewersPermit s: aList) {
            for (BrewersPermit t: this.brewersPermit) {
                if (s.equals(t)) {
                    resultList.add(s);
                }
            }
        }
        return(this.brewersPermit.size() == resultList.size());
    }

    boolean addressListEquals(List<Address> aList) {
        List<Address> resultList = new ArrayList<Address>();
        for (Address a: aList) {
            for (Address s: this.address) {
                if (a.equals(s)) {
                    resultList.add(a);
                }
            }
        }
        return(this.brewersPermit.size() == resultList.size());
    }

    /////////////////////////////////////////////////////////////////////////////
    //                    Serialization Code (write to file)                   //
    /////////////////////////////////////////////////////////////////////////////
    boolean serialize(String filename)  {
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(this);
            out.close();
            file.close();
            System.out.println("form has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            return false;
        }
        return true;
    }

    /** Reads a form serial file and returns the object
     *
     * @param filename
     * @return the form
     */
    static Form deserialize(String filename){
        Form form = null;

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            form = (Form)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
//            System.out.println("BrandName = " + object1.getBrandName());
//            System.out.println("fancyName = " + object1.getFancifulName());
//            System.out.println("Approval = " + object1.getApprovalStatus());
//            System.out.println("Email = " + object1.getEmail());
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return form;
    }

    /**
     * Verifies that the passed in text occurs somewhere in the label text. Works only if both are set.
     * @return true for a match, false otherwise.
     */
    public boolean verifyText(String s){
        String label = this.getLabelText().toUpperCase();
        String[] arr = s.split(" ");
        boolean bool = true;
        for ( String ss : arr) {
            if(!label.contains(ss)){
                bool = false;
            }
        }
        return bool;
    }

    /**
     * Checks to see if there is some sort of indicator as to the type of alcohol on the label. Throws an exception if there is none
     * otherwise returns an alcohol type representing the indicated type.
     * @return Alcohol Type representing the type of alcohol.
     * @throws Exception if there is no indicator. Should be handled.
     */
    public AlcoholType detectAlcType() throws Exception{
        String s = this.getLabelText().toUpperCase();
        AlcoholType alc;
        if(s.contains("BEER") || s.contains("MALT") || s.contains("STOUT") || s.contains("LAGER") || s.contains("ALE") || s.contains("BREW") ||s.contains("COLD ONE")){
            alc = AlcoholType.MaltBeverage;
        } else if(s.contains("WINE") || s.contains("BUBBLY")){
            alc = AlcoholType.Wine;
        } else if(s.contains("WHISKEY") || s.contains("VODKA") || s.contains("RUM") || s.contains("GIN") || s.contains("TEQUILA") || s.contains("BRANDY") || s.contains("SCHNAPPS")){
            alc = AlcoholType.DistilledLiquor;
        } else {
            throw new Exception("No Alcohol Type Indicator found on label.");
        }
        return alc;
    }

    /**
     *
     * @return true if there is text on the label matching the appelation, or there is no appellation. Else, false.
     */
    public boolean verifyAppellation(){
        if(this.getWineFormItems() != null && this.getWineFormItems().getAppellation() != null){
            return this.verifyText(this.getWineFormItems().getAppellation());
        } else {
            return true;
        }
    }

    /**
     * Verifies that the brand name occurs somewhere in the label text.
     * @return True for the text being there. False otherwise.
     */
    public boolean verifyBrandName(){
        return verifyText(this.getBrandName());
    }

    /**
     * This finds the alcohol content (the first percent on the label, lmao) and tosses it directly into the alcohol
     * content field of the bottle
     */
    public void getAlcContent(){
        try {
            Pattern p = Pattern.compile("\\d*\\.?\\d*%");
            Matcher m = p.matcher(this.getLabelText());
            System.out.print("ALCOHOL CONTENT FOUND:");
            m.find();
            int i = m.start();
            int j = m.end() - 1;
            Float content = Float.parseFloat(this.getLabelText().substring(i, j));
            this.alcoholContent = content;
        } catch (Exception e){
            this.alcoholContent = 0;
        }

    }
}
