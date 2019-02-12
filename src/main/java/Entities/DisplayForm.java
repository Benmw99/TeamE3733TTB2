package Entities;

public class DisplayForm extends com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject<Entities.DisplayForm> {

    String TTB_ID;
    String Submitted;
    String Approved;
    String Status;
    String Type;
    String Brand;
    String Serial;



    public DisplayForm(Form form){
        TTB_ID = String.valueOf(form.getTtbID());
        Submitted = form.getDateSubmitted().toString();
        Approved = form.getApproval().getDateApproved().toString();
        Status = form.getApprovalStatus().toString();
        Type = form.getAlcoholType().toString();
        Brand = form.getBrandName();
        Serial = form.getSerialNumber();
    }
}
