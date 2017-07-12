package d1marine.com.nas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 2/7/2017.
 */

public class ParentActivity extends AppCompatActivity {
    private Activity mActivity;
    ImageView mImageView;
    TextView mTextView;
    EditText mEditText;


///////////////////MANAGE TOOLBAR////////////////////////////////
    public void hideImageviewFromToolbar(int widgetId){
        mImageView=(ImageView)findViewById(widgetId);
        mImageView.setVisibility(View.INVISIBLE);
    }
    public void showImageviewInToolbar(int widgetId){
        mImageView=(ImageView)findViewById(widgetId);
        mImageView.setVisibility(View.VISIBLE);
    }
    public void hideTextViewFromToolbar(int widgetId){
        mTextView=(TextView)findViewById(widgetId);
        mTextView.setVisibility(View.INVISIBLE);
    }
    public void showTextViewInToolbar(int widgetId){
        mTextView=(TextView)findViewById(widgetId);
        mTextView.setVisibility(View.VISIBLE);
    }
}
