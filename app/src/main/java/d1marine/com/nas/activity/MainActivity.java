package d1marine.com.nas.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import d1marine.com.nas.ParentActivity;
import d1marine.com.nas.R;

public class MainActivity extends ParentActivity {
    //APP ID: 1924332514476024  from Facebook
    //App Secret: 57d56f1b88026863a8d2140de8c3f943  from Facebook               // developer@d1marine.com

    //App id: 1392511907530711 //personal acc
    //App secret: 28a19e8431005d0d818f9305bccd2e84
    //keyhash: J0brOpcDqOGq6JE7r7q9zQXEDUA=
     Typeface mTypeface;
    TextView mToolbarTitle;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=(Toolbar)findViewById(R.id.toolbar_main_activity);
        mTypeface=Typeface.createFromAsset(this.getAssets(),"fonts/AlexBrush-Regular.ttf");//fonts/AlexBrush-Regular.ttf//fonts/caveat-bold.ttf
        mToolbarTitle=(TextView)findViewById(R.id.text_toolbar_app_name);
        mToolbarTitle.setTypeface(mTypeface);

hideImageviewFromToolbar(R.id.img_toolbar_back_button);



    }
}
