package com.luckycode.flexibleadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.luckycode.flexibleadapter.SubItem.SubItemViewHolder;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by marcelocuevas on 4/24/18.
 */

public class SubItem extends AbstractSectionableItem<SubItemViewHolder,HeaderView>
//        AbstractFlexibleItem<SubItemViewHolder>{
{


    public SubItem(HeaderView header) {
        super(header);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_subitem;
    }

    @Override
    public SubItemViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new SubItemViewHolder(view,adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, SubItemViewHolder holder, int position, List<Object> payloads) {
        holder.bind();
    }

    class SubItemViewHolder extends FlexibleViewHolder{
        private TextView title;


        public SubItemViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            title = itemView.findViewById(R.id.title);
        }

        public void bind(){

        }
    }
}
