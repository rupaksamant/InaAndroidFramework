package blueprint.dynamic.framework.model.customwidgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.ui_engine.ComponentHelper;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/10/2016.
 */
public class BluePrintSpinner  extends AppCompatSpinner {

    private Context mContext;

    public BluePrintSpinner(Context context) {
        super(context);
        mContext = context;
    }

    public BluePrintSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BluePrintSpinner(Context context, int mode) {
        super(context, mode);
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void setComponent(ComponentElement componentElement, ViewGroup parentLayout, String parent_orientation, boolean addToParent) {

        this.setId(Utils.getIdFromString(mContext, componentElement.getItem_id()));

        int defaultHeight = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.SPINNER_HEIGHT);
        int defaultWidth = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.SPINNER_WIDTH);
        int defaultMargin = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.SPINNER_MARGIN);
        int defaultPadding = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.SPINNER_PADDING);

        ComponentHelper.setLayoutParamsAndOrientation(mContext, this, componentElement,
                parent_orientation, defaultHeight, defaultWidth, defaultMargin, defaultPadding, addToParent);

        /*ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.blueprint_spinner_item, componentElement.getComponent_data());
        setAdapter(spinnerArrayAdapter);
        setSelection(0);
        parentLayout.addView(this);*/

        if(addToParent && parentLayout != null) {
            parentLayout.addView(this);
        }

    }

    public void setComponentColors(ComponentElement componentElement, ViewGroup spinnerLayout) {
//        setClickable(true);
        /*if (componentElement.getComponent_font_color() != null) {
            setTextColor(!componentElement.getComponent_font_color().isEmpty() ? Color.parseColor(componentElement.getComponent_font_color()) : ContextCompat.getColor(mContext, R.color.default_font_color));
            setTextColor(ContextCompat.getColor(mContext, R.color.default_font_color));
        } else {
            setTextColor(ContextCompat.getColor(mContext, R.color.default_font_color));
        }*/

        if (componentElement.getComponent_border_color() != null) {
            if (componentElement.getComponent_border_color().isEmpty()) {
                if (componentElement.getComponent_background_color() != null) {
                    spinnerLayout.setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
                }
            } else {
                if (componentElement.getComponent_background_color() != null) {
                    spinnerLayout.setBackground(ContextCompat.getDrawable(mContext, R.drawable.layerlist_rounded_rect_ffffff_6eacda_stroke));
                    GradientDrawable drawable1 = Utils.getGradientDrawable(mContext, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100),
                            !componentElement.getComponent_border_color().isEmpty()
                                    ? Color.parseColor(componentElement.getComponent_border_color())
                                    : ContextCompat.getColor(mContext, R.color.color_36415D), spinnerLayout);
                    spinnerLayout.setBackgroundDrawable(drawable1);
                }
            }
        } else if (componentElement.getComponent_background_color() != null) {
            spinnerLayout.setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }
    }
}
