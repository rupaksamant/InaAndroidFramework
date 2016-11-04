package blueprint.dynamic.framework.model.customwidgets;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dynamic.framework.R;
//import com.dynamic.framework.databinding.ListViewBinding;

import java.util.ArrayList;

import blueprint.dynamic.framework.model.cms_model.ContainerElement;
import blueprint.dynamic.framework.ui_engine.listeners.ListItemClickListener;

/**
 * Created by Techjini on 11/3/2016.
 */

public class InaListView implements ListItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<?> mListData;
    private Context mContext;
//    private ListViewBinding mBinding;
    private ContainerElement mContainerElement;
    private ViewGroup mRootView;
    private RecyclerView mListRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    public InaListView(Context context) {
        mContext = context;
        /*mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.list_view, null, false);
        mBinding.listRecyclerViewContent.setLayoutManager(new LinearLayoutManager(mContext));
        mBinding.listRecyclerViewContent.addItemDecoration(new VerticalViewItemDecorator(2));

        // By Default swipe refresh layout is disabled.
        mBinding.listSwipeRefreshLayout.setEnabled(false);*/

        LayoutInflater inflater = LayoutInflater.from(context);
        mRootView = (ViewGroup) inflater.inflate(R.layout.list_view, null);

        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.list_swipeRefreshLayout);
        mSwipeRefreshLayout.setEnabled(false);

        mListRecyclerView = (RecyclerView) mRootView.findViewById(R.id.list_recycler_view_content);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mListRecyclerView.addItemDecoration(new VerticalViewItemDecorator(2));
    }

    public ViewGroup getRootView() {
//        return (ViewGroup) mBinding.getRoot();
        return mRootView;
    }

    public void setComponent(ContainerElement containerElement) {
        mContainerElement = containerElement;
        mRootView.setTag(mContainerElement);
//        InaContainer.
//        setAdapter();
    }

    private void setAdapter() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(View view) {

    }
}
