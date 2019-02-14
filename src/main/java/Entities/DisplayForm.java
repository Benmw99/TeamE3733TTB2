package Entities;

public class DisplayForm extends com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject<Entities.DisplayForm> {

    String TTB_ID;
    String Submitted;
    String Approved;
    String Status;
    String Type;
    String Brand;
    String Serial;


    public String getTTB_ID() {
        return TTB_ID;
    }

    public void setTTB_ID(String TTB_ID) {
        this.TTB_ID = TTB_ID;
    }

    public String getSubmitted() {
        return Submitted;
    }

    public void setSubmitted(String submitted) {
        Submitted = submitted;
    }

    public String getApproved() {
        return Approved;
    }

    public void setApproved(String approved) {
        Approved = approved;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public DisplayForm(Form form){
        TTB_ID = String.valueOf(form.getTtbID());
        if(form.getDateSubmitted() != null) {
            Submitted = form.getDateSubmitted().toString();
        }
        if(form.getApproval() != null) {
            try {
                Approved = form.getApproval().getDateApproved().toString();
            } catch (Exception e){
                //Gracefully recover from displaying a form without an approval...
            }
        }
        if(form.getApprovalStatus() != null) {
            Status = form.getApprovalStatus().toString();
        }
        if(form.getAlcoholType() != null) {
            Type = form.getAlcoholType().toString();
        }
        if(form.getBrandName() != null) {
            Brand = form.getBrandName();
        }
        if(form.getSerialNumber() != null) {
            Serial = form.getSerialNumber();
        }
    }
}
