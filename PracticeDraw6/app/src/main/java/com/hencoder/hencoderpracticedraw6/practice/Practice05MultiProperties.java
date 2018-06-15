package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;

    int num;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (num) {
                    case 0:
                        imageView.animate().scaleX(1.0f);
                        imageView.animate().scaleY(1.0f);
                        imageView.animate().alpha(1.0f);
                        imageView.animate().rotation(180);
                        imageView.animate().translationX(Utils.dpToPixel(150));
                        break;
                    case 1:
                        imageView.animate().scaleX(0);
                        imageView.animate().scaleY(0);
                        imageView.animate().alpha(0);
                        imageView.animate().rotation(0);
                        imageView.animate().translationX(0);
                        break;
                }
                num++;
                if (num == 2) {
                    num = 0;
                }
            }
        });
    }
}
