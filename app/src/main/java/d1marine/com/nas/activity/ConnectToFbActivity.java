package d1marine.com.nas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import d1marine.com.nas.R;
import d1marine.com.nas.customui.CustomTextViewBold;

public class ConnectToFbActivity extends AppCompatActivity implements View.OnClickListener {
    FrameLayout mLayoutLoginWithFb;
    CustomTextViewBold mTextSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_to_fb);

        mLayoutLoginWithFb=(FrameLayout)findViewById(R.id.frame_layout_cnct_fb_login_with_fb);
        mTextSkip=(CustomTextViewBold)findViewById(R.id.text_cnct_fb_skip);

        mLayoutLoginWithFb.setOnClickListener(this);
        mTextSkip.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_layout_cnct_fb_login_with_fb:{

                break;
            }
            case R.id.text_cnct_fb_skip:{

                break;
            }
        }

    }
}
