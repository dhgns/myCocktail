package upsa.mimo.delfin.mycocktail.Model.Repositories;

import android.arch.lifecycle.MutableLiveData;

import upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.LoginDAO;

public interface ILoginRepository {

    public MutableLiveData<LoginDAO> facebookLogin(String user, String password);

}
