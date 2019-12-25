package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import cn.zhian.avater.iotproject.utils.DataHelper;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-24 11:32
 * @Description:显示消息条数的View
 */
public class MessageDotView extends View {


    private Paint mPaint;
    private String mCount = "0";


    public MessageDotView(Context context) {
        this(context, null);
    }

    public MessageDotView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageDotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(DataHelper.dip2px(context, 10));
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
        int mSize = Math.max(width, heigh);
        setMeasuredDimension(mSize, mSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!mCount.equals("0")) {
            mPaint.setColor(Color.RED);
            float cx = getWidth() / 2;
            float cy = getHeight() / 2;
            float radius = cx;
            canvas.drawCircle(cx, cy, radius, mPaint);
            Rect rect = new Rect();
            mPaint.getTextBounds(mCount, 0, mCount.length(), rect);
            mPaint.setColor(Color.WHITE);
            int textLength = rect.width();
            int textHeight = rect.height();
            if (textLength > radius) {
                mPaint.setTextSize(DataHelper.dip2px(getContext(), 8));
            }
            canvas.drawText(mCount, cx - textLength / 2, cy + textHeight / 2, mPaint);
        }
    }

    public void setMessageCount(int messageCount) {
        mCount = String.valueOf(messageCount);
        invalidate();
    }
}
