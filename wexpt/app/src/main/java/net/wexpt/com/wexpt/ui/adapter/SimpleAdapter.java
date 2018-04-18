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
import net.wexpt.com.wexpt.ui.Data.SpecialProduct;
import net.wexpt.com.wexpt.ui.recyclerview.recyclerview.BaseRecyclerAdapter;
import net.wexpt.com.wexpt.ui.utils.DensityUtil;

import java.util.List;

public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder> {
    private List<SpecialProduct> list;
    private int largeCardHeight, smallCardHeight;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    private Context context;

    public SimpleAdapter(Context context) {
        this.context = context;
        largeCardHeight = DensityUtil.Companion.getInstance().dip2px(context, 150f);
        smallCardHeight = DensityUtil.Companion.getInstance().dip2px(context, 100f);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        SpecialProduct specialProduct = list.get(position);
        Glide.with(context).load(specialProduct.getImage()).into(holder.SpecialProduct_image);
        holder.SpecialProduct_text_name.setText(specialProduct.getProductName());
        holder.SpecialProduct_text_place.setText(specialProduct.getMadeIn());
        holder.SpecialProduct_text_goods.setText(specialProduct.getHasProduct());
        if (TextUtils.isEmpty(specialProduct.getSpecialPrice())) {
            holder.SpecialProduct_text_primary.setText("¥" + specialProduct.getPrice());
            holder.SpecialProduct_text_goods_money.setText("");
        } else {
            holder.SpecialProduct_text_primary.setText("¥" + specialProduct.getPrice());
            holder.SpecialProduct_text_primary.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.SpecialProduct_text_goods_money.setText("¥" + specialProduct.getSpecialPrice());
        }
        holder.SpecialProduct_text_ml.setText(specialProduct.getProductUnit());
//        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
//            holder.rootView.getLayoutParams().height = position % 2 != 0 ? largeCardHeight : smallCardHeight;
//        }
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

    public void setData(List<SpecialProduct> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.xrefreshview_item_recylerview, parent, false);
        return new SimpleAdapterViewHolder(v, true);
    }

    public void insert(SpecialProduct person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        View rootView;
        ImageView SpecialProduct_image;
        TextView SpecialProduct_text_name;
        TextView SpecialProduct_text_place;
        TextView SpecialProduct_text_goods;
        TextView SpecialProduct_text_primary;
        TextView SpecialProduct_text_goods_money;
        TextView SpecialProduct_text_ml;
        public int position;

        SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                SpecialProduct_image = itemView.findViewById(R.id.SpecialProduct_image);
                SpecialProduct_text_name = itemView.findViewById(R.id.SpecialProduct_text_name);
                SpecialProduct_text_place = itemView.findViewById(R.id.SpecialProduct_text_place);
                SpecialProduct_text_goods = itemView.findViewById(R.id.SpecialProduct_text_goods);
                SpecialProduct_text_primary = itemView.findViewById(R.id.SpecialProduct_text_primary);
                SpecialProduct_text_goods_money = itemView.findViewById(R.id.SpecialProduct_text_goods_money);
                SpecialProduct_text_ml = itemView.findViewById(R.id.SpecialProduct_text_ml);
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

    public SpecialProduct getItem(int position) {
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