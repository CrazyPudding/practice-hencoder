package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw6.R;

public class PracticeAnimatedMap extends View {

    private Bitmap bitmap;
    private Paint bitmapPaint;
    private Paint paint;
    private Camera camera;
    private AnimatorSet set;
    private float degree1;  // 第一个动画旋转角度

    public float getDegree2() {
        return degree2;
    }

    public void setDegree2(float degree2) {
        this.degree2 = degree2;
        invalidate();
    }

    private float degree2;  // 第二个动画旋转角度
    private float degree3;  // 最后一个动画旋转角度

    public float getDegree1() {
        return degree1;
    }

    public void setDegree1(float degree1) {
        this.degree1 = degree1;
        invalidate();
    }

    public float getDegree3() {
        return degree3;
    }

    public void setDegree3(float degree3) {
        this.degree3 = degree3;
        invalidate();
    }

    public PracticeAnimatedMap(Context context) {
        super(context);
    }

    public PracticeAnimatedMap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeAnimatedMap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        camera = new Camera();

        // 设置 bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // 设置动画部分
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(this, "degree1", 0, -45);
        animator1.setDuration(1000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "degree2", 0, 270);
        animator2.setDuration(1500);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(this, "degree3", 0, -45);
        animator3.setDuration(1000);
        set = new AnimatorSet();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startAnim();
                    }
                }, 500);
            }
        });
        set.playSequentially(animator1, animator2, animator3);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        set.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        set.end();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        float x = centerX - bitmap.getWidth() / 2;
        float y = centerY - bitmap.getHeight() / 2;

        // 左半部分旋转
        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-degree2);  // 5.将 canvas 旋转回初始状态，保证动画过程 bitmap 保持不变
        camera.rotateY(degree1);  // 4.相机做 3D 效果
        camera.applyToCanvas(canvas);
        canvas.clipRect(0, -centerY, centerX, centerY); // 3.开始裁切
        canvas.rotate(degree2);  // 2.旋转 canvas， 方便对裁切动态处理
        canvas.translate(-centerX, -centerY);  // 1.将 canvas 中 bitmap 中心点移动到原点
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, bitmapPaint);
        canvas.restore();

        // 剩下一部分
        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        camera.rotateX(degree3);
        camera.applyToCanvas(canvas);
        canvas.rotate(-degree2);
        canvas.clipRect(-centerX, -centerY, 0, centerY);
        canvas.rotate(degree2);
        canvas.translate(-centerX, -centerY);
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, bitmapPaint);
        canvas.restore();
    }

    public void startAnim() {
        degree1 = 0;
        degree2 = 0;
        degree3 = 0;
        set.start();
    }
}