package blueprint.dynamic.framework.ui_engine;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/17/2016.
 */
public class ComponentHelper {
    public static void setLayoutParamsAndOrientation(Context context, View view,
                                                     ComponentElement componentElement, String parent_orientation,
                                                     int defaultHeight, int defaultWidth,
                                                     int defaultMargin, int defaultPadding, boolean addToParent) {
        String weight = componentElement.getItem_weight();
//        int margin = (int) context.getResources().getDimension(R.dimen.dimen_2_dp);
//        int padding = (int) context.getResources().getDimension(R.dimen.dimen_2_dp);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(parent_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                params = new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.MATCH_PARENT, Float.parseFloat(weight));
//                params.setMargins(margin, margin, margin, margin);
//                view.setLayoutParams(params);
//                view.setPadding(padding, padding, padding, padding);
            } else {
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
//                params.setMargins(margin, margin, margin, margin);
//                view.setLayoutParams(params);
//                view.setPadding(padding, padding, padding, padding);
            }
        } else if (Constants.Orientation.VERTICAL.equalsIgnoreCase(parent_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        0, Float.parseFloat(weight));
//                params2.setMargins(margin, margin, margin, margin);
//                view.setLayoutParams(params2);
            } else {
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
//                params.setMargins(margin, margin, margin, margin);
//                view.setLayoutParams(params);
//                view.setPadding(padding, padding, padding, padding);
            }
        } else {
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.setMargins(margin, margin, margin, margin);
//            view.setLayoutParams(params);
        }

        params.setMargins(defaultMargin, defaultMargin, defaultMargin, defaultMargin);
        if(addToParent) {
            params.gravity = (Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            view.setPadding(defaultPadding, defaultPadding, defaultPadding, defaultPadding);
        }
        view.setLayoutParams(params);

        view.setMinimumWidth(defaultWidth);
        view.setMinimumHeight(defaultHeight);
    }

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
