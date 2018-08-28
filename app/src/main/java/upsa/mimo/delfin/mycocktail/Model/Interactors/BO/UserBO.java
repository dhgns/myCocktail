package upsa.mimo.delfin.mycocktail.Model.Interactors.BO;

import com.facebook.AccessToken;

public class UserBO {

    public String userName;
    public AccessToken accessToken;

    public UserBO(String user, AccessToken accessToken) {
        this.userName = user;
        this.accessToken = accessToken;
    }
}
