package com.mining.orepool;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mining.R;
import com.mining.mine.SubmitWorkActivity;
import com.mining.modle.base.BaseActivity;
import com.mining.modle.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class OrepoolActivity extends BaseFragment {
    @BindView(R.id.title_text)
    TextView title_text;//标题
    @BindView(R.id.ic_reback)
    ImageView ic_reback;//标题
    @BindView(R.id.add_btn)
    TextView add_btn;//标题

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_orepool;
    }

    @Override
    protected void setListener() {

    }
    @Override
    protected void initViews(View view) {
        ic_reback.setVisibility(View.GONE);
        title_text.setText(getResources().getString(R.string.main_a));
        add_btn.setVisibility(View.GONE);
    }

    /*第一个算力**/
    @OnClick(R.id.pool_id_a) void pool_id_a() {
        startActivity(IntroductionOrepondActivity.class);
    }
    /*第二个算力**/
    @OnClick(R.id.pool_id_b) void pool_id_b() {
        startActivity(IntroductionOrepondActivity.class);
    }
    /*第三个算力**/
    @OnClick(R.id.pool_id_c) void pool_id_c() {
        startActivity(IntroductionOrepondActivity.class);
    }
}
