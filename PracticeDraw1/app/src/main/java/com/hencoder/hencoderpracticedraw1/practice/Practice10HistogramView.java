package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint mPaint;
    final float scale = getResources().getDisplayMetrics().density;
    private float[] buildVersionsPer = {0.3f, 0.4f, 4.3f, 10.3f, 22.4f, 25.5f, 31.1f, 5.7f};
    private String[] buildVersions = {"GB", "ICS", "JB", "KitKat", "L", "M", "N", "O"};

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        int width = getWidth() / 10;
        int height = getHeight() / 10;

        // 绘制坐标轴
        mPaint.setStrokeWidth(0.5f * scale + 0.5f);
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(width * 0.5f, height * 0.5f, width * 0.5f, height * 7.5f, mPaint);
        canvas.drawLine(width * 0.5f, height * 7.5f, width * 9.5f, height * 7.5f, mPaint);

        for (int i = 0; i < buildVersionsPer.length; i++) {
            // 绘制直方形
            int recW = width;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.GREEN);
            float recStart = width * 0.5f + (i + 1) * width * 0.1f + i * recW;
            float recEnd = recStart + recW;
            float recBottom = height * 7.5f - (0.5f * scale + 0.5f);
            float recTop = recBottom - height * 5.6f / 31.1f * buildVersionsPer[i];
            canvas.drawRect(recStart, recTop, recEnd, recBottom, mPaint);

            // 绘制文字
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(14 * scale + 0.5f);
            float textX = recStart + (recW - mPaint.measureText(buildVersions[i])) / 2;
            float textY = recBottom + 15 * scale + 0.5f;
            canvas.drawText(buildVersions[i], textX, textY, mPaint);
        }

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(24 * scale + 0.5f);
        canvas.drawText("直方图", (width * 10f - mPaint.measureText("直方图")) / 2, height * 10f - 40, mPaint);
    }
}