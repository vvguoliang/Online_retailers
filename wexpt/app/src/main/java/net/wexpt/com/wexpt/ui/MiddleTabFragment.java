package net.wexpt.com.wexpt.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.base.BaseFragment;
import net.wexpt.com.wexpt.ui.Data.Person;
import net.wexpt.com.wexpt.ui.adapter.MiddleTabAdapter;
import net.wexpt.com.wexpt.ui.adapter.SimpleAdapter;
import net.wexpt.com.wexpt.ui.recyclerview.XRefreshView;
import net.wexpt.com.wexpt.ui.recyclerview.XRefreshViewFooter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
 * <p>
 * 购物车
 */

public class MiddleTabFragment extends BaseFragment {

    private XRefreshView custom_view;
    private RecyclerView recycler_view_test_rv;

    private MiddleTabAdapter adapter;
    private List<Person> personList = new ArrayList<>();

    private int mLoadCount = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_mainmiddletab, container, false);
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
        adapter = new MiddleTabAdapter(personList, getActivity());
        View headView = adapter.setHeaderView(R.layout.view_title, recycler_view_test_rv);
        TextView text_title = headView.findViewById(R.id.text_title);
        text_title.setText(R.string.title_shopping_cart);
        recycler_view_test_rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycler_view_test_rv.setAdapter(adapter);

        getRecycler_view_test_rv();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person("name" + i, "" + i);
            personList.add(person);
        }
    }

    private void getRecycler_view_test_rv() {
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
}
