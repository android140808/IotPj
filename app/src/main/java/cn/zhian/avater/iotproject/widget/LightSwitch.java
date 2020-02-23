package cn.zhian.avater.iotproject.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import android.graphics.Color;
import android.graphics.Paint;

import cn.zhian.avater.iotproject.utils.DataHelper;

public class LightSwitch extends View {

    private Paint paint;
    private String openString = "全开";
    private String closeString = "全关";

    public LightSwitch(Context context) {
        this(context, null);
    }

    public LightSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LightSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //画圆角矩形
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);//充满
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);// 设置画笔的锯齿效果
        paint.setTextSize(DataHelper.dip2px(getContext(), 20.0f));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect();
        paint.getTextBounds(openString, 0, openString.length(), rect);
        //获取最大显示的宽高
        int maxWidth = 6 * rect.width();

        RectF oval3 = new RectF(80, 0, 500, 100);// 设置个新的长方形
        canvas.drawRoundRect(oval3, 20, 15, paint);//第二个参数是x半径，第三个参数是y半径
    }
}
