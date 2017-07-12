package d1marine.com.nas.customui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import d1marine.com.nas.R;

/**
 * Created by User on 11/7/2017.
 */

public class CustomToolbar extends android.support.v7.widget.Toolbar implements View.OnClickListener {
public Activity mActivity;
    ImageView mImageView;
    CustomTextViewNormal mTextView;


    public CustomToolbar(Activity activity) {
        super(activity);
        mActivity=activity;

    }
    public CustomToolbar(Activity activity,String str_activity) {
        super(activity);
        mActivity=activity;
        init(str_activity);
    }



    private void init(String str_activity) {
        switch (str_activity){
            case "FacebookFriendsListActivity":{
                showTextViewInToolbar(R.id.text_toolbar_activity_title);
                hideImageviewFromToolbar(R.id.img_toolbar_back_button);
                hideTextViewFromToolbar(R.id.text_toolbar_app_name);
                hideImageviewFromToolbar(R.id.img_toolbar_english);
                break;
            }
        }

    }

    @Override
    public void onClick(View v) {

    }

    public void hideImageviewFromToolbar(int widgetId){
        mImageView=(ImageView)findViewById(widgetId);
        mImageView.setVisibility(View.INVISIBLE);
    }
    public void showImageviewInToolbar(int widgetId){
        mImageView=(ImageView)findViewById(widgetId);
        mImageView.setVisibility(View.VISIBLE);
    }
    public void hideTextViewFromToolbar(int widgetId){
        mTextView=(CustomTextViewNormal) findViewById(widgetId);
        mTextView.setVisibility(View.INVISIBLE);
    }
    public void showTextViewInToolbar(int widgetId){
        mTextView=(CustomTextViewNormal) findViewById(widgetId);
        mTextView.setVisibility(View.VISIBLE);
    }
}
