package d1marine.com.nas.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import d1marine.com.nas.R;
import d1marine.com.nas.adapter.CustomDialogAdapter;
import d1marine.com.nas.model.DialogModel;

public class CustomDialogActivity extends Dialog implements View.OnClickListener, CustomDialogAdapter.customButtonListener {
    public Activity mActivity;
    RecyclerView mRecyclerView;
    private ArrayList<DialogModel> List = new ArrayList<DialogModel>();
    private CustomDialogAdapter adapter;
    TextView mTextView;


    public CustomDialogActivity(Activity activity, TextView mTextcountryCode) {
        super(activity);
        this.mActivity = activity;
        mTextView = mTextcountryCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_dialog_box);

        handleCountrycode();
    }

    private void handleCountrycode() {
        String ListCountryName[] = mActivity.getResources().getStringArray(R.array.country_arrays);
        String ListCountryCode[] = mActivity.getResources().getStringArray(R.array.country_code);

        for (int i = 0; i < ListCountryName.length - 1; i++) {
            DialogModel mDialogModel = new DialogModel();
            mDialogModel.setmCountry(ListCountryName[i]);
            mDialogModel.setmCountryCode(ListCountryCode[i]);

            List.add(mDialogModel);
        }
        try {
            if (List != null & List.size() > 0) {
                adapter = new CustomDialogAdapter(mActivity, List, mTextView);
                adapter.setCustomButtonListner(CustomDialogActivity.this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mActivity.getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(adapter);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCountryCodeClickListener(int position) {
        dismiss();
        DialogModel mDialogModel = List.get(position);
        mTextView.setText(mDialogModel.getmCountryCode());

    }
}
