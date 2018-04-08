package net.wexpt.com.wexpt.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.base.BaseFragment;
import net.wexpt.com.wexpt.ui.Data.ImgDataUtil;

import java.util.ArrayList;

import cn.roc.rocrecyclerviewlib.Divider.BaseItemDecoration;
import cn.roc.rocrecyclerviewlib.HeaderAndFooter.OnItemClickListener;
import cn.roc.rocrecyclerviewlib.HeaderAndFooter.OnItemLongClickListener;
import cn.roc.rocrecyclerviewlib.LayoutManager.WZMLinearLayoutManager;
import cn.roc.rocrecyclerviewlib.PullToLoad.OnLoadListener;
import cn.roc.rocrecyclerviewlib.PullToLoad.PullToLoadRecyclerView;
import cn.roc.rocrecyclerviewlib.PullToRefresh.OnRefreshListener;
import cn.roc.rocrecyclerviewlib.SimpleAdapter.SimpleAdapter;
import cn.roc.rocrecyclerviewlib.SimpleAdapter.ViewHolder;

/**
 * @Time : 2018/4/2 no 下午6:51
 * @USER : vvguoliang
 * @File : MiddleTabFragment.java
 * @Software: Android Studio
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 * ***┏┓   ┏ ┓
 * **┏┛┻━━━┛ ┻┓
 * **┃   ☃   ┃
 * **┃ ┳┛  ┗┳ ┃
 * **┃    ┻   ┃
 * **┗━┓    ┏━┛
 * ****┃    ┗━━━┓
 * ****┃ 神兽保佑 ┣┓
 * ****┃ 永无BUG！┏┛
 * ****┗┓┓┏━┳┓┏┛┏┛
 * ******┃┫┫  ┃┫┫
 * ******┗┻┛  ┗┻┛
 */

public class MiddleTabFragment extends BaseFragment {
    private PullToLoadRecyclerView recyclerview;

    private Handler handler = new Handler();
    private ArrayList<String> imgs = ImgDataUtil.getImgDatas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_mainmiddletab, container, false);
        recyclerview = view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerview.setLayoutManager(new WZMLinearLayoutManager(WZMLinearLayoutManager.VERTICAL));
//        设置适配器，封装后的适配器只需要实现一个函数
        recyclerview.setAdapter(new SimpleAdapter<String>(getActivity(), imgs, R.layout.recyclerview_item_test) {
            @Override
            protected void onBindViewHolder(ViewHolder holder, String data) {
                ImgDataUtil.loadImage(getContext(), data, holder.<ImageView>getView(R.id.iv));
            }
        });

//        设置分割线
        recyclerview.addItemDecoration(new BaseItemDecoration(getActivity(), R.color.white));
//        设置刷新监听
        recyclerview.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onStartRefreshing() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgs.clear();
                        imgs.addAll(ImgDataUtil.getImgDatas());
                        recyclerview.completeRefresh();
                    }
                }, 1000);
            }
        });
//        设置加载监听
        recyclerview.setOnLoadListener(new OnLoadListener() {
            @Override
            public void onStartLoading(int skip) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgs.addAll(ImgDataUtil.getImgDatas());
                        recyclerview.completeLoad();
                    }
                }, 1000);
            }
        });
        recyclerview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(getContext(), "item" + position + " has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerview.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                Toast.makeText(getContext(), "item" + position + " has been long clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        recyclerview.addHeaderView(getHeaderView());
    }

    private ArrayList<View> headerViews = new ArrayList<>();

    private View getHeaderView() {
        View view = getLayoutInflater().inflate(R.layout.recyclerview_item_header, recyclerview, false);
        ((TextView) view.findViewById(R.id.tv)).setText("Header" + headerViews.size());
        headerViews.add(view);
        return view;
    }
}
