package upsa.mimo.delfin.mycocktail.Model.Repositories.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDAO {
    public ErrorComm errorComm;
    public UserDAO userDAO;

    public LoginDAO(UserDAO user, ErrorComm error){
        this.errorComm = error;
        this.userDAO = user;
    }
}
