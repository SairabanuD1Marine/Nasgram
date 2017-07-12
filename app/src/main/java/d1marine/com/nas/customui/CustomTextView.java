package d1marine.com.nas.customui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
String fonttype="";

    public CustomTextView(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/AlexBrush-Regular.ttf");
        setTypeface(tf, 1);
       // init(fonttype);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/AlexBrush-Regular.ttf");
        setTypeface(tf, 1);
        // init(fonttype);

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/AlexBrush-Regular.ttf");
        setTypeface(tf, 1);
        // init(fonttype);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

   /* public void init(String fonttype) {
        switch (fonttype){

            case "LightSans":{
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
                setTypeface(tf, 1);
                break;
            }
            case "NormalSans":{
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.regular.ttf");
                setTypeface(tf, 1);
                break;
            }
            case "BoldSans":{
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.bold.ttf");
                setTypeface(tf, 1);
                break;
            }
            case "AppNameAlex":{
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/AlexBrush-Regular.ttf");
                setTypeface(tf, 1);
                break;
            }

        }
    }*/
}
