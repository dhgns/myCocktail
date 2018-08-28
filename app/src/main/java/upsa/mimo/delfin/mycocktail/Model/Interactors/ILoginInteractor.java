package upsa.mimo.delfin.mycocktail.Model.Interactors;

import android.arch.lifecycle.LiveData;

import upsa.mimo.delfin.mycocktail.Model.Interactors.BO.LoginBO;

public interface ILoginInteractor {

    public LiveData<LoginBO> loginWithFacebook(String user, String password);
    public LiveData<LoginBO> signUp(String email, String password);

}
