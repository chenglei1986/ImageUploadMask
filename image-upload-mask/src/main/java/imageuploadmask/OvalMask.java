package imageuploadmask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

public class OvalMask extends ShapeMask {

    private RectF mOval = new RectF();

    public OvalMask(Context context) {
        this(context, null);
    }

    public OvalMask(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OvalMask(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawMask(Canvas canvas) {
        float startAngle = mProgress * 180f / 100f;
        float sweepAngle = 360 - 2 * startAngle;
        switch (mDirection) {
            case LTR:
                startAngle += -180;
                break;

            case RTL:
                startAngle += 0;
                break;

            case UTD:
                startAngle += -90;
                break;

            case DTU:
                startAngle += 90;
                break;
        }
        mOval.set(getLeft() + mMargin, getTop() + mMargin, getRight() - mMargin, getBottom() - mMargin);
        canvas.drawArc(mOval, startAngle, sweepAngle, false, mMaskPaint);
    }

}
