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

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private Path mLinePath;
    private RectF mRecF;
    private float startAngle = 0;
    private float preBottom;
    final float scale = getResources().getDisplayMetrics().density;

    private float[] buildVersionsPer = {0.3f, 0.4f, 4.3f, 10.3f, 22.4f, 25.5f, 31.1f, 5.7f};
    private int[] colors = {Color.DKGRAY, Color.YELLOW, Color.GRAY, Color.GREEN, Color.RED, Color.BLUE, Color.CYAN, Color.MAGENTA};
    private String[] buildVersions = {"Gingerbread", "Ice Cream", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePath = new Path();
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
            // 画饼图
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(colors[i]);
            float angle = 360 * buildVersionsPer[i] / 100;
            canvas.drawArc(mRecF, startAngle, angle, true, mPaint);

            // 画线
            float originX = width / 2;
            float originY = height / 2;
            float radius = width / 4;
            double thetaRadians = (startAngle + angle / 2) * Math.PI / 180;
            float startX = originX + radius * (float) Math.cos(thetaRadians);
            float startY = originY + radius * (float) Math.sin(thetaRadians);

            // 往外画 15dp 长度的线
            float pauseX = originX + (radius + 15 * scale + 0.5f) * (float) Math.cos(thetaRadians);
            float pauseY = originY + (radius + 15 * scale + 0.5f) * (float) Math.sin(thetaRadians);

            mPaint.setColor(Color.WHITE);
            mLinePath.moveTo(startX, startY);
            mLinePath.lineTo(pauseX, pauseY);

            // 如果趋于水平可直接画文字，不需要折线
            boolean canStop = (startAngle + angle / 2) <= 5 || (startAngle + angle / 2) >= 355 || Math.abs((startAngle + angle / 2) - 180) <= 5;
            // 判断线的起点在左边还是右边，true 为右边
            boolean isRight = (startAngle + angle / 2) > 270 || (startAngle + angle / 2) < 90;

            mPaint.setTextSize(10 * scale + 0.5f);
            float textWidth = mPaint.measureText(buildVersions[i]);
            if (canStop) {
                if (isRight) {
                    if (pauseY - (10 * scale + 0.5f) <= preBottom) {
                        pauseX += 8 * scale + 0.5f;
                        pauseY += 8 * scale + 0.5f;
                        mLinePath.lineTo(pauseX, pauseY);
                        pauseX += 5 * scale + 0.5f;
                        mLinePath.lineTo(pauseX, pauseY);
                    }
                    canvas.drawText(buildVersions[i], pauseX + 5, pauseY, mPaint);
                } else {
                    canvas.drawText(buildVersions[i], pauseX - 5 - textWidth, pauseY, mPaint);
                }
            } else {
                float endX;
                if (isRight) {
                    if (Math.abs(pauseY - preBottom) <= 10 * scale + 0.5f) {
                        pauseX += 8 * scale + 0.5f;
                        pauseY += 8 * scale + 0.5f;
                        mLinePath.lineTo(pauseX, pauseY);
                        pauseX += 5 * scale + 0.5f;
                        mLinePath.lineTo(pauseX, pauseY);
                    }
                    endX = pauseX + 10 * scale + 0.5f;
                    canvas.drawText(buildVersions[i], endX + 5, pauseY, mPaint);
                } else {
                    endX = pauseX - 20 * scale + 0.5f;
                    canvas.drawText(buildVersions[i], endX - 5 - textWidth, pauseY, mPaint);
                }
                mLinePath.lineTo(endX, pauseY);
            }
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(mLinePath, mPaint);
            mPaint.reset();
            mLinePath.rewind();

            preBottom = pauseY;
            startAngle += angle;
        }
    }
}
