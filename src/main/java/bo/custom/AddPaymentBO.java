package bo.custom;


import bo.SuperBO;

public interface AddPaymentBO extends SuperBO {

    void updateEnrollment(String studentId,String programName,double payment);
}
