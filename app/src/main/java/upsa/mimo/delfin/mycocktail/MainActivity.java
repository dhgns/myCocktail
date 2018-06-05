package upsa.mimo.delfin.mycocktail;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;


public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_rss:
                    transaction.replace(R.id.container, new RssFragment()).commit();
                    return true;
                case R.id.navigation_cocktails:
                    transaction.replace(R.id.container, new CocktailsFragment()).commit();
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.main_layout);



//        actionBar.setCustomView(R.layout.cocktails_title_layout);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Drawable bg_item = getDrawable(R.drawable.tool_bar_bg);

        navigation.setSelectedItemId(R.id.navigation_cocktails);
        navigation.setBackground(bg_item);


        ColorStateList colorStateList = getColorStateList(R.color.nav_buttons);
        navigation.setItemIconTintList(colorStateList);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.container, new CocktailsFragment()).commit();
    }

}
