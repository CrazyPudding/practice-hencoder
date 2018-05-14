package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {

    private Paint mPaint;
    private RectF mRect;

    public Practice5DrawOvalView(Context context) {
        this(context, null);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        if (mRect == null) {
            mRect = new RectF(x - 300, y - 150, x + 300 , y + 150);
        }
        canvas.drawOval(mRect, mPaint);
    }
}
