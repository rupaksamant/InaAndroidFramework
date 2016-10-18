package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.model.cms_model.ContainerElement;
import blueprint.dynamic.framework.ui_engine.listeners.OnSwipeTouchListener;
import blueprint.dynamic.framework.utils.AppUtils;
import blueprint.dynamic.framework.utils.Constants;

/**
 * Created by Techjini on 10/10/2016.
 */
public class BluePrintLinearContainer extends LinearLayout {
    private Context mContext;
    private View view;

    public BluePrintLinearContainer(Context context) {
        super(context);
        mContext = context;
        view = this;
    }

    public BluePrintLinearContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        view = this;
    }

    public BluePrintLinearContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        view = this;
    }

    public void setComponent(ContainerElement containerElement, ViewGroup parentLayout, String parent_item_orientation, OnSwipeTouchListener listener) {
        this.setId(AppUtils.getNextUniqueIndex());
        setClickable(true);
        setOrientationAndLayoutParams(containerElement.getItem_orientation(),
                containerElement.getItem_weight(),
                parent_item_orientation,
                containerElement.getWeight_sum());

        setBackgroundColor(containerElement.getContainer_background_color(), R.color.container_defualt_color);

        if (containerElement.getComponents() != null) {
            addComponents(containerElement.getComponents(), containerElement.getItem_orientation(), listener);
        }
        this.setOnTouchListener(listener);
        parentLayout.addView(this);
        this.invalidate();
    }

    private void addComponents(ComponentElement[] components, String parent_orientation, OnSwipeTouchListener listener) {
        /*if(components != null && components.length > 0) {
            
        }*/
        for (ComponentElement componentElement : components) {
            addComponent(componentElement, parent_orientation, listener);
        }
    }

    private void addComponent(ComponentElement componentElement, String parent_orientation, OnSwipeTouchListener listener) {

        if (Constants.ComponentId.EDIT_TEXT.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(mContext);
            editText.setComponent(componentElement, this);
        } else if (Constants.ComponentId.BUTTON_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintButtonView buttonView = new BluePrintButtonView(mContext);
            buttonView.setComponent(componentElement, this, parent_orientation, listener);
        } else if (Constants.ComponentId.HORIZONTAL_ICON_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(mContext);
            editText.setComponent(componentElement, this);
        } else if (Constants.ComponentId.HORIZONTAL_ICON_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(mContext);
            editText.setComponent(componentElement, this);
        } else if (Constants.ComponentId.HORIZONTAL_LABEL_ICON.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentId.HORIZONTAL_LABEL_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentId.SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintSpinner spinner = new BluePrintSpinner(mContext);
            spinner.setComponent(componentElement, this);
        } else if (Constants.ComponentId.TEXT_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView textView = new BluePrintTextView(mContext);
            textView.setComponent(componentElement, this, parent_orientation, listener);
        } else if (Constants.ComponentId.VERTICAL_LABEL_EDIT_TEXT.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentId.VERTICAL_LABEL_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView leftTextView = new BluePrintTextView(mContext);
            leftTextView.setComponent(componentElement, this, parent_orientation, listener);

            BluePrintTextView rightTextView = new BluePrintTextView(mContext);
            rightTextView.setComponent(componentElement, this, parent_orientation, listener);


        } else if (Constants.ComponentId.VERTICAL_LABEL_SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {

        }
    }

    private void setBackgroundColor(String background_color, int defualt_color) {
        if (background_color != null) {
            view.setBackgroundColor(!background_color.isEmpty()
                    ? Color.parseColor(background_color) : ContextCompat.getColor(mContext, defualt_color));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(mContext, defualt_color));
        }
    }

    private void setOrientationAndLayoutParams(String orientation, String weight, String parent_item_orientation, String weight_sum) {
        int margin = (int) mContext.getResources().getDimension(R.dimen.dimen_5_dp);

        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(parent_item_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                        ViewGroup.LayoutParams.MATCH_PARENT, Float.parseFloat(weight));
                params.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params);
            } else {
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                params1.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params1);
            }
        } else if (Constants.Orientation.VERTICAL.equalsIgnoreCase(parent_item_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        0, Float.parseFloat(weight));
                params2.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params2);
            } else {
                LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                params3.setMargins(margin, margin, margin, margin);
                this.setLayoutParams(params3);
            }
        }

        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(orientation)) {
            this.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            this.setOrientation(LinearLayout.VERTICAL);
        }
        if (weight_sum != null && weight_sum.isEmpty() == false) {
//            this.setWeightSum(Float.parseFloat(weight_sum));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("BluePrintLinearContainer.onTouchEvent");
        return super.onTouchEvent(event);
    }
}
