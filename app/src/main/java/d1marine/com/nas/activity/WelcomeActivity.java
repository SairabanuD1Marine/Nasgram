package d1marine.com.nas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;

import d1marine.com.nas.R;
import d1marine.com.nas.customui.CustomTextView;
import d1marine.com.nas.customui.CustomTextViewBold;
import d1marine.com.nas.customui.CustomTextViewNormal;

import static android.widget.AdapterView.*;

public class WelcomeActivity extends AppCompatActivity implements OnItemSelectedListener, View.OnClickListener {
    Spinner mSpinnerLanguage;
    LinearLayout mLayoutLogin;
    CustomTextView mTextAppName;
    CustomTextViewBold mTextLoginFb, mTextOr, mTextSIgnUpEmailPh, mTextLogin;
    CustomTextViewNormal mTextAlreadyHaveAcc;
    LoginButton mFbLoginButton;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_welcome);

        mSpinnerLanguage = (Spinner) findViewById(R.id.spinner_language_welcome);
        mLayoutLogin = (LinearLayout) findViewById(R.id.linear_layout_welcome_login);
        mFbLoginButton = (LoginButton) findViewById(R.id.text_welcome_login_with_fb);
        mTextAppName = (CustomTextView) findViewById(R.id.text_welcome_app_name);
        mTextOr = (CustomTextViewBold) findViewById(R.id.text_welcome_or);
        mTextSIgnUpEmailPh = (CustomTextViewBold) findViewById(R.id.text_welcome_signup_with_email);
        mTextLogin = (CustomTextViewBold) findViewById(R.id.text_welcome_login);
        mTextAlreadyHaveAcc = (CustomTextViewNormal) findViewById(R.id.text_welcome_already_have_acc);


        mSpinnerLanguage.setOnItemSelectedListener(this);
        mLayoutLogin.setOnClickListener(this);
        // mTextLoginFb.setOnClickListener(this);
        mTextSIgnUpEmailPh.setOnClickListener(this);

        String List_catagory[] = getResources().getStringArray(R.array.language);
        ArrayAdapter<String> array_catagory = new ArrayAdapter<String>(this, R.layout.frame_spinner, R.id.txt_item, List_catagory);
        mSpinnerLanguage.setAdapter(array_catagory);

        mFbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
               /* String mUserId = loginResult.getAccessToken().getUserId();
                String mAuthToken = loginResult.getAccessToken().getToken();*/


                GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequest(
                        loginResult.getAccessToken(), "/me/friends", null, HttpMethod.GET, new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                Intent intent = new Intent(WelcomeActivity.this, FacebookFriendsListActivity.class);
                                try {
                                    JSONArray rawName = response.getJSONObject().getJSONArray("data");
                                    intent.putExtra("jsondata", rawName.toString());
                                    startActivity(intent);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).executeAsync();

            }

            @Override
            public void onCancel() {
                Toast.makeText(WelcomeActivity.this, "Login Attempt Canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(WelcomeActivity.this, "Login Attempt Failed", Toast.LENGTH_SHORT).show();
            }
        });

        mFbLoginButton.setReadPermissions("user_friends");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_welcome_login: {
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
                break;
            }
            case R.id.text_welcome_signup_with_email: {
                startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
                overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
                break;
            }
        }

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        overridePendingTransition(R.anim.back_button_entry, R.anim.back_button_exit);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
