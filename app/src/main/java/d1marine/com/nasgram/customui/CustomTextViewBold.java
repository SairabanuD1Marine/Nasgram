package d1marine.com.nasgram.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 4/7/2017.
 */

public class CustomTextViewBold  extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewBold(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.regular.ttf");
        setTypeface(tf, 1);
    }

    public CustomTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.regular.ttf");
        setTypeface(tf, 1);

    }

    public CustomTextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.regular.ttf");
        setTypeface(tf, 1);
    }
}
