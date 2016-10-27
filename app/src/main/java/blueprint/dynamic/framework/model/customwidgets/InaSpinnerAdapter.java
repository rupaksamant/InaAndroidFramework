package blueprint.dynamic.framework.model.customwidgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;

import com.dynamic.framework.R;

import java.util.ArrayList;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.utils.Constants;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/24/2016.
 */
public class InaSpinnerAdapter extends BaseAdapter implements SpinnerAdapter{

    private final ComponentElement mComponentelement;
    private Activity mContext;
    private ArrayList data;
    //    public Resources res;
//    SpinnerModel tempValues=null;
    LayoutInflater inflater;

    /*************
     * CustomAdapter Constructor
     *****************/
    public InaSpinnerAdapter(Activity context, ArrayList<String> objects, ComponentElement componentElement) {
//        super(context, textViewResourceId, objects);

        /********** Take passed values **********/
        mContext = context;
        data = objects;
        mComponentelement = componentElement;
//        res      = resLocal;

        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {
        int margin = (int) mContext.getResources().getDimension(R.dimen.dimen_5_dp);

        LinearLayout layout = new LinearLayout(mContext);

        /*LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(margin, margin, margin, margin);
        layout.setLayoutParams(params);*/

        if (mComponentelement.getComponents() != null) {
            for (ComponentElement component : mComponentelement.getComponents()) {
                addComponent(component, Constants.Orientation.HORIZONTAL, layout, data.get(position).toString());
            }
        }

//        setBackgroundColor(containerElement.getContainer_background_color(), R.color.container_defualt_color);

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
//        View row = inflater.inflate(R.layout.spinner_rows, parent, false);

        /***** Get each Model object from Arraylist ********/
        /*tempValues = null;
        tempValues = (SpinnerModel) data.get(position);

        TextView label        = (TextView)row.findViewById(R.id.company);
        TextView sub          = (TextView)row.findViewById(R.id.sub);
        ImageView companyLogo = (ImageView)row.findViewById(R.id.image);

        if(position==0){

            // Default selected Spinner item
            label.setText("Please select company");
            sub.setText("");
        }
        else
        {
            // Set values for spinner each row
            label.setText(tempValues.getCompanyName());
            sub.setText(tempValues.getUrl());
            companyLogo.setImageResource(res.getIdentifier
                    ("com.androidexample.customspinner:drawable/"
                            + tempValues.getImage(),null,null));

        }*/

        return layout;
    }

    private void addComponent(ComponentElement componentElement, String parent_orientation,
                              ViewGroup mContainer, String label) {
        if (Constants.ComponentType.TEXT_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            BluePrintTextView textView = new BluePrintTextView(mContext);
            textView.setComponent(componentElement, mContainer, parent_orientation);
            textView.setText(label);
//            expandTouchArea(mContainer, textView, 600);
        } else if (Constants.ComponentType.IMAGE_VIEW.equalsIgnoreCase(componentElement.getComponent_type())) {
            //TODO - Image view component creation
        }
    }

    public static void expandTouchArea(final View bigView, final View smallView, final int extraPadding) {
        /*bigView.post(new Runnable() {
            @Override
            public void run() {
                Rect rect = new Rect();
                smallView.getHitRect(rect);
                rect.top -= extraPadding;
                rect.left -= extraPadding;
                rect.right += extraPadding;
                rect.bottom += extraPadding;
                bigView.setTouchDelegate(new TouchDelegate(rect, smallView));
            }
        });*/

        bigView.post(new Runnable() {
            public void run() {
                // Post in the parent's message queue to make sure the parent
                // lays out its children before we call getHitRect()
                Rect delegateArea = new Rect();
//                Button delegate = mButton;
                smallView.getHitRect(delegateArea);
                delegateArea.top -= 600;
                delegateArea.bottom += 600;
                delegateArea.left -= 600;
                delegateArea.right += 600;
                TouchDelegate expandedArea = new TouchDelegate(delegateArea,
                        smallView);
                // give the delegate to an ancestor of the view we're
                // delegating the
                // area to
                if (View.class.isInstance(smallView.getParent())) {
                    ((View) smallView.getParent())
                            .setTouchDelegate(expandedArea);
                }
            };
        });
    }




    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*@Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }*/
}
