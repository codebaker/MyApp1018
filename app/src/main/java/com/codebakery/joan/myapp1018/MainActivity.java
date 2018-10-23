package com.codebakery.joan.myapp1018;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View {
    int key;
    String str;
    int x,y;
    public MyView(Context ctx){
        super(ctx);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int) event.getX();
        y=(int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) str = "액션다운";
        if (event.getAction() == MotionEvent.ACTION_MOVE) str = "액션무브";
        if (event.getAction() == MotionEvent.ACTION_UP)  str = "액션업";

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(50);
        canvas.drawCircle(x,y,30,paint);
       // canvas.drawText("(" +x+","+y+")에서 터치 이벤트가 발생하였음",x,y+100, paint);
        canvas.drawText("(" +x+","+y+")액션종류 :" + str ,100,100, paint);
        super.onDraw(canvas);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }
}
