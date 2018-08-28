package upsa.mimo.delfin.mycocktail.Views.UI;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;
import upsa.mimo.delfin.mycocktail.R;
import upsa.mimo.delfin.mycocktail.ViewModels.ILoginPresenter;
import upsa.mimo.delfin.mycocktail.ViewModels.LoginPresenter;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private ILoginPresenter presenter;

    @BindView(R.id.field_email)
    private EditText mEmailField;

    @BindView(R.id.field_password)
    private EditText mPasswordField;

    private Button login_button_fb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this, findViewById(R.id.login_view));

        presenter = new LoginPresenter();

        mEmailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.setEmail(editable.toString());
            }
        });

        mPasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.setPassword(editable.toString());
            }
        });

        presenter.getNavigateTo().observe(this, screen ->{
            if(screen != null){
                switch (screen){
                    case MAIN:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        presenter.getNavigateTo().setValue(null);
                        break;
                }
            }
        });


    }
    @OnClick(R.id.email_sign_in_button)
    public void onClickMailLogin(){
        presenter.doEmailPasswordLogin();
    }

    @OnClick(R.id.login_button_fb)
    public void onClickFBLogin(){
        presenter.doFBLogin();
    }

    @OnClick(R.id.email_create_account_button)
    public void onClickEmail(){
        presenter.doSignUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.checkUserSession();

    }

    public void hideKeyboard(View view) {
        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}
