package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userId ;

    @Column(nullable = false, unique = true)
    private String userName ;
    private String Password ;

    private String role;

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.Password = password;
        this.role = role;
    }
}
