package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/10/2016.
 */
public class InaVerticalLabelLabel {

    private ViewGroup mParentView;
    private Context mContext;

    public InaVerticalLabelLabel(Context context) {
        mContext = context;
        mParentView = (ViewGroup) Utils.getLayoutInflater(mContext).inflate(R.layout.vertical_label_label, null);
    }

    public void setComponent(ComponentElement parentComponent, ViewGroup container) {

        setPropertyOfParent(parentComponent);

        setPropertyOfChildComponents(parentComponent);

        container.addView(mParentView);
    }

    public void setPropertyOfParent(ComponentElement componentElement) {

        LinearLayout linearLayout = (LinearLayout) mParentView.findViewById(R.id.vertical_label_label_parent);

        InaContainer.setBackgroundColor(mParentView, mContext, componentElement.getComponent_background_color(), R.color.container_defualt_color);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if(params == null) {
            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        if(componentElement.getItem_weight() != null) {
            params.weight = Float.parseFloat(componentElement.getItem_weight());
        }
        linearLayout.setLayoutParams(params);
    }

    public void setPropertyOfChildComponents(ComponentElement parentComponent) {

        ComponentElement[] componentElements = parentComponent.getComponents();

        BluePrintTextView topLabel = (BluePrintTextView) mParentView.findViewById(R.id.label_top);
        BluePrintTextView bottomLabel = (BluePrintTextView) mParentView.findViewById(R.id.label_bottom);

        ComponentElement leftComponent = componentElements[0];
        ComponentElement rightComponent = componentElements[1];

        topLabel.setContext(mContext);
        topLabel.setComponent(leftComponent, mParentView, Constants.Orientation.VERTICAL, false);

        topLabel.setTag(leftComponent);

        bottomLabel.setContext(mContext);
        bottomLabel.setComponent(rightComponent, mParentView, Constants.Orientation.VERTICAL, false);

        bottomLabel.setTag(rightComponent);
    }
}
