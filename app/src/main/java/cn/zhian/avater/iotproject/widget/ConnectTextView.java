package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.utils.DataHelper;

public class ConnectTextView extends View {

    private Bitmap bitmapState;
    private Bitmap bitmapState1;
    private String detailString = "关联模式";
    private boolean isSuccess = false;
    private Paint mPaint;
    Drawable drawable;

    public ConnectTextView(Context context) {
        this(context, null);
    }

    public ConnectTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ConnectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(getResources().getColor(R.color.home_icon_bg));
        bitmapState = BitmapFactory.decodeResource(getResources(), R.mipmap.un_connect2);
        drawable = ContextCompat.getDrawable(context, R.drawable.connect_dot_blue1);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(DataHelper.dip2px(getContext(), 20.0f));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (bitmapState == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float middle = width / 2;
        int margin = 25;


        Rect src = new Rect(0, 0, bitmapState.getWidth(), bitmapState.getHeight());
        int left = (int) (middle - margin - bitmapState.getWidth()) - 20;
        int top = height / 2 - bitmapState.getHeight() / 2 - 20;
        int right = (int) (middle - margin) + 20;
        int bottom = height / 2 + bitmapState.getHeight() / 2 + 20;
        Rect dst = new Rect(left, top, right, bottom);
        canvas.drawBitmap(bitmapState, src, dst, mPaint);

        drawable.draw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.connect_dot_blue2);


        Rect textRect = new Rect();
        mPaint.getTextBounds(detailString, 0, detailString.length(), textRect);
        canvas.drawText(detailString, middle, height / 2 + textRect.height() / 2, mPaint);

    }

    public void changeSelectState() {

        invalidate();
    }

    public void setText(String value) {
        detailString = value;
        invalidate();
    }
}
