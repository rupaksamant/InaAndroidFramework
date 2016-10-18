package blueprint.dynamic.framework.ui_engine.listeners;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Techjini on 10/17/2016.
 */
public class OnSwipeTouchListener implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context c) {
        gestureDetector = new GestureDetector(c, new GestureListener());
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        System.out.println("OnSwipeTouchListener.onTouch");
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            System.out.println("GestureListener.onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onClick();
            System.out.println("GestureListener.onSingleTapUp");
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            System.out.println("GestureListener.onDoubleTap");
            onDoubleClick();
            return super.onDoubleTap(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            System.out.println("GestureListener.onLongPress");
            onLongClick();
            super.onLongPress(e);
        }

        // Determines the fling velocity and then fires the appropriate swipe event accordingly
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            System.out.println("GestureListener.onFling");
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeDown();
                        } else {
                            onSwipeUp();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return false;
        }
    }

    public void onSwipeRight() {
        System.out.println("OnSwipeTouchListener.onSwipeRight");
    }

    public void onSwipeLeft() {
        System.out.println("OnSwipeTouchListener.onSwipeLeft");
    }

    public void onSwipeUp() {
        System.out.println("OnSwipeTouchListener.onSwipeUp");
    }

    public void onSwipeDown() {
        System.out.println("OnSwipeTouchListener.onSwipeDown");
    }

    public void onClick() {
        System.out.println("OnSwipeTouchListener.onClick");
    }

    public void onDoubleClick() {
        System.out.println("OnSwipeTouchListener.onDoubleClick");
    }

    public void onLongClick() {
        System.out.println("OnSwipeTouchListener.onLongClick");
    }
}
