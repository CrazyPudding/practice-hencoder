package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private RectF mRecF;
    private float lastAngle = 0;
    final float scale = getResources().getDisplayMetrics().density;

    private float[] buildVersionsPer = {0.3f, 0.4f, 4.3f, 10.3f, 22.4f, 25.5f, 31.1f, 5.7f};
    private int[] colors = {Color.DKGRAY, Color.GRAY, Color.YELLOW, Color.GREEN, Color.RED, Color.BLUE, Color.CYAN, Color.MAGENTA};
    private String[] buildVersions = {"Gingerbread", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int width = getWidth();
        int height = getHeight();

        if (mRecF == null) {
            mRecF = new RectF(width / 2 - width / 4, height / 2 - width / 4, width / 2 + width / 4, height / 2 + width / 4);
        }

        for (int i = 0; i < buildVersions.length; i++) {
            mPaint.setColor(colors[i]);
            float angle = 360 * buildVersionsPer[i] / 100 ;
            canvas.drawArc(mRecF, lastAngle, angle, true, mPaint);
            lastAngle += angle;
        }
    }
}
