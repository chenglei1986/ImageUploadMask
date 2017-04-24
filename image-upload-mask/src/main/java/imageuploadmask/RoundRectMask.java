package imageuploadmask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;

public class RoundRectMask extends ShapeMask {

    private RectF mOval = new RectF();
    private Path mPath = new Path();
    private Path mClipPath = new Path();

    public RoundRectMask(Context context) {
        this(context, null);
    }

    public RoundRectMask(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectMask(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawMask(Canvas canvas) {
        mPath.reset();
        mOval.set(mMargin, mMargin, getWidth() - mMargin, getHeight() - mMargin);
        float width = getWidth() - mMargin * 2;
        float height = getHeight() - mMargin * 2;
        float left = mMargin;
        float right = getWidth() - mMargin;
        float top = mMargin;
        float bottom = getHeight() - mMargin;
        switch (mDirection) {
            case LTR: {
                float x = mProgress * width / 100 + left;
                mPath.addRect(x, top, right, bottom, Path.Direction.CW);
                break;
            }

            case RTL: {
                float x = width - mProgress * width / 100 + left;
                mPath.addRect(left, top, x, bottom, Path.Direction.CW);
                break;
            }

            case UTD: {
                float y = mProgress * height / 100 + top;
                mPath.addRect(left, y, right, bottom, Path.Direction.CW);
                break;
            }

            case DTU: {
                float y = height - mProgress * height / 100 + top;
                mPath.addRect(left, top, right, y, Path.Direction.CW);
                break;
            }
        }
        mClipPath.reset();
        mClipPath.addRoundRect(mOval, mCornerRadius, mCornerRadius, Path.Direction.CW);
        canvas.clipPath(mClipPath, Region.Op.REPLACE);
        canvas.drawPath(mPath, mMaskPaint);
    }
}
