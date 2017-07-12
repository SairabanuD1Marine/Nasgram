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
import d1marine.com.nas.customui.CustomTextViewNormal;

public class ConfirmationCodeActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {
    CustomTextViewBold mTextRequestNew,mTextNextActive,mNextTextInactive;
    CustomTextViewNormal mTextPhoneNumber;
    CustomEditText mEditConfirmationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_code);

        mTextRequestNew=(CustomTextViewBold)findViewById(R.id.text_conf_request_new);
        mTextNextActive=(CustomTextViewBold)findViewById(R.id.text_conf_next_active);
        mNextTextInactive=(CustomTextViewBold)findViewById(R.id.text_conf_next_inactive);
        mTextPhoneNumber=(CustomTextViewNormal)findViewById(R.id.text_conf_phone_number);
        mEditConfirmationCode=(CustomEditText)findViewById(R.id.edit_text_conf_confirmation_code);

        mTextRequestNew.setOnClickListener(this);
        mTextNextActive.setOnClickListener(this);
        mEditConfirmationCode.addTextChangedListener(this);

        mTextNextActive.setVisibility(View.GONE);
        mNextTextInactive.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_conf_next_active:{
                startActivity(new Intent(ConfirmationCodeActivity.this,UserDetailsActivity.class));
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);

                break;
            }
            case R.id.text_conf_request_new:{

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
        if(mEditConfirmationCode.getText().toString().length()>0&&mEditConfirmationCode.getText().toString().length()==6){
            mTextNextActive.setVisibility(View.VISIBLE);
            mNextTextInactive.setVisibility(View.GONE);
        }else{
            mNextTextInactive.setVisibility(View.VISIBLE);
            mTextNextActive.setVisibility(View.GONE);
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_button_entry,R.anim.back_button_exit);
    }


}
