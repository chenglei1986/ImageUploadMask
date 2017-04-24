package imageuploadmask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public abstract class ShapeMask extends View {

    protected float mProgress;
    protected int mTextColor;
    protected float mTextSize;
    protected int mMaskColor;
    protected Paint mMaskPaint;
    protected TextPaint mTextPaint;
    protected float mCornerRadius;
    protected float mMargin;

    public enum Direction {
        /**
         * Left to Right
         */
        LTR,

        /**
         * Right to Left
         */
        RTL,

        /**
         * Up to Down
         */
        UTD,

        /**
         * Down to Up
         */
        DTU
    }

    protected Direction mDirection = Direction.DTU;

    public ShapeMask(Context context) {
        this(context, null);
    }

    public ShapeMask(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeMask(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mMaskPaint = new Paint();
        mMaskPaint.setStyle(Paint.Style.FILL);
        mMaskPaint.setAntiAlias(true);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setProgress(float progress) {
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        mProgress = progress;
        invalidate();
    }

    public void setTextColor(int color) {
        mTextColor = color;
        mTextPaint.setColor(mTextColor);
    }

    public void setTextSize(float size) {
        mTextSize = size;
        mTextPaint.setTextSize(mTextSize);
    }

    public void setMaskColor(int color) {
        mMaskColor = color;
        mMaskPaint.setColor(mMaskColor);
    }

    public void setDirection(Direction direction) {
        mDirection = direction;
    }

    public void setCornerRadius(float radius) {
        mCornerRadius = radius;
    }

    public void setMargin(float margin) {
        mMargin = margin;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMask(canvas);
        if (mProgress < 100) {
            drawProgress(canvas);
        }
    }

    protected abstract void drawMask(Canvas canvas);

    protected void drawProgress(Canvas canvas) {
        canvas.drawText((int)mProgress + "%", getWidth() / 2, getHeight() / 2 + mTextSize / 2, mTextPaint);
    }
}
