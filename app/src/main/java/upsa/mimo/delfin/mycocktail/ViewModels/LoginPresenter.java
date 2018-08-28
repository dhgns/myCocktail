package upsa.mimo.delfin.mycocktail.ViewModels;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import io.fabric.sdk.android.Fabric;
import upsa.mimo.delfin.mycocktail.Model.Interactors.BO.LoginBO;
import upsa.mimo.delfin.mycocktail.Model.Interactors.ILoginInteractor;
import upsa.mimo.delfin.mycocktail.Model.Interactors.LoginInteractor;
import upsa.mimo.delfin.mycocktail.Utils.Constants;
import upsa.mimo.delfin.mycocktail.Views.UI.MainActivity;

import static com.facebook.FacebookSdk.getApplicationContext;
import static upsa.mimo.delfin.mycocktail.Model.Repositories.DAO.ErrorComm.Status.NO_ERROR;
import static upsa.mimo.delfin.mycocktail.Utils.Constants.Screens.MAIN;

public class LoginPresenter extends ViewModel implements ILoginPresenter {

    private String email;
    private String password;

    private MutableLiveData<Boolean> mailError;
    private MutableLiveData<Boolean> passwordError;

    private MutableLiveData<Constants.Screens> navigateTo;

    private FirebaseAuth mAuth;
    private ILoginInteractor loginInteractor;

    private CallbackManager callbackManager;
    public static final String USER_TOKEN = "user_token";

    public LoginPresenter(){
        this.mailError = new MutableLiveData<>();
        this.passwordError = new MutableLiveData<>();

        this.navigateTo = new MutableLiveData<>();

        this.mailError.setValue(false);
        this.passwordError.setValue(false);

        mAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());
        Fabric.with(getApplicationContext(), new Crashlytics());

        loginInteractor = new LoginInteractor();

        checkUserSession();

    }

    @Override
    public void checkUserSession() {

        if(isValidFirebaseSession() || isValidFacebookSession())
            this.navigateTo.setValue(MAIN);

    }

    private boolean isValidFacebookSession() {

        if (AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired())
            return true;

        return false;
    }

    private boolean isValidFirebaseSession() {
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            return true;
        }
        return false;
    }


    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public MutableLiveData<Boolean> getMailError(){
        return this.mailError;
    }

    @Override
    public MutableLiveData<Boolean> getPasswordError(){
        return this.passwordError;
    }

    @Override
    public void doFBLogin() {

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        navigateTo.setValue(MAIN);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

    }

    @Override
    public void doEmailPasswordLogin() {

    }

    @Override
    public void doSignUp() {
        if (!isValidateForm()) {
            return;
        }

        loginInteractor.signUp(email, password).observe((LifecycleOwner) this, loginBO->{
            if(loginBO != null){
                if(loginBO.errorLog.status == NO_ERROR){
                    this.navigateTo.setValue(MAIN);
                }
            }
        });

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public MutableLiveData<Constants.Screens> getNavigateTo() {
        return this.navigateTo;
    }

    private boolean isValidateForm() {

        if (email == null || email.equals("")) {
            this.mailError.setValue(true);
            return false;
        }

        if (password == null || password.equals("")) {
            this.passwordError.setValue(true);
            return false;
        }

        return true;
    }
}
