package d1marine.com.nas.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by User on 4/7/2017.
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {

    public CustomEditText(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/avenir-regular.otf");
        setTypeface(tf, 1);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/avenir-regular.otf");
        setTypeface(tf, 1);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/avenir-regular.otf");
        setTypeface(tf, 1);
    }
}
