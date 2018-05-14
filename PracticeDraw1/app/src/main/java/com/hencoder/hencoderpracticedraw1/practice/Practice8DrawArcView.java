package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint mPaint;
    private RectF mRecF;

    public Practice8DrawArcView(Context context) {
        this(context, null);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        if (mRecF == null) {
            mRecF = new RectF(x - 300, y - 150, x + 300, y + 150);
        }
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(mRecF,20, 150, false, mPaint);
        canvas.drawArc(mRecF, -10, -110, true, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mRecF, 180, 50, false, mPaint);
    }
}
