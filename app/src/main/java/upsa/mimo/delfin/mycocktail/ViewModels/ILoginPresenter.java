package upsa.mimo.delfin.mycocktail.ViewModels;

import android.arch.lifecycle.MutableLiveData;

import upsa.mimo.delfin.mycocktail.Utils.Constants;

public interface ILoginPresenter {

    void checkUserSession();

    public void setEmail(String email);
    public void setPassword(String password);

    MutableLiveData<Boolean> getMailError();

    MutableLiveData<Boolean> getPasswordError();

    void doFBLogin();
    void doEmailPasswordLogin();
    void doSignUp();

    MutableLiveData<Constants.Screens> getNavigateTo();

}
