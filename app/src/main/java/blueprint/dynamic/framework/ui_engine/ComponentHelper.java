package blueprint.dynamic.framework.ui_engine;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.Constants;

/**
 * Created by Techjini on 10/17/2016.
 */
public class ComponentHelper {
    public static void setLayoutParamsAndOrientation(Context context, View view, ComponentElement componentElement, String parent_orientation) {
        String weight = componentElement.getItem_weight();
        int margin = (int) context.getResources().getDimension(R.dimen.dimen_5_dp);
        int padding = (int) context.getResources().getDimension(R.dimen.dimen_5_dp);

        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(parent_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.MATCH_PARENT, Float.parseFloat(weight));
                params.setMargins(margin, margin, margin, margin);
                view.setLayoutParams(params);
                view.setPadding(padding, padding, padding, padding);
            } else {
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                params1.setMargins(margin, margin, margin, margin);
                view.setLayoutParams(params1);
                view.setPadding(padding, padding, padding, padding);
            }
        } else if (Constants.Orientation.VERTICAL.equalsIgnoreCase(parent_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        0, Float.parseFloat(weight));
                params2.setMargins(margin, margin, margin, margin);
                view.setLayoutParams(params2);
            } else {
                LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                params3.setMargins(margin, margin, margin, margin);
                view.setLayoutParams(params3);
                view.setPadding(padding, padding, padding, padding);
                view.setPadding(padding, padding, padding, padding);
            }
        } else {
            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params4.setMargins(margin, margin, margin, margin);
            view.setLayoutParams(params4);
            view.setPadding(padding, padding, padding, padding);
        }
    }

    ;

    public static void setComponentColors(View view, ComponentElement componentElement, Context context) {
        /*BluePrintTextView bptv;
        if(view instanceof BluePrintTextView) {
            view = (BluePrintTextView)view;
        }
        if (componentElement.getComponent_font_color() != null) {
            view.setTextColor(!componentElement.getComponent_font_color().isEmpty() ? Color.parseColor(componentElement.getComponent_font_color()) : ContextCompat.getColor(mContext, R.color.default_font_color));
            setTextColor(ContextCompat.getColor(context, R.color.default_font_color));
        } else {
            setTextColor(ContextCompat.getColor(context, R.color.default_font_color));
        }

        if (componentElement.getComponent_border_color() != null) {
            if (componentElement.getComponent_border_color().isEmpty()) {
                if (componentElement.getComponent_background_color() != null) {
                    setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
                }
            } else {
                if (componentElement.getComponent_background_color() != null) {
                    setBackground(ContextCompat.getDrawable(context, R.drawable.layerlist_rounded_rect_ffffff_6eacda_stroke));
                    GradientDrawable drawable1 = Utils.getGradientDrawable(context, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100),
                            !componentElement.getComponent_border_color().isEmpty()
                                    ? Color.parseColor(componentElement.getComponent_border_color())
                                    : ContextCompat.getColor(context, R.color.color_36415D), view);
                    setBackgroundDrawable(drawable1);
                }
            }
        } else if (componentElement.getComponent_background_color() != null) {
            setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }*/
    }
}
