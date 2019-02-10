package Entities;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "FORM")
public class Form {
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
    @JoinColumn(name = "TTB_ID")
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
    @JoinColumn(name = "TTB_ID")
    private Approval approval;

    @Column(name = "APV")
    private float alcoholContent;

    @Enumerated
    @Column(name = "Approve", columnDefinition = "smallint")
    private ApprovalStatus approvalStatus;

    public Form() {
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

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public float getAlcoholContent() {
        return alcoholContent;
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
}
