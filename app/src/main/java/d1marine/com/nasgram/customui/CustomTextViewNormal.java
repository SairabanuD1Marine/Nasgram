package d1marine.com.nasgram.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 4/7/2017.
 */

public class CustomTextViewNormal extends android.support.v7.widget.AppCompatTextView{
    public CustomTextViewNormal(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
        setTypeface(tf, 1);
    }

    public CustomTextViewNormal(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
        setTypeface(tf, 1);

    }

    public CustomTextViewNormal(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
        setTypeface(tf, 1);
    }
}
