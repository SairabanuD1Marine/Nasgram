package d1marine.com.nas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import d1marine.com.nas.R;
import d1marine.com.nas.customui.CustomEditText;
import d1marine.com.nas.customui.CustomTextViewBold;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    CustomTextViewBold mTextPhone, mTextEmail, mTextCountryCode, mTextPhoneNextActive, mTextPhoneNextInactive, mTextEmailNextActive, mTextEmailNextInactive;
    LinearLayout mLayoutPhone, mLayoutEmail, mLayoutLogin;
    CustomEditText mEditPhoneNumber, mEditEmail;
    View mViewPhone, mViewEmail;
    CustomDialogActivity mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mTextPhone = (CustomTextViewBold) findViewById(R.id.text_signup_phone);
        mTextEmail = (CustomTextViewBold) findViewById(R.id.text_signup_email);
        mTextCountryCode = (CustomTextViewBold) findViewById(R.id.text_signup_country_code);
        mTextPhoneNextActive = (CustomTextViewBold) findViewById(R.id.text_signup_phone_next_active);
        mTextPhoneNextInactive = (CustomTextViewBold) findViewById(R.id.text_signup_phone_next_inactive);
        mLayoutLogin = (LinearLayout) findViewById(R.id.linear_layout_signup_login);
        mLayoutPhone = (LinearLayout) findViewById(R.id.linear_layout_signup_phone);
        mEditPhoneNumber = (CustomEditText) findViewById(R.id.edit_text_signup_phone_number);
        mViewPhone = (View) findViewById(R.id.view_signup_phone);
        mViewEmail = (View) findViewById(R.id.view_signup_email);
        mLayoutEmail = (LinearLayout) findViewById(R.id.linear_layout_signup_email);
        mTextEmailNextActive = (CustomTextViewBold) findViewById(R.id.text_signup_email_next_active);
        mTextEmailNextInactive = (CustomTextViewBold) findViewById(R.id.text_signup_email_next_inactive);
        mEditEmail = (CustomEditText) findViewById(R.id.edit_text_signup_email);

        mCustomDialog=new CustomDialogActivity(SignupActivity.this,mTextCountryCode);

        mLayoutPhone.setVisibility(View.VISIBLE);
        if (mLayoutPhone.getVisibility() == View.VISIBLE) {
            mTextPhoneNextActive.setVisibility(View.GONE);
            mTextPhoneNextInactive.setVisibility(View.VISIBLE);
        }
        mLayoutEmail.setVisibility(View.GONE);

        mTextPhone.setTextColor(getResources().getColor(R.color.colorBlack));
        mViewPhone.setBackgroundColor(getResources().getColor(R.color.colorBlack));

        mTextCountryCode.setOnClickListener(this);
        mTextPhoneNextActive.setOnClickListener(this);
        mLayoutLogin.setOnClickListener(this);
        mTextPhone.setOnClickListener(this);
        mTextEmail.setOnClickListener(this);
        mTextEmailNextActive.setOnClickListener(this);
        mEditEmail.addTextChangedListener(this);
        mEditPhoneNumber.addTextChangedListener(this);

    }

    public void dismissDialog(){
        mCustomDialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_signup_country_code: {
               // CustomDialogActivity mCustomDialog=new CustomDialogActivity(SignupActivity.this,mTextCountryCode);
                mCustomDialog.show();
                break;
            }
            case R.id.text_signup_phone_next_active: {
                startActivity(new Intent(SignupActivity.this,ConfirmationCodeActivity.class));
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);

                break;
            }
            case R.id.text_signup_email_next_active:{
                startActivity(new Intent(SignupActivity.this,UserDetailsActivity.class));
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);
                break;
            }
            case R.id.linear_layout_signup_login: {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
                break;
            }
            case R.id.text_signup_phone: {
                mEditEmail.getText().clear();
                mLayoutPhone.setVisibility(View.VISIBLE);
                mTextPhoneNextActive.setVisibility(View.GONE);
                mTextPhoneNextInactive.setVisibility(View.VISIBLE);
                mLayoutEmail.setVisibility(View.GONE);
                mTextPhone.setTextColor(getResources().getColor(R.color.colorBlack));
                mViewPhone.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                mTextEmail.setTextColor(getResources().getColor(R.color.colorGrey));
                mViewEmail.setBackgroundColor(getResources().getColor(R.color.colorGrey));

                break;
            }
            case R.id.text_signup_email: {
                mEditPhoneNumber.getText().clear();
                mLayoutPhone.setVisibility(View.GONE);
                mLayoutEmail.setVisibility(View.VISIBLE);
                mTextEmailNextActive.setVisibility(View.GONE);
                mTextEmailNextInactive.setVisibility(View.VISIBLE);
                mTextEmail.setTextColor(getResources().getColor(R.color.colorBlack));
                mViewEmail.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                mTextPhone.setTextColor(getResources().getColor(R.color.colorGrey));
                mViewPhone.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                break;
            }
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mLayoutPhone.getVisibility() == View.VISIBLE) {
            if (mEditPhoneNumber.getText().toString().length() > 0) {
                mTextPhoneNextInactive.setVisibility(View.GONE);
                mTextPhoneNextActive.setVisibility(View.VISIBLE);
            } else {
                mTextPhoneNextActive.setVisibility(View.GONE);
                mTextPhoneNextInactive.setVisibility(View.VISIBLE);
            }
        }
        else if (mLayoutEmail.getVisibility() == View.VISIBLE) {

            if (mEditEmail.getText().toString().length() > 0) {
                mTextEmailNextActive.setVisibility(View.VISIBLE);
                mTextEmailNextInactive.setVisibility(View.GONE);
            } else {
                mTextEmailNextActive.setVisibility(View.GONE);
                mTextEmailNextInactive.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_button_entry,R.anim.back_button_exit);
    }
}
