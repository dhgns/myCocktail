package upsa.mimo.delfin.mycocktail.Model.Services;

import upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.LoginDAO;

public interface FacebookLogin {

    public LoginDAO loginWithFacebook(String user, String password);
}
