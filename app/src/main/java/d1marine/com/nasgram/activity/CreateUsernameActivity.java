package d1marine.com.nasgram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import d1marine.com.nasgram.R;
import d1marine.com.nasgram.customui.CustomEditText;
import d1marine.com.nasgram.customui.CustomTextViewBold;
import d1marine.com.nasgram.customui.CustomTextViewNormal;

public class CreateUsernameActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {
    CustomTextViewBold mTextNextActive,mTextNextInactive,mTextLearnMore,mTextTermsPolicy;
    CustomEditText mEditUsername;
    CustomTextViewNormal mTextContinueWithoutSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_username);

        mTextNextActive=(CustomTextViewBold)findViewById(R.id.text_crt_usr_next_active);
        mTextNextInactive=(CustomTextViewBold)findViewById(R.id.text_crt_usr_next_inactive);
        mTextLearnMore=(CustomTextViewBold)findViewById(R.id.text_crt_usr_learn_more);
        mTextTermsPolicy=(CustomTextViewBold)findViewById(R.id.text_crt_usr_terms_and_privacy);
        mTextContinueWithoutSync=(CustomTextViewNormal)findViewById(R.id.text_crt_usr_continue_without_sync_contacts);
        mEditUsername=(CustomEditText)findViewById(R.id.edit_text_crt_usr_username);

        mTextNextActive.setOnClickListener(this);
        mTextLearnMore.setOnClickListener(this);
        mTextContinueWithoutSync.setOnClickListener(this);
        mTextTermsPolicy.setOnClickListener(this);
        mEditUsername.addTextChangedListener(this);

        mTextNextActive.setVisibility(View.GONE);
        mTextNextInactive.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_crt_usr_next_active:{

                break;
            }
            case R.id.text_crt_usr_learn_more:{

                break;
            }
            case R.id.text_crt_usr_terms_and_privacy:{

                break;
            }
            case R.id.text_crt_usr_continue_without_sync_contacts:{

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
        if(mEditUsername.getText().toString().length()>0){
            mTextNextActive.setVisibility(View.VISIBLE);
            mTextNextInactive.setVisibility(View.GONE);
        }else{
            mTextNextActive.setVisibility(View.GONE);
            mTextNextInactive.setVisibility(View.VISIBLE);
        }

    }


}
