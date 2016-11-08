package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.ui_engine.ComponentHelper;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/24/2016.
 */
public class InaVerticalLabelSpinner {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public InaVerticalLabelSpinner(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void setComponent(ComponentElement componentElement, ViewGroup parentLayout, String parent_orientation) {
        LinearLayout spinnerLayout = (LinearLayout) mLayoutInflater.inflate(R.layout.vertical_label_spinner, null, false);

//        spinnerLayout.setId(Utils.getIdFromString(mContext, componentElement.getItem_id()));
//        ComponentHelper.setLayoutParamsAndOrientation(mContext, spinnerLayout, componentElement, parent_orientation);

        spinnerLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        BluePrintTextView label = (BluePrintTextView) spinnerLayout.findViewById(R.id.spinner_label);
        label.setContext(mContext);
        label.setComponent(componentElement.getComponents()[0], null, parent_orientation, false);

        BluePrintSpinner spinner = (BluePrintSpinner) spinnerLayout.findViewById(R.id.spinner_holder);
        spinner.setTag(componentElement.getComponents()[1]);
        spinner.setContext(mContext);
        spinner.setComponent(componentElement.getComponents()[1], spinnerLayout);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) spinner.getLayoutParams();
        params.weight = Float.parseFloat(componentElement.getComponents()[1].getItem_weight());
        spinner.setLayoutParams(params);

        setComponentColors(componentElement, spinnerLayout);

        System.out.println("InaVerticalLabelSpinner.setComponent");

        parentLayout.addView(spinnerLayout);

    }

    public void setComponentColors(ComponentElement componentElement, LinearLayout spinnerLayout) {
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
