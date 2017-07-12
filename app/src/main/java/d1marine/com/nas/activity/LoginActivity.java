package d1marine.com.nas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;

import d1marine.com.nas.R;
import d1marine.com.nas.customui.CustomEditText;
import d1marine.com.nas.customui.CustomTextView;
import d1marine.com.nas.customui.CustomTextViewBold;
import d1marine.com.nas.customui.CustomTextViewNormal;

public class LoginActivity extends AppCompatActivity implements OnItemSelectedListener,TextWatcher,View.OnClickListener {
    Spinner mSpinnerLanguage;
    CustomTextView mTextAppName;
    CustomEditText mEditUserName,mEditPassword;
    CustomTextViewBold mTextLoginActive,mTextLoginInactive,mTextOr,mTextLoginWithFb,mTextSignUp,mTextGetHelpSignIn;
    CustomTextViewNormal mTextForgotLogin,mTextDontHaveAcc;
    FrameLayout mFrameLayoutLoginWithFb;
    LinearLayout mLayoutSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSpinnerLanguage = (Spinner) findViewById(R.id.spinner_language_login);
        mTextAppName=(CustomTextView)findViewById(R.id.text_login_app_name);
        mEditUserName=(CustomEditText) findViewById(R.id.edit_text_login_user_name);
        mEditPassword=(CustomEditText)findViewById(R.id.edit_text_login_password);
        mTextLoginActive=(CustomTextViewBold) findViewById(R.id.text_login_login_active);
        mTextLoginInactive=(CustomTextViewBold)findViewById(R.id.text_login_login_inactive);
        mTextForgotLogin=(CustomTextViewNormal) findViewById(R.id.text_login_forgot_login);
        mTextGetHelpSignIn=(CustomTextViewBold)findViewById(R.id.text_login_get_help_sign_in);
        mTextOr=(CustomTextViewBold) findViewById(R.id.text_login_or);
        mFrameLayoutLoginWithFb=(FrameLayout) findViewById(R.id.frame_layout_login_login_with_fb);
        mTextLoginWithFb=(CustomTextViewBold) findViewById(R.id.text_login_login_with_fb);
        mLayoutSignUp=(LinearLayout) findViewById(R.id.linear_layout_login_signup);
        mTextSignUp=(CustomTextViewBold) findViewById(R.id.text_login_signup);
        mTextDontHaveAcc=(CustomTextViewNormal) findViewById(R.id.text_login_dont_have_acc);

        mTextLoginInactive.setVisibility(View.VISIBLE);
        mTextLoginActive.setVisibility(View.GONE);

        mSpinnerLanguage.setOnItemSelectedListener(this);
        mEditUserName.addTextChangedListener(this);
        mEditPassword.addTextChangedListener(this);
        mLayoutSignUp.setOnClickListener(this);

        String List_catagory[] = getResources().getStringArray(R.array.language);
        ArrayAdapter<String> array_catagory = new ArrayAdapter<String>(this, R.layout.frame_spinner, R.id.txt_item, List_catagory);
        mSpinnerLanguage.setAdapter(array_catagory);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_layout_login_signup:{
                startActivity(new Intent(LoginActivity.this,WelcomeActivity.class));
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);
                break;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(mEditUserName.getText().toString().length()>0 && mEditPassword.getText().toString().length()>0){
            mTextLoginInactive.setVisibility(View.GONE);
            mTextLoginActive.setVisibility(View.VISIBLE);

        }else{
            mTextLoginActive.setVisibility(View.GONE);
            mTextLoginInactive.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public void onBackPressed() {
        finishAffinity();
        overridePendingTransition(R.anim.back_button_entry,R.anim.back_button_exit);
    }
}
