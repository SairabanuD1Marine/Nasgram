package d1marine.com.nas.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import d1marine.com.nas.R;
import d1marine.com.nas.activity.CustomDialogActivity;
import d1marine.com.nas.activity.SignupActivity;
import d1marine.com.nas.customui.CustomTextViewNormal;
import d1marine.com.nas.model.DialogModel;

/**
 * Created by User on 10/7/2017.
 */

public class CustomDialogAdapter extends RecyclerView.Adapter<CustomDialogAdapter.MyViewHolder> {
    private List<DialogModel> mDialogList;
    private Context mContext;
    TextView mTextView;

    customButtonListener customListner;

    public interface customButtonListener {
        public void onCountryCodeClickListener(int position);
    }

    public void setCustomButtonListner(customButtonListener customListner) {
        this.customListner = customListner;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CustomTextViewNormal mTextDialog;
        public MyViewHolder(View view) {
            super(view);
            mTextDialog=(CustomTextViewNormal)view.findViewById(R.id.text_dialog_item);
            mTextDialog.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (customListner != null) {
                customListner.onCountryCodeClickListener(getPosition());
            }
           /* int position=mTextDialog.getId();
            DialogModel mDialogModel=mDialogList.get(position);
            mTextView.setText(mDialogModel.getmCountryCode());*/
          //  mTextView.setText(mTextDialog.getText().toString());


        }
    }

    public CustomDialogAdapter(Context context,List<DialogModel>dialogList,TextView tv){
        this.mDialogList=dialogList;
        this.mContext=context;
        this.mTextView=tv;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frame_custom_dialog, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DialogModel mDialogModel=mDialogList.get(position);
        holder.mTextDialog.setText(mDialogModel.getmCountry()+" ("+mDialogModel.getmCountryCode()+")");

    }

    @Override
    public int getItemCount() {
        return mDialogList.size();
    }


}
