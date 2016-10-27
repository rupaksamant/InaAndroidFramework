package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.model.cms_model.ContainerElement;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/10/2016.
 */
public class InaContainer {
    private Context mContext;
    private ViewGroup mContainer;
    private LayoutInflater mLayoutInflater;

    public InaContainer(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void setContainer(ContainerElement containerElement, ViewGroup parentLayout, String parent_item_orientation) {

        System.out.println("BluePrintLinearContainer.setContainer contianer id---:"+ Utils.getIdFromString(mContext, containerElement.getItem_id()));

        createConcreteContainer(containerElement, parent_item_orientation);

        mContainer.setId(Utils.getIdFromString(mContext, containerElement.getItem_id()));
        setOrientationAndLayoutParams(containerElement.getItem_orientation(),
                containerElement.getItem_weight(),
                parent_item_orientation,
                containerElement.getWeight_sum());

        setBackgroundColor(containerElement.getContainer_background_color(), R.color.container_defualt_color);

        if (containerElement.getComponents() != null) {
            addComponents(containerElement.getComponents(), containerElement.getItem_orientation());
        }
        parentLayout.addView(mContainer);
        mContainer.invalidate();
    }

    private void createConcreteContainer(ContainerElement containerElement, String parent_item_orientation) {
        String type = containerElement.getContainer_type();
        if(type != null && type.isEmpty() == false) {
            if(type.equalsIgnoreCase(Constants.ContainerType.HORIZONTAL_SCROLL_LAYOUT)){
                mContainer = new HorizontalScrollView(mContext);
            } else if(type.equalsIgnoreCase(Constants.ContainerType.VERTICAL_SCROLL_LAYOUT)){
                mContainer = new ScrollView(mContext);
            } else {
                mContainer = new LinearLayout(mContext);
            }
        } else {
            mContainer = new LinearLayout(mContext);
        }
    }

    private void addComponents(ComponentElement[] components, String parent_orientation) {
        for (ComponentElement componentElement : components) {
            addComponent(componentElement, parent_orientation);
        }
    }

    private void addComponent(ComponentElement componentElement, String parent_orientation) {

        if (Constants.ComponentType.EDIT_TEXT.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(mContext);
            editText.setComponent(componentElement, mContainer);
        } else if (Constants.ComponentType.BUTTON_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintButtonView buttonView = new BluePrintButtonView(mContext);
            buttonView.setComponent(componentElement, mContainer, parent_orientation);
        } else if (Constants.ComponentType.HORIZONTAL_ICON_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(mContext);
            editText.setComponent(componentElement, mContainer);
        } else if (Constants.ComponentType.HORIZONTAL_ICON_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(mContext);
            editText.setComponent(componentElement, mContainer);
        } else if (Constants.ComponentType.VERTICAL_LABEL_SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {
            InaVerticalLabelSpinner spinner = new InaVerticalLabelSpinner(mContext);
            spinner.setComponent(componentElement, mContainer, parent_orientation);
        } else if (Constants.ComponentType.HORIZONTAL_LABEL_ICON.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentType.HORIZONTAL_LABEL_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentType.SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintSpinner spinner = new BluePrintSpinner(mContext);
            spinner.setComponent(componentElement, mContainer);
        } else if (Constants.ComponentType.TEXT_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView textView = new BluePrintTextView(mContext);
            textView.setComponent(componentElement, mContainer, parent_orientation);
        } else if (Constants.ComponentType.VERTICAL_LABEL_EDIT_TEXT.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentType.VERTICAL_LABEL_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView leftTextView = new BluePrintTextView(mContext);
            leftTextView.setComponent(componentElement, mContainer, parent_orientation);

            BluePrintTextView rightTextView = new BluePrintTextView(mContext);
            rightTextView.setComponent(componentElement, mContainer, parent_orientation);


        } else if (Constants.ComponentType.VERTICAL_LABEL_SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {

        }
    }

    private void setBackgroundColor(String background_color, int defualt_color) {
        if (background_color != null) {
            mContainer.setBackgroundColor(!background_color.isEmpty()
                    ? Color.parseColor(background_color) : ContextCompat.getColor(mContext, defualt_color));
        } else {
            mContainer.setBackgroundColor(ContextCompat.getColor(mContext, defualt_color));
        }
    }

    private void setOrientationAndLayoutParams(String orientation, String weight, String parent_item_orientation, String weight_sum) {
        int margin = (int) mContext.getResources().getDimension(R.dimen.dimen_5_dp);

        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(parent_item_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                        ViewGroup.LayoutParams.MATCH_PARENT, Float.parseFloat(weight));
                params.setMargins(margin, margin, margin, margin);
                mContainer.setLayoutParams(params);
            } else {
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                params1.setMargins(margin, margin, margin, margin);
                mContainer.setLayoutParams(params1);
            }
        } else if (Constants.Orientation.VERTICAL.equalsIgnoreCase(parent_item_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        0, Float.parseFloat(weight));
                params2.setMargins(margin, margin, margin, margin);
                mContainer.setLayoutParams(params2);
            } else {
                LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                params3.setMargins(margin, margin, margin, margin);
                mContainer.setLayoutParams(params3);
            }
        } else {
            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            params3.setMargins(margin, margin, margin, margin);
            mContainer.setLayoutParams(params3);
        }
        if(mContainer instanceof LinearLayout) {
            if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(orientation)) {
                ((LinearLayout)mContainer).setOrientation(LinearLayout.HORIZONTAL);
            } else {
                ((LinearLayout)mContainer).setOrientation(LinearLayout.VERTICAL);
            }
        }
        if (weight_sum != null && weight_sum.isEmpty() == false) {
//            mContainer.setWeightSum(Float.parseFloat(weight_sum));
        }
    }

    public ViewGroup getContainer() {
        return mContainer;
    }

}
