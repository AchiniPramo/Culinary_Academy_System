package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

public interface AddPaymentBO extends SuperBO {

    void updateEnrollment(String studentId,String programName,double payment);
}
