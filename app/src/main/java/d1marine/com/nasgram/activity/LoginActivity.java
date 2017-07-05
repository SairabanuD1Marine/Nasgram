package d1marine.com.nasgram.activity;

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

import d1marine.com.nasgram.R;
import d1marine.com.nasgram.customui.CustomEditText;
import d1marine.com.nasgram.customui.CustomTextView;
import d1marine.com.nasgram.customui.CustomTextViewBold;
import d1marine.com.nasgram.customui.CustomTextViewNormal;

public class LoginActivity extends AppCompatActivity implements OnItemSelectedListener,TextWatcher {
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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_button_entry,R.anim.back_button_exit);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
