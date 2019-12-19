package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import cn.zhian.avater.iotproject.R;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-18 9:44
 * @Description:
 */
public class HomeBgIcon extends View {

    private Drawable srcIcon;
    private int type;
    private Paint mPaint;
    private int mSize;

    public HomeBgIcon(Context context) {
        this(context, null);
    }

    public HomeBgIcon(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeBgIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        srcIcon = getResources().getDrawable(R.mipmap.item_watch);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HomeBgIcon);
        if (ta != null) {
            srcIcon = ta.getDrawable(R.styleable.HomeBgIcon_icon_bg);
            type = ta.getInt(R.styleable.HomeBgIcon_type, 0);
        }
        Log.e("type", "type = " + type);
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.home_icon_bg));
        mPaint.setAntiAlias(true);
        if (ta != null) {
            ta.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0, heigh = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        }
        int heighMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heighMode == MeasureSpec.EXACTLY) {
            heigh = MeasureSpec.getSize(heightMeasureSpec);
        }
        mSize = Math.max(width, heigh);
        setMeasuredDimension(mSize, mSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(mSize / 2, mSize / 2, mSize / 2, mPaint);
        srcIcon.draw(canvas);
        Bitmap bitmap = null;
        Log.e("type-ondraw", "type = " + type);
        switch (type) {
            case 0:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.item_watch);
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.item_envir);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.item_videp);
                break;
        }

        if (bitmap != null) {
            int width = bitmap.getWidth();
            int heigh = bitmap.getHeight();
            Rect rect = new Rect();
            rect.left = mSize / 2 - width / 2;
            rect.top = mSize / 2 - heigh / 2;
            rect.right = mSize / 2 + width / 2;
            rect.bottom = mSize / 2 + heigh / 2;
            srcIcon.setBounds(rect);
            srcIcon.draw(canvas);
            bitmap.recycle();
        }
    }
}
