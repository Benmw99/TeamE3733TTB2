package Entities;

public enum ApprovalStatus {
    Complete, Incomplete, Incorrect;

    public static ApprovalStatus fromInt(int from){
        if( from == 1){
            return Complete;
        } else if (from == 2){
            return Incomplete;
        } else if (from == 3){
            return Incorrect;
        }
        return Incomplete;
    }

    public int toInt(){
        if(this == Complete){
            return 1;
        } else if (this == Incomplete){
            return 2;
        } else {
            return 3;
        }
    }
}
//1, 2, 3 will be the statuses for approval types
//Ann approval will exist if ApprovalStatus = 1,3 but not 2;