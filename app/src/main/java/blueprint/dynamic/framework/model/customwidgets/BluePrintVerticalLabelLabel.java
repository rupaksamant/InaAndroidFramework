package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/10/2016.
 */
public class BluePrintVerticalLabelLabel /*extends View*/ {

    private Context mContext;

    public BluePrintVerticalLabelLabel(Context context) {
//        super(context);
        mContext = context;
    }

    /*public BluePrintVerticalLabelLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public BluePrintVerticalLabelLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }*/

    public void setComponent(ComponentElement component, ViewGroup parentView, String parent_orientation) {
//        this.setId(Utils.getNextUniqueIndex());

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.vertical_label_label, parentView, true);
        view.setId(Utils.getNextUniqueIndex());

        if(component.getItem_weight() != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
            params.weight = Float.parseFloat(component.getItem_weight());
            view.setLayoutParams(params);
        }

        BluePrintTextView topText = (BluePrintTextView) view.findViewById(R.id.lable_top);
        BluePrintTextView bottomText = (BluePrintTextView) view.findViewById(R.id.lable_bottom);

//        topText.setComponent(component.getComponents()[0], view, parent_orientation);
//        bottomText.setComponent(component.getComponents()[1], view, parent_orientation);

//        parentView.addView(view);
    }
}
