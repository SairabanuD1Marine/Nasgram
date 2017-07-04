package d1marine.com.nasgram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import d1marine.com.nasgram.R;

public class WelcomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner mSpinnerLanguage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mSpinnerLanguage=(Spinner)findViewById(R.id.spinner_language);
        mSpinnerLanguage.setOnItemSelectedListener(this);


        String List_catagory[]=getResources().getStringArray(R.array.language);
        ArrayAdapter<String> array_catagory=new ArrayAdapter<String>(this,R.layout.frame_spinner,R.id.txt_item,List_catagory);
        mSpinnerLanguage.setAdapter(array_catagory);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
