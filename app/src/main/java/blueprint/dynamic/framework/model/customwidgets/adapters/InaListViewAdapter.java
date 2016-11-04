package blueprint.dynamic.framework.model.customwidgets.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dynamic.framework.R;

import java.util.ArrayList;
import java.util.Date;

import blueprint.dynamic.framework.model.cms_model.ContainerElement;
import blueprint.dynamic.framework.ui_engine.ScreenGenerator;
import blueprint.dynamic.framework.ui_engine.listeners.ListItemClickListener;
import blueprint.dynamic.framework.utils.Constants;

import static android.databinding.DataBindingUtil.inflate;

/**
 * Created by Techjini on 11/3/2016.
 */

public class InaListViewAdapter extends RecyclerView.Adapter<InaListViewAdapter.CustomViewHolder>{

    private Context mContext;
    private ArrayList<?> mListData;
//    private Component_list_header_fieldElement[] mViewComponents;
    private ListItemClickListener mListItemClickListener;
    private ContainerElement mContainerElement;

    public InaListViewAdapter(Context context, ContainerElement containerElement) {
        mContext = context;
        setHasStableIds(true);
        mContainerElement = containerElement;
    }

    public void setData(ArrayList<?> list) {
        mListData = list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*OverdueRowBinding binder = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.list_vew_row_item, parent, false);
        return new CustomViewHolder(binder);*/
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = (View) inflater.inflate(R.layout.list_vew_row_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if(mListData != null && mListData.size() > 0) {
            ContainerElement[] containerElements = mContainerElement.getContainer();
            if(containerElements != null){
//                for (ContainerElement container)
                ScreenGenerator.createContainers(containerElements, holder.mView, Constants.Orientation.VERTICAL);
            }
        }
        /*DBTableRecordModel data = mItems.get(position);
        if(mViewComponents!= null && mViewComponents.length > 0 && data != null && data.dbTableItemModels.size()> 0) {
            LinearLayout.LayoutParams marginRightLinearParams = new LinearLayout.LayoutParams(((int)Utils.pxTodp((Activity) mContext,OverDueView.minimumWidthForOneColumn)), ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams marginTopLinearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.binder.overdueRow.removeAllViews();
            for (Component_list_header_fieldElement view: mViewComponents) {
                Component_childElement[] children = view.getComponent_children();
                if (children != null && children.length > 0) {
//                    marginRightLinearParams.setMargins(0, 0, (int) mContext.getResources().getDimension(R.dimen.dimen_20_dp), 0);
                    marginTopLinearParams.setMargins(0, (int) mContext.getResources().getDimension(R.dimen.dimen_14_dp), 0, 0);
                }

                switch (view.getComponent_type().toLowerCase()) {
                    case Constants.Screen2Sections.VERTICAL_LABEL_VALUE:
                        LabelValueBinding mLabelViewBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.label_value, null, false);
                        mLabelViewBinding.getRoot().setMinimumWidth(OverDueView.minimumWidthForOneColumn);
                        mLabelViewBinding.getRoot().setLayoutParams(marginRightLinearParams);
                        mLabelViewBinding.value.setLayoutParams(marginTopLinearParams);
                        mLabelViewBinding.getRoot().setPadding(0, 0, (int) mContext.getResources().getDimension(R.dimen.dimen_20_dp), 0);

                        if (children != null && children.length > 0) {
                            if (children[0] != null && children[0].getComponent_type().toLowerCase().equalsIgnoreCase(Constants.Screen2Sections.TEXT_VIEW)) {
                                mLabelViewBinding.label.setText(children[0].getComponent_label());
                            }
                            if (children[1] != null && children[1].getComponent_type().toLowerCase().equalsIgnoreCase(Constants.Screen2Sections.TEXT_VIEW)) {
                                mLabelViewBinding.label.setText(children[0].getComponent_label());
                                for (DBTableItemModel record: data.dbTableItemModels) {
                                    if(record.getColoumName().toLowerCase().equalsIgnoreCase(children[1].getComponent_key_name())) {
                                        mLabelViewBinding.value.setMaxLines(1);
                                        if(children[1].getComponent_format()!= null && children[1].getComponent_format().toLowerCase().contains(Constants.ConstantValues.DATE)) {
                                            Date date = TimeUtils.stringToDate(record.getValue(), Constants.DateTimeFormats.DATE_TIME_FORMAT_FROM_DB);
                                            if(date != null) {
                                                mLabelViewBinding.value.setText(TimeUtils.getDateFormattedToSystemFormat(mContext,date));
                                            }
                                        } else {
                                            mLabelViewBinding.value.setText(Utils.truncateText(record.getValue()));
                                        }
                                    }
                                }
                            }
                        }
                        holder.binder.overdueRow.addView(mLabelViewBinding.getRoot());
                        holder.binder.getRoot().setTag(data);
                        break;
                    default:
                        break;
                }

            }
        }*/
    }

    @Override
    public int getItemCount() {
        if (mListData != null) {
            return mListData.size();
        } else {
            return 0;
        }
    }

    /*public void setCMS(Component_list_header_fieldElement[] headerFields) {
        mViewComponents = headerFields;
    }*/

    public void setListener(ListItemClickListener listItemClickListener) {
        mListItemClickListener = listItemClickListener;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ViewGroup mView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            mView = (ViewGroup) itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListItemClickListener.onItemClick(view);
        }

        /*private ListViewRowItemBin binder;

        public CustomViewHolder(OverdueRowBinding binder) {
            super(binder.getRoot());
            this.binder = binder;
            this.binder.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            DBTableRecordModel data = (DBTableRecordModel)v.getTag();
            Logger.v("CustomviewHolder Overdue Adapter", data.toString());
            ((HomeScreenActivity)mContext).callFieldVisitDetailsFragment(data,true);
            mListItemClickListener.onItemClick();
        }*/
    }
}
