package com.llf.moban;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class WelcomeGuideActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_guide);

        mViewPager = (ViewPager) findViewById(R.id.id_welcome_pager);
        findViewById(R.id.btn_welcome_guide).setOnClickListener(this);

        initViewPager();
    }

    private void initViewPager(){
        list = new ArrayList<View>();
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.guide_01);
        list.add(iv);
        ImageView iv1 = new ImageView(this);
        iv1.setImageResource(R.drawable.guide_02);
        list.add(iv1);
        ImageView iv2 = new ImageView(this);
        iv2.setImageResource(R.drawable.guide_03);
        list.add(iv2);
        mViewPager.setAdapter(new CommonPageAdapter(list));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //页卡被选中的效果
            @Override
            public void onPageSelected(int arg0) {
                if (arg0==2) {
                    findViewById(R.id.btn_welcome_guide).setVisibility(View.VISIBLE);
                }else {
                    findViewById(R.id.btn_welcome_guide).setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_welcome_guide:
                startActivity(new Intent(WelcomeGuideActivity.this,MainActivity.class));
                this.finish();
                break;
        }
    }
}
