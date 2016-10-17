package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.AppUtils;
import blueprint.dynamic.framework.utils.Constants;

/**
 * Created by Techjini on 10/10/2016.
 */
public class BluePrintTextView extends AppCompatTextView {

    private Context mContext;

    public BluePrintTextView(Context context) {
        super(context);
        mContext = context;
    }

    public BluePrintTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public BluePrintTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setComponent(ComponentElement componentElement, ViewGroup parentLayout, String parent_orientation) {
        this.setId(AppUtils.getNextUniqueIndex());

        String weight = componentElement.getItem_weight();
        int margin = (int) mContext.getResources().getDimension(R.dimen.dimen_5_dp);

        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(parent_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.MATCH_PARENT, Float.parseFloat(weight));
                params.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params);
            } else {
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                params1.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params1);
            }
        } else if (Constants.Orientation.VERTICAL.equalsIgnoreCase(parent_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        0, Float.parseFloat(weight));
                params2.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params2);
            } else {
                LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                params3.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params3);
            }
        }

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
                    GradientDrawable drawable1 = AppUtils.getGradientDrawable(mContext, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100),
                            !componentElement.getComponent_border_color().isEmpty()
                                    ? Color.parseColor(componentElement.getComponent_border_color())
                                    : ContextCompat.getColor(mContext, R.color.color_36415D), this);
                    setBackgroundDrawable(drawable1);
                }
            }
        } else if (componentElement.getComponent_background_color() != null) {
            setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }
        System.out.println("BluePrintTextView.setComponent---"+componentElement.getComponent_label());
        parentLayout.addView(this);
    }
}