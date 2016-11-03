package blueprint.dynamic.framework.model.customwidgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.ui_engine.ComponentHelper;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/17/2016.
 */
public class BluePrintButtonView extends Button {
    private Context mContext;

    public BluePrintButtonView(Context context) {
        super(context);
        mContext = context;
    }

    public BluePrintButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public BluePrintButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setComponent(ComponentElement componentElement, ViewGroup parentLayout,
                             String parent_orientation) {
        System.out.println("BluePrintButtonView.setContainer-id---:"+Utils.getIdFromString(mContext, componentElement.getItem_id()));
        this.setId(Utils.getIdFromString(mContext, componentElement.getItem_id()));

        int defaultHeight = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.BUTTUON_HEIGHT);
        int defaultWidth = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.BUTTUON_WIDTH);

        ComponentHelper.setLayoutParamsAndOrientation(mContext, this, componentElement, parent_orientation, defaultHeight, defaultWidth);

        if (parentLayout instanceof LinearLayout) {
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(0, 0, (int) mContext.getResources().getDimension(R.dimen.dimen_10_dp), 0);
//            setLayoutParams(layoutParams);
        } else if (parentLayout instanceof RelativeLayout) {
//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(0, 0, (int) mContext.getResources().getDimension(R.dimen.dimen_10_dp), 0);
//            setLayoutParams(layoutParams);
        }

        this.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        if (componentElement.getComponent_label() != null) {
            setText(componentElement.getComponent_label());
        }

        setComponentColors(componentElement);
        System.out.println("BluePrintTextView.setContainer---"+componentElement.getComponent_label());
        parentLayout.addView(this);
    }


    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("BluePrintButtonView.onTouchEvent----"+this.getId());
        return super.onTouchEvent(event);
    }*/

    public void setComponentColors(ComponentElement componentElement) {
        if (componentElement.getComponent_font_color() != null) {
            setTextColor(!componentElement.getComponent_font_color().isEmpty() ? Color.parseColor(componentElement.getComponent_font_color()) : ContextCompat.getColor(mContext, R.color.default_font_color));
            setTextColor(ContextCompat.getColor(mContext, R.color.default_font_color));
        } else {
            setTextColor(ContextCompat.getColor(mContext, R.color.default_font_color));
        }

        if (componentElement.getComponent_border_color() != null) {
            if (componentElement.getComponent_border_color().isEmpty()) {
                if (componentElement.getComponent_background_color() != null) {
                    setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
                }
            } else {
                if (componentElement.getComponent_background_color() != null) {
                    setBackground(ContextCompat.getDrawable(mContext, R.drawable.layerlist_rounded_rect_ffffff_6eacda_stroke));
                    GradientDrawable drawable1 = Utils.getGradientDrawable(mContext, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100),
                            !componentElement.getComponent_border_color().isEmpty()
                                    ? Color.parseColor(componentElement.getComponent_border_color())
                                    : ContextCompat.getColor(mContext, R.color.color_36415D), this);
                    setBackgroundDrawable(drawable1);
                }
            }
        } else if (componentElement.getComponent_background_color() != null) {
            setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }
    }
}
