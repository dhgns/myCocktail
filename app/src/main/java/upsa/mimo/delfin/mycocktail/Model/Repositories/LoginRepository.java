package upsa.mimo.delfin.mycocktail.Model.Repositories;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

import upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.ErrorComm;
import upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.LoginDAO;
import upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.UserDAO;
import upsa.mimo.delfin.mycocktail.Views.UI.MainActivity;

public class LoginRepository implements ILoginRepository{

    private String user;

    public LoginRepository(){}


    @Override
    public MutableLiveData<LoginDAO> facebookLogin(final String user, String password) {
        final MutableLiveData<LoginDAO> loginDAOMutableLiveData = new MutableLiveData<>();

        new FacebookCallback<LoginResult>() {
            LoginDAO loginDAO = null;
            ErrorComm errorComm = null;
            UserDAO userDAO = null;
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                userDAO = new UserDAO();

                userDAO.userName = user;
                userDAO.accessToken = loginResult.getAccessToken();

                errorComm = new ErrorComm(ErrorComm.Status.NO_ERROR, ErrorComm.Source.FACEBOOK, "Successful login");

                loginDAO = new LoginDAO(userDAO, errorComm);

                loginDAOMutableLiveData.setValue(loginDAO);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                errorComm = new ErrorComm(ErrorComm.Status.ERROR, ErrorComm.Source.FACEBOOK, "Error login");
                loginDAO = new LoginDAO(userDAO, errorComm);

                loginDAOMutableLiveData.setValue(loginDAO);
            }

        };

        return loginDAOMutableLiveData;
    }
}
