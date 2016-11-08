package blueprint.dynamic.framework.model.customwidgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.ui_engine.ComponentHelper;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 11/8/2016.
 */

public class InaImageView extends AppCompatImageView {
    private Context mContext;
    private ComponentElement image;

    public InaImageView(Context context) {
        super(context);
        mContext = context;
    }

    public InaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public InaImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void setComponent(ComponentElement componentElement, ViewGroup parentLayout,
                             String parent_orientation, boolean addToParent) {

        this.setId(Utils.getIdFromString(mContext, componentElement.getItem_id()));

        int defaultHeight = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.IAMGE_VIEW_HEIGHT);
        int defaultWidth = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.IAMGE_VIEW_WIDTH);
        int defaultMargin = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.IAMGE_VIEW_MARGIN);
        int defaultPadding = Utils.pxTodp(((Activity) mContext), Constants.DefaultValue.IAMGE_VIEW_PADDING);

        setImage(componentElement);

        ComponentHelper.setLayoutParamsAndOrientation(mContext,
                this,
                componentElement,
                parent_orientation,
                defaultHeight,
                defaultWidth,
                defaultMargin,
                defaultPadding
        );

        setComponentColors(componentElement);

        if (addToParent && parentLayout != null) {
            parentLayout.addView(this);
        }
    }

    public void setComponentColors(ComponentElement componentElement) {
//        setClickable(true);

        if (componentElement.getComponent_border_color() != null) {
            if (componentElement.getComponent_border_color().isEmpty()) {
                if (componentElement.getComponent_background_color() != null) {
                    setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
                }
            } else {
                if (componentElement.getComponent_background_color() != null) {
                    setBackground(ContextCompat.getDrawable(mContext, R.drawable.layerlist_rounded_rect_ffffff_6eacda_stroke));
                    GradientDrawable drawable1 = Utils.getGradientDrawable(mContext, !componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100),
                            !componentElement.getComponent_border_color().isEmpty()
                                    ? Color.parseColor(componentElement.getComponent_border_color())
                                    : ContextCompat.getColor(mContext, R.color.color_36415D), this);
                    setBackgroundDrawable(drawable1);
                }
            }
        } else if (componentElement.getComponent_background_color() != null) {
            setBackgroundColor(!componentElement.getComponent_background_color().isEmpty() ? Color.parseColor(componentElement.getComponent_background_color()) : ContextCompat.getColor(mContext, R.color.color_000000_100));
        }
    }

    public void setImage(ComponentElement componentElement) {
        String uri = "@drawable/" + componentElement.getComponent_icon();  // where myresource (without the extension) is the file

        int imageId = getResources().getIdentifier(uri, null, mContext.getPackageName());

        try {
            Drawable res = getResources().getDrawable(imageId);
            if (res != null) {
                this.setImageDrawable(res);
            }
        }catch (Exception e){
            Toast.makeText(mContext, "InaImageView.setImage---image not found---:"+e.getLocalizedMessage() + ":---id---:"+imageId, Toast.LENGTH_SHORT);
        }
    }
}
