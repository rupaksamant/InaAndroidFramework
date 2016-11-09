package blueprint.dynamic.framework.model.customwidgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.ui_engine.ComponentHelper;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

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

    public void setComponent(ComponentElement componentElement, ViewGroup view, String parent_orientation, boolean b) {
        this.setId(Utils.getIdFromString(mContext, componentElement.getItem_id()));
        /*if(view instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, (int) mContext.getResources().getDimension(R.dimen.dimen_10_dp), 0);
            setLayoutParams(layoutParams);
        } else if(view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins((int) mContext.getResources().getDimension(R.dimen.dimen_10_dp),0, 0, 0);
            setLayoutParams(layoutParams);
        }*/

        this.setId(Utils.getIdFromString(mContext, componentElement.getItem_id()));

        int defaultHeight = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.EDITTEXT_HEIGHT);
        int defaultWidth = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.EDITTEXT_WIDTH);
        int defaultMargin = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.EDITTEXT_MARGIN);
        int defaultPadding = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.EDITTEXT_PADDING);

        ComponentHelper.setLayoutParamsAndOrientation(mContext, this, componentElement, parent_orientation,
                defaultHeight, defaultWidth, defaultMargin, defaultPadding);

        if(componentElement.getComponent_label() != null) {
            setHint(componentElement.getComponent_label());
        }

        if(componentElement.getComponent_hint() != null) {
            setHint(componentElement.getComponent_hint());
        }

        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        setComponentColors(componentElement);

        view.addView(this);
        setInputType(InputType.TYPE_CLASS_NUMBER);
        this.setMaxHeight(20);
        /*if(componentElement.getComponent_input_type() != null) {
            //  setInputType(InputTypeConverter.convertStringToInt(componentElement.getComponent_input_type()));
            //  setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL)
            setRawInputType(InputTypeConverter.convertStringToInt(componentElement.getComponent_input_type()));

        }*/
    }

    public void setComponentColors(ComponentElement componentElement) {
        setClickable(true);
        if (componentElement.getComponent_font_color() != null) {
            setTextColor(!componentElement.getComponent_font_color().isEmpty() ? Color.parseColor(componentElement.getComponent_font_color()) : ContextCompat.getColor(mContext, R.color.default_font_color));
        } else {
            setTextColor(ContextCompat.getColor(mContext, R.color.default_font_color));
        }

        if (componentElement.getComponent_hint_font_color() != null) {
            setHintTextColor(!componentElement.getComponent_hint_font_color().isEmpty() ? Color.parseColor(componentElement.getComponent_hint_font_color()) : ContextCompat.getColor(mContext, R.color.default_hint_font_color));
        } else {
            setHintTextColor(ContextCompat.getColor(mContext, R.color.default_hint_font_color));
        }

        if (componentElement.getComponent_border_color() != null) {
            if (componentElement.getComponent_border_color().isEmpty()) {
                if (componentElement.getComponent_background_color() != null) {
                    setBackgroundColor(!componentElement.getComponent_border_color().isEmpty() ? Color.parseColor(componentElement.getComponent_border_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
                }
            } else {
                if (componentElement.getComponent_background_color() != null) {
                    setBackground(ContextCompat.getDrawable(mContext, R.drawable.layerlist_rounded_rect_ffffff_6eacda_stroke));
                    GradientDrawable drawable1 = Utils.getGradientDrawable(mContext, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100),
                            !componentElement.getComponent_border_color().isEmpty()
                                    ? Color.parseColor(componentElement.getComponent_border_color())
                                    : ContextCompat.getColor(mContext, R.color.color_36415D), this);
                    setBackgroundDrawable(drawable1);
                    setBackgroundResource(R.color.color_e9e9e9);
                }
            }
        } else if (componentElement.getComponent_background_color() != null) {
            setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }
    }
}
