package lk.ijse.dto;

import lk.ijse.entity.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String studentId;
    private String name;
    private String address;
    private Long tel;
    private Date registrationDate;
    private List<Enrollment> enrollments;
}
