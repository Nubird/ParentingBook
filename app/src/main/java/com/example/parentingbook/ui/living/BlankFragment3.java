package com.example.parentingbook.ui.living;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parentingbook.Articles;
import com.example.parentingbook.R;
import com.example.parentingbook.RecycleAdapter;
import com.example.parentingbook.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment3 extends Fragment {
    //ListView文章列表
    private List<Articles> articlesList = new ArrayList<Articles>();
    private ImageView adv;//头顶广告推荐位
    private BlankFragment1ViewModel mViewModel;

    public static BlankFragment3 newInstance() {
        return new BlankFragment3();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.blank_fragment3_fragment, container, false);
        //初始化内容
        iniArticlesList();
        //初始化recycleview
        //RecyclerView实现
        RecyclerView rv=(RecyclerView) root.findViewById(R.id.blank_fragment_recycleview3);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleAdapter myadapter=new RecycleAdapter(getContext(),articlesList);
        //设置间距
        rv.addItemDecoration(new SpacesItemDecoration(10));
        rv.setAdapter(myadapter);
        //下拉隐藏导航栏
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>3){
                    getActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);
                }else if(dy<-3){
                    getActivity().findViewById(R.id.nav_view).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BlankFragment1ViewModel.class);
        // TODO: Use the ViewModel
    }

    private void iniArticlesList(){
        //cloth_ListView文章
        Articles a_1 = new Articles("三个月宝宝一天睡多久合适？", R.drawable.sleep_1,
                "http://suo.im/5AlYNj\n");
        articlesList.add(a_1);
        Articles a_2 = new Articles("孕妇睡得越多越好？你错了！", R.drawable.sleep_10,
                "http://suo.im/5Pkgzd\n");
        articlesList.add(a_2);
        Articles a_3 = new Articles("新生儿黑白颠倒睡反觉，如何纠正", R.drawable.sleep_8,
                "http://suo.im/6bctC0\n");
        articlesList.add(a_3);
        Articles a_4 = new Articles("一个月的宝宝睡多久合适？", R.drawable.sleep_7,
                "http://suo.im/5Pkivd\n");
        articlesList.add(a_4);
        Articles a_5 = new Articles("四个月的宝宝睡多久合适？", R.drawable.sleep_2,
                "http://suo.im/5Pkiij\n");
        articlesList.add(a_5);
        Articles a_6 = new Articles("收藏！最完整的宝宝成长期内睡眠表", R.drawable.sleep_9,
                "http://suo.im/6bcypg\n");
        articlesList.add(a_6);

    }
}
