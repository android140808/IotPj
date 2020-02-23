package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ConnectViewGroup extends ViewGroup {

    public ConnectViewGroup(Context context) {
        super(context);
    }

    public ConnectViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConnectViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        Log.d("TAG", "count = " + count);
        Log.d("TAG", "changed = " + changed + ",left = " + left + ",top = " + top + ",right = " + right + ",bottom = " + bottom);
        Log.d("TAG", "");
        View imageView = getChildAt(0);
        int imageViewWidth = imageView.getMeasuredWidth();
        int imageViewHeight = imageView.getMeasuredHeight();
        Log.d("TAG", "imageViewWidth = " + imageViewWidth);
        Log.d("TAG", "imageViewHeight = " + imageViewHeight);
        int il = getWidth() / 2 - 6 * imageViewWidth;
        int it = getHeight() / 2 - imageViewHeight / 2;
        int ir = il + imageViewWidth;
        int ib = getHeight() / 2 + imageViewHeight / 2;
        imageView.layout(
                il,
                it,
                ir,
                ib
        );
        View textView = getChildAt(1);
        int textViewWidth = textView.getMeasuredWidth();
        int textViewHeight = textView.getMeasuredHeight();
        Log.d("TAG", "textViewWidth = " + textViewWidth);
        Log.d("TAG", "textViewHeight = " + textViewHeight);
        int tl = il + 2 * imageViewWidth;
        int tt = getHeight() / 2 - textViewHeight / 2;
        int tr = il + textViewWidth + 2 * imageViewWidth;
        int tb = getHeight() / 2 + textViewHeight / 2;
        textView.layout(
                tl,
                tt,
                tr,
                tb
        );
    }
}
