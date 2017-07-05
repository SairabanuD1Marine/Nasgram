package d1marine.com.nasgram.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by User on 4/7/2017.
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {

    public CustomEditText(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
        setTypeface(tf, 1);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
        setTypeface(tf, 1);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/source-sans-pro.light.ttf");
        setTypeface(tf, 1);
    }
}
