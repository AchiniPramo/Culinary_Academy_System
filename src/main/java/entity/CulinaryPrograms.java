package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CulinaryPrograms {
    @Id
    private String programId;
    private String programName;
    private int duration;
    private double fees;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "program" ,cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;
}
