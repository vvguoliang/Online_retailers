package net.wexpt.com.wexpt.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.ui.Data.Category;
import net.wexpt.com.wexpt.ui.recyclerview.recyclerview.BaseRecyclerAdapter;

import java.util.List;

public class SimpleAdapter1 extends BaseRecyclerAdapter<SimpleAdapter1.SimpleAdapterViewHolder> {
    private List<Category> list;
    private SimpleAdapter1.OnRecyclerView1ItemClickListener mOnItemClickListener = null;
    private Context context;

    public SimpleAdapter1(Context context) {
        this.context = context;
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        holder.itme_text.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImage()).into(holder.itme_image);
    }

    @Override
    public int getAdapterItemViewType(int position) {
        return 0;
    }

    @Override
    public int getAdapterItemCount() {
        if (list != null && list.size() > 0)
            return list.size();
        else
            return 0;
    }

    @Override
    public SimpleAdapterViewHolder getViewHolder(View view) {
        return new SimpleAdapterViewHolder(view, false);
    }

    public void setData(List<Category> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.home_refreshview_item_recylerview, parent, false);
        return new SimpleAdapterViewHolder(v, true);
    }

    public void insert(Category person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itme_text;
        ImageView itme_image;
        LinearLayout item_linear;
        public int position;

        SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                itme_text = itemView.findViewById(R.id.itme_text);
                itme_image = itemView.findViewById(R.id.itme_image);
                item_linear = itemView.findViewById(R.id.item_linear);
                item_linear.setOnClickListener(this);
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

    public Category getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

    //define interface
    public interface OnRecyclerView1ItemClickListener {
        void onItemClick(View view, int data);

    }

    public void setOnItemClickListener(SimpleAdapter1.OnRecyclerView1ItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}