package net.wexpt.com.wexpt.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import net.wexpt.com.wexpt.R;
import net.wexpt.com.wexpt.base.BaseFragment;
import net.wexpt.com.wexpt.ui.viwepage.BannerViewHolder;
import net.wexpt.com.wexpt.ui.viwepage.MZBannerView;
import net.wexpt.com.wexpt.ui.viwepage.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time : 2018/4/2 no 下午6:53
 * @USER : vvguoliang
 * @File : MyTabFragment.java
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

public class MyTabFragment extends BaseFragment{

    private ImageView my_image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_mainmy, container, false);
        my_image = view.findViewById(R.id.my_image);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(getActivity()).load(R.mipmap.pic_hd).into(my_image);
    }
}
