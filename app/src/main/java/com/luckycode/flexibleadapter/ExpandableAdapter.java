package com.luckycode.flexibleadapter;

import android.support.annotation.Nullable;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

/**
 * Created by marcelocuevas on 4/24/18.
 */

public class ExpandableAdapter extends FlexibleAdapter<AbstractFlexibleItem> {


    public ExpandableAdapter(@Nullable List<AbstractFlexibleItem> items, @Nullable Object listeners) {
        super(items, listeners);
    }
}
