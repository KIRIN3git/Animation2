package com.example.shinji.animation2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private ImageView imageView;
    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView)findViewById(R.id.image_view);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimetion();
            }
        });

    }

    private void setAnimetion(){
        // PropertyValuesHolderを使ってＸ軸方向移動範囲のpropertyを保持
        PropertyValuesHolder vhX = PropertyValuesHolder.ofFloat( "translationX", 0.0f, 100.0f );
        // PropertyValuesHolderを使ってＹ軸方向移動範囲のpropertyを保持
        PropertyValuesHolder vhY = PropertyValuesHolder.ofFloat( "translationY", 0.0f, 100.0f );
        // PropertyValuesHolderを使って回転範囲のpropertyを保持
        PropertyValuesHolder vhRotaion = PropertyValuesHolder.ofFloat( "rotation", 0.0f, 360.0f );

        // ObjectAnimatorにセットする
        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, vhX ,vhY , vhRotaion );

        // 再生時間を設定 1000msec=1sec
        objectAnimator.setDuration(1000);

        // リスナーの追加
        objectAnimator.addListener(this);

        // アニメーションを開始する
        objectAnimator.start();
    }


    // アニメーション開始で呼ばれる
    @Override
    public void onAnimationStart(Animator animation) {
        Log.d("debug","onAnimationStart()");
    }

    // アニメーションがキャンセルされると呼ばれる
    @Override
    public void onAnimationCancel(Animator animation) {
        Log.d("debug","onAnimationCancel()");
    }

    // アニメーション終了時
    @Override
    public void onAnimationEnd(Animator animation) {
        Log.d("debug","onAnimationEnd()");
 //       imageView.layout(500, 500, 600, 600);
    }

    // 繰り返しでコールバックされる
    @Override
    public void onAnimationRepeat(Animator animation) {
        Log.d("debug","onAnimationRepeat()");
    }
}
