package com.luckycode.flexibleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractExpandableHeaderItem;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

public class MainActivity extends AppCompatActivity implements FlexibleAdapter.OnItemClickListener{
    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<AbstractFlexibleItem> items = new ArrayList<>();
        items.add(create());
        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
//        items.add(create());
        ExpandableAdapter adapter = new ExpandableAdapter(items,this);
        adapter.expandItemsAtStartUp();
//                .setAutoCollapseOnExpand(false)
//                .setAutoScrollOnExpand(true)
//                .setAnimateToLimit(Integer.MAX_VALUE) //Size limit = MAX_VALUE will always animate the changes
//                .setNotifyMoveOfFilteredItems(true) //When true, filtering on big list is very slow!
//                .setAnimationOnForwardScrolling(true)
//                .setAnimationOnReverseScrolling(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }

    public HeaderView create(){
        HeaderView header = new HeaderView();
        header.addSubItem(new SubItem(header));
        header.addSubItem(new SubItem(header));
        header.addSubItem(new SubItem(header));
        header.addSubItem(new SubItem(header));
        header.addSubItem(new SubItem(header));
        return header;
    }

    @Override
    public boolean onItemClick(View view, int position) {
        return false;
    }
}
