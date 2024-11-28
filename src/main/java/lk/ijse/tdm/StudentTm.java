package lk.ijse.tdm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentTm {
    private String studentId;
    private String name;
    private String address;
    private Long tel;
    private Date registrationDate;
    private Button program;
}
