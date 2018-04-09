package net.wexpt.com.wexpt.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.base.BaseFragment;
import net.wexpt.com.wexpt.ui.Data.Person;
import net.wexpt.com.wexpt.ui.adapter.SimpleAdapter;
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
 */

public class MainTabFragment extends BaseFragment implements MZBannerView.BannerPageClickListener {

    private XRefreshView custom_view;
    private RecyclerView recycler_view_test_rv;

    private SimpleAdapter adapter;

    private List<Person> personList = new ArrayList<>();

    private int mLoadCount = 0;

    private MZBannerView banner;
    public static final int[] BANNER = new int[]{R.mipmap.banner1, R.mipmap.banner2, R.mipmap.banner3, R.mipmap.banner4, R.mipmap.banner5};

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

        initData();

        adapter = new SimpleAdapter(personList, getActivity());

        recycler_view_test_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        View headerView = adapter.setHeaderView(R.layout.viewpager_banner_view, recycler_view_test_rv);
        banner = headerView.findViewById(R.id.banner);
        List<Integer> bannerList = new ArrayList<>();
        for (int i = 0; i < BANNER.length; i++) {
            bannerList.add(BANNER[i]);
        }
        banner.setBannerPageClickListener(this);
        banner.setIndicatorVisible(true);
        // 代码中更改indicator 的位置
        //mMZBanner.setIndicatorAlign(MZBannerView.IndicatorAlign.LEFT);
        //mMZBanner.setIndicatorPadding(10,0,0,150);
        banner.setPages(bannerList, () -> new BannerViewHolder());

        recycler_view_test_rv.setAdapter(adapter);

        custom_view.setPinnedTime(1000);
        custom_view.setPullLoadEnable(true);
        custom_view.setMoveForHorizontal(true);
        custom_view.setAutoLoadMore(true);
//        recyclerviewAdapter.setHeaderView(headerView, recyclerView);
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
                        for (int i = 0; i < 6; i++) {
                            adapter.insert(new Person("More ", "21"),
                                    adapter.getAdapterItemCount());
                        }
                        mLoadCount++;
                        if (mLoadCount >= 3) {
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

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person("name" + i, "" + i);
            personList.add(person);
        }
    }

    @Override
    public void onPageClick(View view, int position) {
        Toast.makeText(getContext(), "click page:" + position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.pause();
    }
}
