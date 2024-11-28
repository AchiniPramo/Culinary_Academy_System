package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollId;
    private double firstInstallment;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "FK_STUDENT"))
    private Student student;

    @ManyToOne
    @JoinColumn(name = "program_id", foreignKey = @ForeignKey(name = "FK_PROGRAM"))
    private CulinaryProgram program;

    public Enrollment(double firstInstallment, double balance, Student student, CulinaryProgram program) {
        this.firstInstallment = firstInstallment;
        this.balance = balance;
        this.student = student;
        this.program = program;
    }
}
