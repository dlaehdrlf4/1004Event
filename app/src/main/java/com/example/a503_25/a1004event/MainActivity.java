package com.example.a503_25.a1004event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        String message = String.format("x:%.1f 좌표 y:%.1f 좌표",x,y);

        //Toast.makeText(MainActivity.this,"x 좌표:" + x + "y 좌표: " + y,Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();


        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //2개의 버튼을 찾아오는 코드
        final Button btn1= (Button)findViewById(R.id.btn1);
        final Button btn2 = (Button)findViewById(R.id.btn2);

        //Button 의 click  = View.OnClickListener
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //View v 이벤트가 발생한 객체의 주소 v 와 button 이 똑같다 이것은 자료형이 다르다 뷰를 쓴이유는 보여지는 거를 다해야합니다 그래서 View로 함 상위클래스의 참조변수는 하위클래스의 모든것을 받아들
                Toast.makeText(MainActivity.this,"첫번째 버튼클릭",Toast.LENGTH_LONG).show();

            }
        });
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"두번째 버튼클릭",Toast.LENGTH_LONG).show();
            }
        });*/

        View.OnClickListener eventHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                //버튼의 텍스트를 불러온다.
               String msg = btn.getText().toString();
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        };
        //이벤트 처리 객체 연결
        btn1.setOnClickListener(eventHandler);
        btn2.setOnClickListener(eventHandler);
    }
}
