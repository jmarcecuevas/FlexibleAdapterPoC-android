package com.luckycode.flexibleadapter;

import android.view.View;
import android.widget.TextView;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractExpandableHeaderItem;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IExpandable;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.flexibleadapter.items.IHeader;
import eu.davidea.viewholders.ExpandableViewHolder;
import com.luckycode.flexibleadapter.HeaderView.HeaderViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelocuevas on 4/24/18.
 */

public class HeaderView extends AbstractFlexibleItem<HeaderViewHolder>
                        implements IExpandable<HeaderViewHolder,SubItem>,
                                    IHeader<HeaderViewHolder>{

    private boolean expanded = false;
    private List<SubItem> subItems;

    public HeaderView() {
        // Configure the section status: shown and/or expanded
        setHidden(false);
        setExpanded(true);
        // NOT selectable, otherwise (if you have) the ActionMode will be activated on long click!
        setSelectable(false);
    }

    public void addSubItem(SubItem subItem) {
        if (subItems == null)
            subItems = new ArrayList<>();
        subItems.add(subItem);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_header;
    }

    @Override
    public HeaderViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new HeaderViewHolder(view,adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, HeaderViewHolder holder, int position, List<Object> payloads) {
        holder.bind();
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public int getExpansionLevel() {
        return 0;
    }

    @Override
    public List<SubItem> getSubItems() {
        return subItems;
    }


    class HeaderViewHolder extends ExpandableViewHolder{
        private TextView title;


        public HeaderViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            title = view.findViewById(R.id.title);
        }

        public void bind(){
        }


        /**
         * Allows to expand or collapse child views of this itemView when {@link View.OnClickListener}
         * event occurs on the entire view.
         * <p>This method returns always true; Extend with "return false" to Not expand or collapse
         * this ItemView onClick events.</p>
         *
         * @return always true, if not overridden
         * @since 5.0.0-b1
         */
        @Override
        protected boolean isViewExpandableOnClick() {
            return true;//default=true
        }

        /**
         * Allows to collapse child views of this ItemView when {@link View.OnLongClickListener}
         * event occurs on the entire view.
         * <p>This method returns always true; Extend with "return false" to Not collapse this
         * ItemView onLongClick events.</p>
         *
         * @return always true, if not overridden
         * @since 5.0.0-b1
         */
        protected boolean isViewCollapsibleOnLongClick() {
            return true;//default=true
        }

        /**
         * Allows to notify change and rebound this itemView on expanding and collapsing events,
         * in order to update the content (so, user can decide to display the current expanding status).
         * <p>This method returns always false; Override with {@code "return true"} to trigger the
         * notification.</p>
         *
         * @return true to rebound the content of this itemView on expanding and collapsing events,
         * false to ignore the events
         * @see #expandView(int)
         * @see #collapseView(int)
         * @since 5.0.0-rc1
         */
        @Override
        protected boolean shouldNotifyParentOnClick() {
            return false;//default=false
        }

        /**
         * Expands or Collapses based on the current state.
         *
         * @see #shouldNotifyParentOnClick()
         * @see #expandView(int)
         * @see #collapseView(int)
         * @since 5.0.0-b1
         */
        @Override
        protected void toggleExpansion() {
            super.toggleExpansion(); //If overridden, you must call the super method
        }

        /**
         * Triggers expansion of this itemView.
         * <p>If {@link #shouldNotifyParentOnClick()} returns {@code true}, this view is rebound

         *
         * @see #shouldNotifyParentOnClick()
         * @since 5.0.0-b1
         */
        @Override
        protected void expandView(int position) {
            super.expandView(position); //If overridden, you must call the super method
            // Let's notify the item has been expanded. Note: from 5.0.0-rc1 the next line becomes
            // obsolete, override the new method shouldNotifyParentOnClick() as showcased here
            //if (mAdapter.isExpanded(position)) mAdapter.notifyItemChanged(position, true);
        }

        /**
         * Triggers collapse of this itemView.
         * <p>If {@link #shouldNotifyParentOnClick()} returns {@code true}, this view is rebound
         *
         * @see #shouldNotifyParentOnClick()
         * @since 5.0.0-b1
         */
        @Override
        protected void collapseView(int position) {
            super.collapseView(position); //If overridden, you must call the super method
            // Let's notify the item has been collapsed. Note: from 5.0.0-rc1 the next line becomes
            // obsolete, override the new method shouldNotifyParentOnClick() as showcased here
            //if (!mAdapter.isExpanded(position)) mAdapter.notifyItemChanged(position, true);
        }
    }
}
