package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.AppUtils;

/**
 * Created by Techjini on 10/10/2016.
 */
public class BluePrintEditText extends AppCompatEditText {
    private Context mContext;

    public BluePrintEditText(Context context) {
        super(context);
        mContext = context;
    }

    public BluePrintEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public BluePrintEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void setComponent(ComponentElement componentElement, ViewGroup view) {
        this.setId(AppUtils.getNextUniqueIndex());
        if(view instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, (int) mContext.getResources().getDimension(R.dimen.dimen_10_dp), 0);
            setLayoutParams(layoutParams);
        } else if(view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins((int) mContext.getResources().getDimension(R.dimen.dimen_10_dp),0, 0, 0);
            setLayoutParams(layoutParams);
        }
        if(componentElement.getItem_weight() != null && componentElement.getItem_weight().isEmpty() == false) {
//            this.setLa
        }
        if(componentElement.getComponent_label() != null) {
            setHint(componentElement.getComponent_label());
        }

        if(componentElement.getComponent_font_color()!= null) {
            setTextColor(!componentElement.getComponent_font_color().isEmpty() ? Color.parseColor(componentElement.getComponent_font_color()) : ContextCompat.getColor(mContext, R.color.color_6eacda));
        } else {
            setTextColor(ContextCompat.getColor(mContext, R.color.default_font_color));
        }

        view.addView(this);
        /*if(componentElement.getComponent_border_color()!= null) {
            if (componentElement.getComponent_border_color().isEmpty()) {
                if (componentElement.getComponent_background_color() != null) {
                    setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
                }
            } else {
                if (componentElement.getComponent_background_color() != null) {
                    setBackground(ContextCompat.getDrawable(mContext, R.drawable.layerlist_rounded_rect_ffffff_6eacda_stroke));
                    GradientDrawable drawable1 = Utils.getGradientDrawable(mContext, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100), !componentElement.getComponent_border_color().isEmpty() ? Color.parseColor(componentElement.getComponent_border_color()) : ContextCompat.getColor(mContext, R.color.color_36415D), this);
                    setBackgroundDrawable(drawable1);
                }
            }
        } else if(componentElement.getComponent_background_color()!= null) {
            setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }

        if(componentElement.getComponent_input_type() != null) {
            //  setInputType(InputTypeConverter.convertStringToInt(componentElement.getComponent_input_type()));
            //  setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL)
            setRawInputType(InputTypeConverter.convertStringToInt(componentElement.getComponent_input_type()));

        }*/
    }
}
