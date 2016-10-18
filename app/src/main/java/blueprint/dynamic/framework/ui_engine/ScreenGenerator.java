package blueprint.dynamic.framework.ui_engine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import blueprint.dynamic.framework.model.cms_model.ContainerElement;
import blueprint.dynamic.framework.model.cms_model.ScreenElement;
import blueprint.dynamic.framework.model.customwidgets.BluePrintLinearContainer;
import blueprint.dynamic.framework.ui_engine.listeners.OnSwipeTouchListener;
import blueprint.dynamic.framework.utils.Constants;

/**
 * Created by Techjini on 10/6/2016.
 */
public class ScreenGenerator {
    private static ScreenGenerator sInstance;
    private static Context mContext;

    private ScreenGenerator(Context context) {
        mContext = context;
    }

    public static ScreenGenerator getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ScreenGenerator.class) {
                if (sInstance == null) {
                    sInstance = new ScreenGenerator(context);
                }
            }
        }
        return sInstance;
    }

    public View createScreen(ScreenElement screenElement, ViewGroup mParentLayout, OnSwipeTouchListener listener) {
        String screenType = screenElement.getScreen_type();
        if (screenType.equalsIgnoreCase(Constants.ScreenType.GENERAL_SCREEN)) {
            createGeneralScreen(screenElement, mParentLayout, listener);
        } else if (screenType.equalsIgnoreCase(Constants.ScreenType.NAVIGATION_DRAWER)) {

        } else if (screenType.equalsIgnoreCase(Constants.ScreenType.POPUP)) {

        } else if (screenType.equalsIgnoreCase(Constants.ScreenType.RIGHT_MENU)) {

        }
        mParentLayout.invalidate();
        return mParentLayout;
    }

    private void createGeneralScreen(ScreenElement screenElement, ViewGroup mParentLayout, OnSwipeTouchListener listener) {
        ContainerElement[] containerElement = screenElement.getContainer();
        createContainers(containerElement, mParentLayout, screenElement.getItem_orientation(), listener);

    }

    public void createContainers(ContainerElement[] containerElements, ViewGroup mParentLayout, String parent_item_orientation, OnSwipeTouchListener listener) {
        for (ContainerElement containerElement : containerElements) {
//            LinearLayout containerLayout = new LinearLayout(mContext);
            if(Constants.ContainerTypes.TOOLBAR.equalsIgnoreCase(containerElement.getContainer_name())) {
                BluePrintLinearContainer containerLayout = new BluePrintLinearContainer(mContext);
                /*containerLayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        System.out.println("ScreenGenerator.onTouch---"+view.getId());
                        return false;
                    }
                });*/
//                containerLayout.setClickable(true);
                if (containerElement.getContainer() != null) {
                    createContainers(containerElement.getContainer(), containerLayout, containerElement.getItem_orientation(), listener);
                }
                containerLayout.setComponent(containerElement, mParentLayout, parent_item_orientation, listener);
                mParentLayout.invalidate();

            } else /*if(Constants.ContainerTypes.CONTAINER_CONTENT.equalsIgnoreCase(containerElement.getContainer_name()))*/{
                BluePrintLinearContainer containerLayout = new BluePrintLinearContainer(mContext);

                if (containerElement.getContainer() != null) {
                    createContainers(containerElement.getContainer(), containerLayout, containerElement.getItem_orientation(), listener);
                }
                containerLayout.setComponent(containerElement, mParentLayout, parent_item_orientation, listener);
                mParentLayout.invalidate();
//                mParentLayout.addView(containerLayout);
            }
        }
    }

    /*private void addComponents(ViewGroup containerLayout, ComponentElement[] components) {
        for (ComponentElement componentElement : components) {

        }

    }*/

    /*private void setOrientationAndLayoutParams(String orientation, String weight, LinearLayout containerLayout) {
        if (Constants.Orientation.HORIZONTAL.equalsIgnoreCase(orientation)) {
            containerLayout.setOrientation(LinearLayout.HORIZONTAL);
            if(weight != null && weight.isEmpty() == false) {
                containerLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        ViewGroup.LayoutParams.MATCH_PARENT, Integer.parseInt(weight)));
            } else {
                containerLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
            }
        } else if(Constants.Orientation.VERTICAL.equalsIgnoreCase(orientation)) {
            containerLayout.setOrientation(LinearLayout.VERTICAL);
            if(weight != null &&  weight.isEmpty() == false) {
                containerLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        0, Integer.parseInt(weight)));
            } else {
                containerLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
            }
        }
    }*/

    /*private void setBackgroundColor(View view, String background_color, int defualt_color) {
        if (background_color != null) {
            view.setBackgroundColor(!background_color.isEmpty()
                    ? Color.parseColor(background_color) : ContextCompat.getColor(mContext, defualt_color));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(mContext, defualt_color));
        }
    }*/

    /*private int getScreenType(String screen_type) {
        if (screen_type.equalsIgnoreCase(Constants.ScreenType.right_menu.toString())) {
            return Constants.ScreenType.right_menu.getValue();
        } else if (screen_type.equalsIgnoreCase(Constants.ScreenType.navigation_drawer.toString())) {
            return Constants.ScreenType.navigation_drawer.getValue();
        } else if (screen_type.equalsIgnoreCase(Constants.ScreenType.popup.toString())) {
            return Constants.ScreenType.popup.getValue();
        } else {
            return Constants.ScreenType.general_screen.getValue();
        }
    }*/
}
