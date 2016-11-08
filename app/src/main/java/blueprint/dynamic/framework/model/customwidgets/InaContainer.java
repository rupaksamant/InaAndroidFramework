package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
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

        System.out.println("BluePrintLinearContainer.setContainer contianer id---:" + Utils.getIdFromString(mContext, containerElement.getItem_id()));

        createConcreteContainer(containerElement, parent_item_orientation);

        mContainer.setId(Utils.getIdFromString(mContext, containerElement.getItem_id()));

        setOrientationAndLayoutParams(containerElement.getItem_orientation(),
                containerElement.getItem_weight(),
                parent_item_orientation,
                containerElement.getWeight_sum());

        setBackgroundColor(mContainer, mContext, containerElement.getContainer_background_color(), R.color.container_defualt_color);

        if (containerElement.getContainer_type() == Constants.ContainerType.LIST_LAYOUT) {
            // List container should not contian any direct child component instead it should wrapped with contianer
            // just for precaution this check
            // do nothing if it contians direct child component
            // and the JSON structure should include the child component within a contianer of type ADAPTER_ITEM_LAYOUT
        } else if (containerElement.getComponents() != null) {
            addComponents(containerElement.getComponents(), containerElement.getItem_orientation(), mContainer);
        }

        parentLayout.addView(mContainer);
        mContainer.invalidate();
    }

    private void createConcreteContainer(ContainerElement containerElement, String parent_item_orientation) {
        String type = containerElement.getContainer_type();
        if (type != null && type.isEmpty() == false) {
            if (type.equalsIgnoreCase(Constants.ContainerType.HORIZONTAL_SCROLL_LAYOUT)) {
                mContainer = new HorizontalScrollView(mContext);
            } else if (type.equalsIgnoreCase(Constants.ContainerType.VERTICAL_SCROLL_LAYOUT)) {
                mContainer = new ScrollView(mContext);
            } else if (type.equalsIgnoreCase(Constants.ContainerType.LIST_LAYOUT)) {
                InaListView listView = new InaListView(mContext);
                mContainer = listView.getRootView();
                listView.setComponent(containerElement);
            } else {
                mContainer = new LinearLayout(mContext);
            }
        } else {
            mContainer = new LinearLayout(mContext);
        }
    }

    private void addComponents(ComponentElement[] components, String parent_orientation, ViewGroup mContainer) {
        for (ComponentElement componentElement : components) {
            addComponent(mContext, componentElement, parent_orientation, mContainer);
        }
    }

    public static void addComponent(Context context, ComponentElement componentElement, String parent_orientation, ViewGroup container) {

        if (Constants.ComponentType.EDIT_TEXT.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(context);
            editText.setComponent(componentElement, container);
        } else if (Constants.ComponentType.BUTTON_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintButtonView buttonView = new BluePrintButtonView(context);
            buttonView.setComponent(componentElement, container, parent_orientation);
        } else if (Constants.ComponentType.IMAGE_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            InaImageView iamgeView = new InaImageView(context);
            iamgeView.setComponent(componentElement, container, parent_orientation, true);
        } else if (Constants.ComponentType.HORIZONTAL_ICON_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(context);
            editText.setComponent(componentElement, container);
        } else if (Constants.ComponentType.HORIZONTAL_ICON_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintEditText editText = new BluePrintEditText(context);
            editText.setComponent(componentElement, container);
        } else if (Constants.ComponentType.VERTICAL_LABEL_SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {
            InaVerticalLabelSpinner spinner = new InaVerticalLabelSpinner(context);
            spinner.setComponent(componentElement, container, parent_orientation);
        } else if (Constants.ComponentType.HORIZONTAL_LABEL_ICON.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentType.HORIZONTAL_LABEL_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentType.SPINNER.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintSpinner spinner = new BluePrintSpinner(context);
            spinner.setComponent(componentElement, container, parent_orientation, true);
        } else if (Constants.ComponentType.TEXT_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView textView = new BluePrintTextView(context);
            textView.setComponent(componentElement, container, parent_orientation, true);
        } else if (Constants.ComponentType.VERTICAL_LABEL_EDIT_TEXT.equalsIgnoreCase(componentElement.getComponent_type())) {

        } else if (Constants.ComponentType.VERTICAL_LABEL_LABEL.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView leftTextView = new BluePrintTextView(context);
            leftTextView.setComponent(componentElement, container, parent_orientation, true);

            BluePrintTextView rightTextView = new BluePrintTextView(context);
            rightTextView.setComponent(componentElement, container, parent_orientation, true);
        }
    }

    public static void setBackgroundColor(ViewGroup container, Context context, String background_color, int defualt_color) {
        if (background_color != null) {
            container.setBackgroundColor(!background_color.isEmpty()
                    ? Color.parseColor(background_color) : ContextCompat.getColor(context, defualt_color));
        } else {
            container.setBackgroundColor(ContextCompat.getColor(context, defualt_color));
        }
    }

    private void setOrientationAndLayoutParams(String orientation, String weight, String parent_item_orientation, String weight_sum) {
        int margin = (int) mContext.getResources().getDimension(R.dimen.dimen_5_dp);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mContainer.getLayoutParams();
        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(parent_item_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                params = new LinearLayout.LayoutParams(0,
                        ViewGroup.LayoutParams.MATCH_PARENT, Float.parseFloat(weight));
                params.setMargins(margin, margin, margin, margin);
                mContainer.setLayoutParams(params);
            } else {
                params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
//                params.setMargins(margin, margin, margin, margin);
//                mContainer.setLayoutParams(params);
            }
        } else if (Constants.Orientation.VERTICAL.equalsIgnoreCase(parent_item_orientation)) {
            if (weight != null && weight.isEmpty() == false) {
                params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        0, Float.parseFloat(weight));
//                params.setMargins(margin, margin, margin, margin);
//                mContainer.setLayoutParams(params);
            } else {
                params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
//                params.setMargins(margin, margin, margin, margin);
//                mContainer.setLayoutParams(params);
            }
        } else {
            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
//            params.setMargins(margin, margin, margin, margin);
//            mContainer.setLayoutParams(params);
        }

        params.setMargins(margin, margin, margin, margin);
        params.gravity = (Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        mContainer.setLayoutParams(params);
        if (mContainer instanceof LinearLayout) {
            if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(orientation)) {
                ((LinearLayout) mContainer).setOrientation(LinearLayout.HORIZONTAL);
            } else {
                ((LinearLayout) mContainer).setOrientation(LinearLayout.VERTICAL);
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
