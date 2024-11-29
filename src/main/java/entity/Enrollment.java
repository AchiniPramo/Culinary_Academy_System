package entity;

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
    @JoinColumn(name = "student_id",foreignKey = @ForeignKey(name = "FOREIGNKEY_STUDENT"))
    private Student student ;

    @ManyToOne
    @JoinColumn(name = "program_id",foreignKey = @ForeignKey(name ="FOREIGNKEY_progams" ))
    private CulinaryPrograms program;

    public Enrollment(double firstInstallment, double balance, Student student, CulinaryPrograms program) {
        this.firstInstallment = firstInstallment;
        this.balance = balance;
        this.student = student;
        this.program = program;
    }
}
