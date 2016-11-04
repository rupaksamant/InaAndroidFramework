package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 11/4/2016.
 */

public class InaHorizontalLabelLabel {
    private ViewGroup mParentView;
    private Context mContext;
//    private ComponentElement propertyOfParent;

    public InaHorizontalLabelLabel(Context context) {
        mContext = context;
        mParentView = (ViewGroup) Utils.getLayoutInflater(mContext).inflate(R.layout.horizontal_label_label, null);
    }

    public void setComponent(ComponentElement parentComponent, ViewGroup container) {

        setPropertyOfParent(parentComponent);

        setPropertyOfChildComponents(parentComponent);

        container.addView(mParentView);
    }

    public void setPropertyOfParent(ComponentElement parentComponent) {

        LinearLayout linearLayout = (LinearLayout) mParentView.findViewById(R.id.horizontal_label_label_parent);

        InaContainer.setBackgroundColor(mParentView, mContext, parentComponent.getComponent_background_color(), R.color.container_defualt_color);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        params.weight = Float.parseFloat(parentComponent.getItem_weight());
        linearLayout.setLayoutParams(params);
    }

    public void setPropertyOfChildComponents(ComponentElement parentComponent) {

        ComponentElement[] componentElements = parentComponent.getComponents();

        BluePrintTextView leftLabel = (BluePrintTextView) mParentView.findViewById(R.id.left_label);
        BluePrintTextView rightLabel = (BluePrintTextView) mParentView.findViewById(R.id.right_label);

        ComponentElement leftComponent = componentElements[0];
        ComponentElement rightComponent = componentElements[1];

        leftLabel.setContext(mContext);
        leftLabel.setComponent(leftComponent, mParentView, Constants.Orientation.HORIZONTAL, false);

        leftLabel.setTag(leftComponent);

        rightLabel.setContext(mContext);
        rightLabel.setComponent(rightComponent, mParentView, Constants.Orientation.HORIZONTAL, false);

        rightLabel.setTag(rightComponent);
    }


}
