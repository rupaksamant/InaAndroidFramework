package blueprint.dynamic.framework;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dynamic.framework.R;

import java.util.ArrayList;
import java.util.Arrays;

import blueprint.dynamic.framework.model.cms_model.ComponentElement;
import blueprint.dynamic.framework.model.cms_model.RootCms;
import blueprint.dynamic.framework.model.customwidgets.BluePrintSpinner;
import blueprint.dynamic.framework.model.customwidgets.adapters.InaSpinnerAdapter;
import blueprint.dynamic.framework.ui_engine.ScreenGenerator;
import blueprint.dynamic.framework.ui_engine.listeners.OnSwipeTouchListener;
import blueprint.dynamic.framework.utils.Utils;

/**
 * Created by Techjini on 10/6/2016.
 */
public class FragmentViewHolder extends Fragment implements AdapterView.OnItemSelectedListener{

    private View mRootView;
    private LinearLayout mParentLayout;
    private Activity mActivity;

    public FragmentViewHolder() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_view_holder, container, false);
        mParentLayout = (LinearLayout) mRootView.findViewById(R.id.view_holder);
//        final Button testButton = (Button) mRootView.findViewById(R.id.test_button);
//        testButton.setOnTouchListener(new OnSwipeTouchListener(mActivity));
        initViewFromConfig(mParentLayout);
        return mRootView;
    }

    private void initViewFromConfig(LinearLayout mParentLayout) {
        String cmsString = Utils.readJsonFromAssets("cms.json", mActivity);
        if(cmsString != null && cmsString.isEmpty() == false) {
            RootCms config = Utils.stringToCMSJSON(cmsString);
            ScreenGenerator.getInstance(mActivity).createScreen(config.getApplication().getScreens()[1], mParentLayout, listener);
        }

        /*BluePrintButtonView buttonView = (BluePrintButtonView) mParentLayout.findViewById(
                mActivity.getResources().getIdentifier("31",  "id", mActivity.getPackageName()));
        System.out.println("text set to view---"+buttonView.getText() + ":---:"+buttonView.getId());*/

        BluePrintSpinner spinner = (BluePrintSpinner) mParentLayout.findViewById(
                mActivity.getResources().getIdentifier("103",  "id", mActivity.getPackageName()));
        if(spinner != null) {
//            ArrayList<String> data = new ArrayList<>(Arrays.asList(spinnerDataArray));
            ComponentElement componentElement = (ComponentElement) spinner.getTag();
            spinnerData = componentElement.getComponents()[0].getItem_data();
            ArrayList<String> data = new ArrayList<>(Arrays.asList(spinnerData));
//            InaSpinnerAdapter spinnerAdapter = new InaSpinnerAdapter(mActivity, data, componentElement);
//        spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(this);
            ArrayAdapter adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_spinner_dropdown_item, spinnerData);
            spinner.setAdapter(adapter);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setPrompt(componentElement.getComponents()[0].getItem_title());
        }
    }

    public void updateUi(String json) {
        if( json!= null && json.isEmpty() == false) {
            RootCms config = Utils.stringToCMSJSON(json);
            mParentLayout.removeAllViews();
            ScreenGenerator.getInstance(mActivity).createScreen(config.getApplication().getScreens()[1], mParentLayout, listener);
            Utils.removeProgressDialog();
        }
        BluePrintSpinner spinner = (BluePrintSpinner) mParentLayout.findViewById(
                mActivity.getResources().getIdentifier("103",  "id", mActivity.getPackageName()));
        if(spinner != null) {
            ComponentElement componentElement = (ComponentElement) spinner.getTag();
            spinnerData = componentElement.getComponents()[0].getItem_data();
            ArrayList<String> data = new ArrayList<>(Arrays.asList(spinnerDataArray));
            InaSpinnerAdapter spinnerAdapter = new InaSpinnerAdapter(mActivity, data, (ComponentElement) spinner.getTag());
//        spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(this);
            ArrayAdapter adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_spinner_dropdown_item, spinnerData);
            spinner.setAdapter(adapter);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setPrompt(componentElement.getComponents()[0].getItem_title());
        }
    }

    private OnSwipeTouchListener listener = new OnSwipeTouchListener(mActivity) {
        public void onSwipeRight() {
            System.out.println("FragmentViewHolder.onSwipeRight");
        }

        public void onSwipeLeft() {
            System.out.println("FragmentViewHolder.onSwipeLeft");
        }

        public void onSwipeUp() {
            System.out.println("FragmentViewHolder.onSwipeUp");
        }

        public void onSwipeDown() {
            System.out.println("FragmentViewHolder.onSwipeDown");
        }

        public void onClick() {
            System.out.println("FragmentViewHolder.onClick");
        }

        public void onDoubleClick() {
            System.out.println("FragmentViewHolder.onDoubleClick");
        }

        public void onLongClick() {
            System.out.println("FragmentViewHolder.onLongClick");
        }
    };


    String[] spinnerDataArray = {"1996","1997","1998","1999", "2000"};

    String [] spinnerData;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println("FragmentViewHolder.onItemSelected--------:" + spinnerData[i]);
        Toast.makeText(mActivity, "Clicked ---"+spinnerData[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        System.out.println("FragmentViewHolder.onNothingSelected");
        Toast.makeText(mActivity, "Nothing selected", Toast.LENGTH_SHORT).show();
    }
}
