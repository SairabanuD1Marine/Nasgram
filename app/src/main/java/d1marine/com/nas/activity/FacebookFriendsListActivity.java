package d1marine.com.nas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import d1marine.com.nas.ParentActivity;
import d1marine.com.nas.R;
import d1marine.com.nas.customui.CustomTextViewNormal;
import d1marine.com.nas.customui.CustomToolbar;

public class FacebookFriendsListActivity extends ParentActivity {
    TextView mToolbarTitle;
    Toolbar mToolbar;
    CustomTextViewNormal mTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_friends_list);
        mToolbar=(Toolbar)findViewById(R.id.toolbar_facebook_friends_list);
        hideImageviewFromToolbar(R.id.img_toolbar_english);
        showImageviewInToolbar(R.id.img_toolbar_back_button);
        hideTextViewFromToolbar(R.id.text_toolbar_app_name);
        showTextViewInToolbar(R.id.text_toolbar_activity_title);
        mTextTitle=(CustomTextViewNormal)findViewById(R.id.text_toolbar_activity_title);
        mTextTitle.setText("Facebook Friends");


        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("jsondata");

        JSONArray friendslist;
        ArrayList<String> friends = new ArrayList<String>();

        try {
            friendslist = new JSONArray(jsondata);
            for (int l=0; l < friendslist.length(); l++) {
                friends.add(friendslist.getJSONObject(l).getString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.frame_facebook_friends_list, friends); // simple textview for list item
        ListView listView = (ListView) findViewById(R.id.listView_fb_friends);
        listView.setAdapter(adapter);
    }
}
