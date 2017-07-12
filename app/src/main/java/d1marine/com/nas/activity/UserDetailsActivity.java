package d1marine.com.nas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import d1marine.com.nas.R;
import d1marine.com.nas.customui.CustomEditText;
import d1marine.com.nas.customui.CustomTextViewBold;

public class UserDetailsActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {
    CustomTextViewBold mTextNextActive,mTextNextInactive;
    CustomEditText mEditFullName,mEditPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        mTextNextInactive=(CustomTextViewBold)findViewById(R.id.text_user_det_next_inactive);
        mTextNextActive=(CustomTextViewBold)findViewById(R.id.text_user_det_next_active);
        mEditFullName=(CustomEditText)findViewById(R.id.edit_text_user_det_full_name);
        mEditPassword=(CustomEditText)findViewById(R.id.edit_text_user_det_password);

        mTextNextActive.setOnClickListener(this);
        mEditPassword.addTextChangedListener(this);
        mEditFullName.addTextChangedListener(this);

        mTextNextActive.setVisibility(View.GONE);
        mTextNextInactive.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_user_det_next_active:{
                startActivity(new Intent(UserDetailsActivity.this,CreateUsernameActivity.class));
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);
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
        if(mEditFullName.getText().toString().length()>0&&mEditPassword.getText().toString().length()>0){
            mTextNextActive.setVisibility(View.VISIBLE);
            mTextNextInactive.setVisibility(View.GONE);
        }else{
            mTextNextActive.setVisibility(View.GONE);
            mTextNextInactive.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_button_entry,R.anim.back_button_exit);
    }
}
