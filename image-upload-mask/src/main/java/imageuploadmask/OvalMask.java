package imageuploadmask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;

public class OvalMask extends ShapeMask {

    private Path mClipPath = new Path();

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
    protected Path getClipPath() {
        mClipPath.reset();
        mClipPath.addOval(mMaskOvalRect, Path.Direction.CW);
        return mClipPath;
    }

}
