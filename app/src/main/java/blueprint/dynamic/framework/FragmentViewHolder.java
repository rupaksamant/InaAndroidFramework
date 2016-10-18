package blueprint.dynamic.framework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import blueprint.dynamic.framework.model.cms_model.RootCms;
import blueprint.dynamic.framework.ui_engine.ScreenGenerator;
import blueprint.dynamic.framework.ui_engine.listeners.OnSwipeTouchListener;
import blueprint.dynamic.framework.utils.AppUtils;

/**
 * Created by Techjini on 10/6/2016.
 */
public class FragmentViewHolder extends Fragment {

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
        String cmsString = AppUtils.readJsonFromAssets("cms.json", mActivity);
        if(cmsString != null && cmsString.isEmpty() == false) {
            RootCms config = AppUtils.stringToCMSJSON(cmsString);
            ScreenGenerator.getInstance(mActivity).createScreen(config.getScreens()[1], mParentLayout, listener);
        }
    }

    public void updateUi(String json) {
        if( json!= null && json.isEmpty() == false) {
            RootCms config = AppUtils.stringToCMSJSON(json);
            mParentLayout.removeAllViews();
            ScreenGenerator.getInstance(mActivity).createScreen(config.getScreens()[1], mParentLayout, listener);
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
}
