package upsa.mimo.delfin.mycocktail.Model.Interactors;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import upsa.mimo.delfin.mycocktail.Model.Interactors.BO.ErrorLog;
import upsa.mimo.delfin.mycocktail.Model.Interactors.BO.LoginBO;
import upsa.mimo.delfin.mycocktail.Model.Interactors.BO.UserBO;
import upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.LoginDAO;
import upsa.mimo.delfin.mycocktail.Model.Repositories.ILoginRepository;
import upsa.mimo.delfin.mycocktail.Model.Repositories.LoginRepository;

import static upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.ErrorComm.Status.NO_ERROR;

public class LoginInteractor implements ILoginInteractor {
    private ILoginRepository loginRepository;

    public LoginInteractor(){
        this.loginRepository = new LoginRepository();
    }

    @Override
    public LiveData<LoginBO> loginWithFacebook(String user, String password) {
        return Transformations.switchMap(loginRepository.facebookLogin(user,password),
                loginDAO ->{
                    MutableLiveData<LoginBO> result = new MutableLiveData<>();
                    UserBO userBO = null;
                    ErrorLog errorLog = null;

                    if(loginDAO != null){
                        if(loginDAO.errorComm.status == NO_ERROR){
                            userBO = new UserBO(user, loginDAO.userDAO.accessToken);
                            errorLog = new ErrorLog();
                        }
                    }

                    result.setValue(new LoginBO(userBO, errorLog));

                    return result;
                });
    }

    @Override
    public LiveData<LoginBO> signUp(String email, String password) {
        return null;
        //TODO: impelment firebase repository
    }
}
