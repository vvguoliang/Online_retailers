package net.wexpt.com.wexpt.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.ui.Data.Person;
import net.wexpt.com.wexpt.ui.recyclerview.recyclerview.BaseRecyclerAdapter;
import net.wexpt.com.wexpt.ui.utils.DensityUtil;

import java.util.List;

public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder> {
    private List<Person> list;
    private int largeCardHeight, smallCardHeight;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public SimpleAdapter(List<Person> list, Context context) {
        this.list = list;
        largeCardHeight = DensityUtil.Companion.getInstance().dip2px(context, 150f);
        smallCardHeight = DensityUtil.Companion.getInstance().dip2px(context, 100f);
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        Person person = list.get(position);
        holder.nameTv.setText(person.getName());
        holder.ageTv.setText(person.getAge());
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            holder.rootView.getLayoutParams().height = position % 2 != 0 ? largeCardHeight : smallCardHeight;
        }
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
                R.layout.xrefreshview_item_recylerview, parent, false);
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

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        View rootView;
        TextView nameTv;
        TextView ageTv;
        public int position;

        SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                nameTv = itemView.findViewById(R.id.recycler_view_test_item_person_name_tv);
                ageTv = itemView.findViewById(R.id.recycler_view_test_item_person_age_tv);
                rootView = itemView.findViewById(R.id.card_view);
                rootView.setOnClickListener(this);
            }

        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                //注意这里使用getTag方法获取数据
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public Person getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

    //define interface
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int data);

    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}