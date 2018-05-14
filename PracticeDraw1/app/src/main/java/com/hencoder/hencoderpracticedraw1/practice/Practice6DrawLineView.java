package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    private Paint mPaint;

    public Practice6DrawLineView(Context context) {
        this(context, null);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        int x = getWidth() / 3;
        int y = getHeight() / 3;
        canvas.drawLine(x, y, x * 2, y * 2, mPaint);
    }
}
