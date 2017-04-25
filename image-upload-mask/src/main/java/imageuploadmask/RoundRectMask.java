package imageuploadmask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;

public class RoundRectMask extends ShapeMask {

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
    protected Path getClipPath() {
        mClipPath.reset();
        mClipPath.addRoundRect(mMaskOvalRect, mCornerRadius, mCornerRadius, Path.Direction.CW);
        return mClipPath;
    }
}
