package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint mPaint;
    private Path mPath;
    private RectF mRecF1, mRecf2;

    public Practice9DrawPathView(Context context) {
        this(context, null);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        int x = getWidth() / 2;
        int y = getHeight() / 3;
        if (mRecF1 == null) {
            mRecF1 = new RectF(x - 200, y - 100, x, y + 100);
        }
        if (mRecf2 == null) {
            mRecf2 = new RectF(x, y - 100 , x + 200, y + 100);
        }
        mPath.addArc(mRecF1, -225, 225);
        mPath.arcTo(mRecf2, -180, 225, false);
        mPath.lineTo(x, y + 250);
        mPaint.setColor(Color.RED);
        canvas.drawPath(mPath, mPaint);
    }
}
