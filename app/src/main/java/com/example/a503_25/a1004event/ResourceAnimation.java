package com.example.a503_25.a1004event;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ResourceAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_animation);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);

        //애니메이션 찾아오기
       final Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in);



        //애니메이션의 Listener을 설정
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                animation2.setFillAfter(true);
                imageView.startAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        CountDownTimer timer = new CountDownTimer(40000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                imageView.startAnimation(animation1);
            }

            @Override
            public void onFinish() {

            }
        };

        timer.start();
        //imageView.startAnimation(animation2);
        // 위처럼하면 앞에께 뒤에꺼에 덮어 씌워져서 앞에꺼는 수행이 안된다. 이렇게 하면 안되고 리스너를 이용해야한다.

    }
}
