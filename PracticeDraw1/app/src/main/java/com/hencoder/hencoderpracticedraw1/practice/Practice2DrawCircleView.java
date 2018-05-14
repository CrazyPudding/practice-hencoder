package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint mPaint;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        int width = getWidth();
        int height = getHeight();
        int radius = height / 5;

        // 实心圆
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width / 4, height / 4, radius, mPaint);

        // 空心圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        canvas.drawCircle(width / 4 * 3, height / 4, radius, mPaint);

        // 蓝色实心圆
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(width / 4, height / 4 * 3, radius, mPaint);

        // 线宽为 20 的空心圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(width / 4 * 3, height / 4 * 3, radius, mPaint);
    }
}
