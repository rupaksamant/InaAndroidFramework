package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.AppUtils;

/**
 * Created by Techjini on 10/10/2016.
 */
public class BluePrintSpinner  extends AppCompatSpinner {

    public BluePrintSpinner(Context context) {
        super(context);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BluePrintSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BluePrintSpinner(Context context, int mode) {
        super(context, mode);
    }

    public void setComponent(ComponentElement component, ViewGroup parentLayout) {
        this.setId(AppUtils.getNextUniqueIndex());
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.blueprint_spinner_item, component.getComponent_data());
        setAdapter(spinnerArrayAdapter);
        setSelection(0);
        parentLayout.addView(this);
    }
}
