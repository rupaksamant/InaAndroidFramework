package blueprint.dynamic.framework.model.customwidgets;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Techjini on 11/3/2016.
 */
public class VerticalViewItemDecorator extends RecyclerView.ItemDecoration {
    private final int mVerticalSpaceHeight;

    public VerticalViewItemDecorator(int mVerticalSpaceHeight) {
        this.mVerticalSpaceHeight = mVerticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = mVerticalSpaceHeight;
    }
}
