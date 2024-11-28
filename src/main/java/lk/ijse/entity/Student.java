package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String studentId;
    private String name;
    private String address;
    private Long tel;
    private Date registrationDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments;
}
