package net.wexpt.com.wexpt.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.ui.Data.Person;
import net.wexpt.com.wexpt.ui.recyclerview.recyclerview.BaseRecyclerAdapter;
import net.wexpt.com.wexpt.ui.utils.DensityUtil;
import net.wexpt.com.wexpt.ui.view.SnappingStepper.SnappingStepper;
import net.wexpt.com.wexpt.ui.view.SnappingStepper.SnappingStepperValueChangeListener;

import java.util.List;

public class MiddleTabAdapter extends BaseRecyclerAdapter<MiddleTabAdapter.SimpleAdapterViewHolder> {
    private List<Person> list;
    private int largeCardHeight, smallCardHeight;

    private int position = 0;

    public MiddleTabAdapter(List<Person> list, Context context) {
        this.list = list;
        largeCardHeight = DensityUtil.Companion.getInstance().dip2px(context, 150f);
        smallCardHeight = DensityUtil.Companion.getInstance().dip2px(context, 100f);
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        Person person = list.get(position);
        this.position = position;
    }

    @Override
    public int getAdapterItemViewType(int position) {
        return 0;
    }

    @Override
    public int getAdapterItemCount() {
        return list.size();
    }

    @Override
    public SimpleAdapterViewHolder getViewHolder(View view) {
        return new SimpleAdapterViewHolder(view, false);
    }

    public void setData(List<Person> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_middle_view_adapter, parent, false);
        return new SimpleAdapterViewHolder(v, true);
    }

    public void insert(Person person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder implements SnappingStepperValueChangeListener, CompoundButton.OnCheckedChangeListener {

        SnappingStepper stepper;
        CheckBox check_box;


        SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                stepper = itemView.findViewById(R.id.stepper);
                stepper.setOnValueChangeListener(this);
                stepper.setTag(itemView);
                check_box = itemView.findViewById(R.id.check_box);
                check_box.setOnCheckedChangeListener(this);
            }
        }

        @Override
        public void onValueChange(View view, int value) {
            if (stepper.getTag() == view)
                stepper.setText(String.valueOf(value));
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        }
    }

    public Person getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}