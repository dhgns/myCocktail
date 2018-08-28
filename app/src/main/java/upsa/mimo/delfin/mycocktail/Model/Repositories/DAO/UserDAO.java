package upsa.mimo.delfin.mycocktail.Model.Repositories.DAO;

import com.facebook.AccessToken;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {

    public String userName;
    public AccessToken accessToken;

}
