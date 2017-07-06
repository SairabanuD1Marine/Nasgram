package d1marine.com.nasgram.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import d1marine.com.nasgram.R;
import d1marine.com.nasgram.customui.CustomTextView;
import d1marine.com.nasgram.customui.CustomTextViewBold;
import d1marine.com.nasgram.customui.CustomTextViewNormal;

import static android.widget.AdapterView.*;

public class WelcomeActivity extends AppCompatActivity implements OnItemSelectedListener, View.OnClickListener {
    Spinner mSpinnerLanguage;
    LinearLayout mLayoutLogin;
    CustomTextView mTextAppName;
    CustomTextViewBold mTextLoginFb, mTextOr, mTextSIgnUpEmailPh, mTextLogin;
    CustomTextViewNormal mTextAlreadyHaveAcc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mSpinnerLanguage = (Spinner) findViewById(R.id.spinner_language_welcome);
        mLayoutLogin = (LinearLayout) findViewById(R.id.linear_layout_welcome_login);
        mTextLoginFb = (CustomTextViewBold) findViewById(R.id.text_welcome_login_with_fb);
        mTextAppName = (CustomTextView) findViewById(R.id.text_welcome_app_name);
        mTextOr = (CustomTextViewBold) findViewById(R.id.text_welcome_or);
        mTextSIgnUpEmailPh = (CustomTextViewBold) findViewById(R.id.text_welcome_signup_with_email);
        mTextLogin = (CustomTextViewBold) findViewById(R.id.text_welcome_login);
        mTextAlreadyHaveAcc = (CustomTextViewNormal) findViewById(R.id.text_welcome_already_have_acc);

        mSpinnerLanguage.setOnItemSelectedListener(this);
        mLayoutLogin.setOnClickListener(this);
        mTextLoginFb.setOnClickListener(this);
        mTextSIgnUpEmailPh.setOnClickListener(this);

        String List_catagory[] = getResources().getStringArray(R.array.language);
        ArrayAdapter<String> array_catagory = new ArrayAdapter<String>(this, R.layout.frame_spinner, R.id.txt_item, List_catagory);
        mSpinnerLanguage.setAdapter(array_catagory);
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
            case R.id.text_welcome_signup_with_email:{
                startActivity(new Intent(WelcomeActivity.this,SignupActivity.class));
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);
                break;
            }
        }

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        overridePendingTransition(R.anim.back_button_entry,R.anim.back_button_exit);

    }
}
