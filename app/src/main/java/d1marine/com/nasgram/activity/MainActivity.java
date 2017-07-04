package d1marine.com.nasgram.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import d1marine.com.nasgram.ParentActivity;
import d1marine.com.nasgram.R;

public class MainActivity extends ParentActivity {
     Typeface mTypeface;
    TextView mToolbarTitle;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mTypeface=Typeface.createFromAsset(this.getAssets(),"fonts/AlexBrush-Regular.ttf");//fonts/AlexBrush-Regular.ttf//fonts/caveat-bold.ttf
        mToolbarTitle=(TextView)findViewById(R.id.toolbar_title);
        mToolbarTitle.setTypeface(mTypeface);

        //hideBackbuttonFromToolbar(R.id.img_back_button);



    }
}
