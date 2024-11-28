package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {

    public enum BOType{
        PROGRAM, STUDENT, DASHBOARD, ADDPROGRAM, VIEWALL, ADDPAYMENT, SIGNUP, LOGIN, SETTING
    }

    public static SuperBO getBO(BOType boType){
        return switch (boType) {
            case PROGRAM -> new ProgramBOImpl();
            case STUDENT -> new StudentBOImpl();
            case DASHBOARD -> new DashboardBOImpl();
            case ADDPROGRAM -> new AddProgramBOImpl();
            case VIEWALL -> new ViewAllBOImpl();
            case ADDPAYMENT -> new AddPaymentBOImpl();
            case SIGNUP -> new SignUpBOImpl();
            case LOGIN -> new LoginBOImpl();
            case SETTING -> new SettingBOImpl();
            default -> null;
        };
    }
}
