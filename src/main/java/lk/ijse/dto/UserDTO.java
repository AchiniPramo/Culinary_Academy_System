package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String password;
    private String role;

    public UserDTO(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
