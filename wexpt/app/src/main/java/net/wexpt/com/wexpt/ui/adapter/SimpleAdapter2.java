package net.wexpt.com.wexpt.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.ui.Data.Product;
import net.wexpt.com.wexpt.ui.recyclerview.recyclerview.BaseRecyclerAdapter;

import java.util.List;
import java.util.Map;

public class SimpleAdapter2 extends BaseRecyclerAdapter<SimpleAdapter2.SimpleAdapterViewHolder> {
    private List<Product> list;
    private SimpleAdapter2.OnRecyclerView2ItemClickListener mOnItemClickListener = null;
    private Context context;

    public SimpleAdapter2(Context context) {
        this.context = context;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        Product product = list.get(position);
        Glide.with(context).load(product.getImage()).into(holder.product_image);
        holder.product_text_place.setText(product.getMadeIn());
        holder.product_text_goods.setText(product.getHasProduct());
        if (TextUtils.isEmpty(product.getSpecialPrice())) {
            holder.product_text_primary.setText("¥" + product.getPrice());
            holder.product_text_goods_money.setText("");
        } else {
            holder.product_text_primary.setText("¥" + product.getPrice());
            holder.product_text_primary.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.product_text_goods_money.setText("¥" + product.getSpecialPrice()); // 现价没有
        }
        holder.product_text_name.setText(product.getProductName());
        holder.product_text_ml.setText(product.getProductUnit());
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

    public void setData(List<Product> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.home_refreshview_item2_recylerview, parent, false);
        return new SimpleAdapterViewHolder(v, true);
    }

    public void insert(Product person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView product_image;
        TextView product_text_primary;
        TextView product_text_name;
        TextView product_text_place;
        TextView product_text_goods;
        TextView product_text_goods_money;
        TextView product_text_ml;
        public int position;

        SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                product_image = itemView.findViewById(R.id.product_image);
                product_text_primary = itemView.findViewById(R.id.product_text_primary);
                product_text_name = itemView.findViewById(R.id.product_text_name);
                product_text_place = itemView.findViewById(R.id.product_text_place);
                product_text_goods = itemView.findViewById(R.id.product_text_goods);
                product_text_goods_money = itemView.findViewById(R.id.product_text_goods_money);
                product_text_ml = itemView.findViewById(R.id.product_text_ml);
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

    public Product getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

    //define interface
    public interface OnRecyclerView2ItemClickListener {
        void onItemClick(View view, int data);

    }

    public void setOnItemClickListener(SimpleAdapter2.OnRecyclerView2ItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}