package net.wexpt.com.wexpt.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.base.BaseFragment;
import net.wexpt.com.wexpt.ui.Data.Banner;
import net.wexpt.com.wexpt.ui.Data.Category;
import net.wexpt.com.wexpt.ui.Data.HomeData;
import net.wexpt.com.wexpt.ui.Data.Product;
import net.wexpt.com.wexpt.ui.Data.SpecialProduct;
import net.wexpt.com.wexpt.ui.adapter.SimpleAdapter;
import net.wexpt.com.wexpt.ui.adapter.SimpleAdapter1;
import net.wexpt.com.wexpt.ui.adapter.SimpleAdapter2;
import net.wexpt.com.wexpt.ui.http.AfferentDataHttpMap;
import net.wexpt.com.wexpt.ui.http.HttpImplements;
import net.wexpt.com.wexpt.ui.http.HttpRequest;
import net.wexpt.com.wexpt.ui.recyclerview.XRefreshView;
import net.wexpt.com.wexpt.ui.recyclerview.XRefreshViewFooter;
import net.wexpt.com.wexpt.ui.viwepage.BannerViewHolder;
import net.wexpt.com.wexpt.ui.viwepage.MZBannerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Time : 2018/4/2 no 下午6:48
 * @USER : vvguoliang
 * @File : MainTabFragment.java
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
 * <p>
 * 首页
 */
@SuppressWarnings("ALL")
@SuppressLint("HandlerLeak")
public class MainTabFragment extends BaseFragment {

    private XRefreshView custom_view;
    private RecyclerView recycler_view_test_rv;

    private SimpleAdapter adapter;
    private SimpleAdapter1 adapter1;
    private SimpleAdapter2 adapter2;

    private int mLoadCount = 0;

    private MZBannerView banner;
    private RecyclerView recycler_view_test_rv_image;
    private RecyclerView recycler_view_image;

    @Override
    public void onAttach(@org.jetbrains.annotations.Nullable Context context) {
        super.onAttach(context);
        HttpRequest.Companion.get().setPublic(getActivity(), AfferentDataHttpMap.Companion.get().setUSER_NUll(""),
                mHandler, HttpImplements.Companion.get().getHttp(getActivity(), "HOME"), "HOME");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_maintab, container, false);
        custom_view = view.findViewById(R.id.custom_view);
        recycler_view_test_rv = view.findViewById(R.id.recycler_view_test_rv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        custom_view.setPullLoadEnable(true);
        recycler_view_test_rv.setHasFixedSize(true);

        adapter = new SimpleAdapter(getActivity());
        recycler_view_test_rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        View headerView = adapter.setHeaderView(R.layout.home_banner_content, recycler_view_test_rv);
        TextView text_title = headerView.findViewById(R.id.text_title);
        text_title.setText(R.string.title_home_text);
        banner = headerView.findViewById(R.id.banner);
        recycler_view_image = headerView.findViewById(R.id.recycler_view_image);
        recycler_view_test_rv_image = headerView.findViewById(R.id.recycler_view_test_rv_image);

        adapter1 = new SimpleAdapter1(getActivity());
        recycler_view_image.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view_image.setLayoutManager(linearLayoutManager);

        adapter2 = new SimpleAdapter2(getActivity());
        recycler_view_test_rv_image.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view_test_rv_image.setLayoutManager(linearLayoutManager1);

        getRecycler_view_test_rv();

        recycler_view_test_rv.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.pause();
    }

    /**
     * 轮播图
     *
     * @param bannerList
     */
    private void getBranner(List<Banner> bannerList) {
        List<String> bannerList1 = new ArrayList<>();
        for (int i = 0; i < bannerList.size(); i++) {
            bannerList1.add(bannerList.get(i).getImage().toString());
        }
        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                if (TextUtils.isEmpty(bannerList.get(position).getUrl())) {
                    Toast.makeText(getActivity(), getString(R.string.coming_soon), Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getActivity(), WebVIewActivity.class);
                    intent.putExtra("url", bannerList.get(position).getUrl());
                    getActivity().startActivity(intent);
                }
            }
        });
        banner.setIndicatorVisible(true);
        // 代码中更改indicator 的位置
        //mMZBanner.setIndicatorAlign(MZBannerView.IndicatorAlign.LEFT);
        //mMZBanner.setIndicatorPadding(10,0,0,150);
        banner.setPages(bannerList1, () -> new BannerViewHolder());
    }

    /**
     * 推荐分类
     *
     * @param category
     */
    private void getCategory(List<Category> category) {
        adapter1.setOnItemClickListener((view1, data) -> {
            switch (data) {
                case 0:
                    getActivity().startActivity(new Intent(getActivity(), LandActivity.class));
                    break;
                case 1:
                    break;
            }
        });
        adapter1.setData(category);
    }

    private void getProduct(List<Product> product) {
        adapter2.setOnItemClickListener((view, data) -> {

        });
        adapter2.setData(product);
    }

    private void getSpecialProduct(List<SpecialProduct> specialProduct) {
        adapter.setOnItemClickListener((view12, data) -> Toast.makeText(getActivity(), "===1===" + data, Toast.LENGTH_LONG).show());
        adapter.setData(specialProduct);
    }

    private void getRecycler_view_test_rv() {
        custom_view.setPinnedTime(1000);
        custom_view.setPullLoadEnable(true);
        custom_view.setMoveForHorizontal(true);
        custom_view.setAutoLoadMore(true);
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));

        custom_view.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟数据加载失败的情况
                        Random random = new Random();
                        boolean success = random.nextBoolean();
                        if (success) {
                            custom_view.stopRefresh();
                        } else {
                            custom_view.stopRefresh(false);
                        }
                        //或者
//                        xRefreshView1.stopRefresh(success);
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (custom_view.hasLoadCompleted()) {
                        }
//                        for (int i = 0; i < 6; i++) {
//                            adapter.insert(new SpecialProduct("More ", "21"),
//                                    adapter.getAdapterItemCount());
//                        }
                        mLoadCount++;
                        if (mLoadCount >= 2) {
                            custom_view.setLoadComplete(true);
                        } else {
                            // 刷新完成必须调用此方法停止加载
                            custom_view.stopLoadMore(false);
                        }
                    }
                }, 1000);
            }
        });
    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1000:
                    HomeData homeData = (HomeData) msg.obj;
                    List<Banner> banner = homeData.getData().getBanner();//轮播图
                    List<Category> category = homeData.getData().getCategory();//中间选项
                    List<Product> product = homeData.getData().getProduct();//商品选项
                    List<SpecialProduct> specialProduct = homeData.getData().getSpecialProduct();//所有商品
                    getBranner(banner);
                    getCategory(category);
                    getProduct(product);
                    getSpecialProduct(specialProduct);
                    break;
                case 205:
                    Toast.makeText(getActivity(), "链接超时", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

}
