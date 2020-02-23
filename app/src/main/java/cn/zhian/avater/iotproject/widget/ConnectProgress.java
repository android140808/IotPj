package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import cn.zhian.avater.iotproject.R;

public class ConnectProgress extends View {


    private int mLenght;
    private Paint mPaint;
    private Bitmap mBitmap;
    private float mCurrentSweep;
    private boolean isFail = false;


    public ConnectProgress(Context context) {
        this(context, null);
    }

    public ConnectProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ConnectProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5.0f);
//        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.kx_sense);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        }
        mLenght = width;
        setMeasuredDimension(mLenght, mLenght);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float ringWidth = 10;
        mPaint.setColor(getResources().getColor(R.color.main_tv_un_select));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(ringWidth);
        float cx = mLenght / 2;
        float cy = mLenght / 2;
        float radius = mLenght / 2 - ringWidth / 2;
        canvas.drawCircle(cx, cy, radius, mPaint);
        if (isFail) {
            mPaint.setColor(getResources().getColor(R.color.color_red));
            float margin = ringWidth / 2;
            RectF rectF = new RectF();
            rectF.set(margin, margin, mLenght - margin, mLenght - margin);
            canvas.drawArc(rectF, 180, 360, false, mPaint);
        } else {
            mPaint.setColor(getResources().getColor(R.color.home_icon_bg));
            float margin = ringWidth / 2;
            RectF rectF = new RectF();
            rectF.set(margin, margin, mLenght - margin, mLenght - margin);
            canvas.drawArc(rectF, 180, mCurrentSweep, false, mPaint);
        }
        if (mBitmap != null) {
            Rect src = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getWidth());
            //园内正切半径r
            float r = (float) Math.sqrt(radius * radius / 2);
            int maxWidth = (int) r / 3;
            int left = (int) (radius - r + maxWidth);
            int top = (int) (radius - r + maxWidth);
            int right = (int) (radius + r - maxWidth);
            int bottom = (int) (radius + r - maxWidth);
            Rect dst = new Rect(left, top, right, bottom);
            canvas.drawBitmap(mBitmap, src, dst, mPaint);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
        invalidate();
    }

    public void setProgroess(int progroess) {
        isFail = false;
        mCurrentSweep = 360.0f * progroess / 100;
        invalidate();
    }

    public void setFailState(boolean state) {
        isFail = state;
        invalidate();
    }
}
