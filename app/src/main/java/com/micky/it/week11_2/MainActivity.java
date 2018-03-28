package com.micky.it.week11_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

class BallAnimation extends View {

    Handler h;

    public BallAnimation(Context context) {
        super(context);
    }

    public BallAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        h = new Handler();
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };
    int xBall, xbar=0,ybar=0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        //canvas.drawCircle(80+ xBall, 150, 120, paint);
        h.postDelayed(r, 40); //แบบเกม
        // h.postDelayed(r,17); //แบบหนัง

        xBall += 10;


        paint.setColor(Color.RED); //สร้าง แกน  x,y
        paint.setStrokeWidth(15);
        //canvas.drawLine(20,1000,1000,1000,paint);
        //canvas.scale(3,3,3,500);
        canvas.drawText("X",35,35,paint);
        canvas.drawText("Y",1000,1008,paint);
        canvas.drawLine(30, 980, 980, 980, paint); //y
        canvas.drawLine(30, 30, 30, 988, paint); //x



        paint.setColor(Color.BLUE); //barchart
        canvas.drawRect(37, 200, 100+xbar, 350, paint);//1

        paint.setColor(Color.GREEN); //barchart
        canvas.drawRect(37, 550, 100+ybar, 700, paint);//2

        h.postDelayed(r, 40);

        if(xbar <= 900){
            xbar +=10;
        }
        if(ybar <= 600){
            ybar +=10;
        }


        paint.setColor(Color.LTGRAY); //Donus
        canvas.drawCircle(500,1200,100,paint);

        paint.setColor(Color.LTGRAY); //Donus
        canvas.drawCircle(500,1200,200,paint);




    }
}
