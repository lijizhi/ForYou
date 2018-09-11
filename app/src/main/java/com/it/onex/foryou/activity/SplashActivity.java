package com.it.onex.foryou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.blankj.utilcode.util.SPUtils;
import com.it.onex.foryou.MainActivity;
import com.it.onex.foryou.R;
import com.it.onex.foryou.activity.login.LoginActivity;
import com.it.onex.foryou.constant.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import yanzhikai.textpath.SyncTextPathView;
import yanzhikai.textpath.painter.FireworksPainter;

/**
 * Created by Linsa on 2018/9/3:11:00.
 * des:
 */

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.atpv_as)
    SyncTextPathView atpvAs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        RePlugin.preload("app");
//        SPUtils spUtils = SPUtils.getInstance();
//        boolean study = spUtils.getBoolean("study");
//        if (study) {
//            try {
//                Intent intent = RePlugin.createIntent("com.stx.xhb.enjoylife", "com.stx.xhb.enjoylife.ui.activity.SplashActivity");
//                RePlugin.startActivity(SplashActivity.this,intent);
//                spUtils.put("study", false);
//                finish();
//            } catch (Exception e) {
//                e.printStackTrace();
//                ToastUtils.showShort("插件出错！找360大大吧！");
//            }
//        }else {
//            spUtils.put("study", true);
//        }

        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        atpvAs.setPathPainter(new FireworksPainter());

        atpvAs.startAnimation(0,1);

//        atpvAs.setTextPainter(new SyncTextPathView.SyncTextPainter() {
//            @Override
//            public void onStartAnimation() {
//
//            }
//
//            @Override
//            public void onDrawPaintPath(float x, float y, Path paintPath) {
//
//            }
//        });


        boolean isFirst = SPUtils.getInstance().getBoolean(Constant.IS_FIRST_LOGIN, true);


        if (isFirst){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }, 5000);
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }, 5000);
        }

        SPUtils.getInstance().put(Constant.IS_FIRST_LOGIN,false);
    }

}