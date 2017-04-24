package imageuploadmask;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class ImageUploadMask {

    private ShapeMask shapeMask;

    private ImageUploadMask(ShapeMask mask) {
        shapeMask = mask;
    }

    public void setProgress(float progress) {
        shapeMask.setProgress(progress);
    }

    public static class Builder {

        private Context mContext;
        private View mTargetView;
        private int mTextColor = 0xFFFFFFFF;
        private float mTextSize;
        private int mMaskColor = 0x66000000;
        private ShapeMask.Direction mDirection = ShapeMask.Direction.DTU;
        private boolean mOval;
        private float mCornerRadius;
        private float mMargin;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder bind(View targetView) {
            mTargetView = targetView;
            return this;
        }

        public Builder textColorInt(int colorInt) {
            mTextColor = colorInt;
            return this;
        }

        public Builder textColorRes(int colorRes) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mTextColor = mContext.getResources().getColor(colorRes, null);
            } else {
                mTextColor = mContext.getResources().getColor(colorRes);
            }
            return this;
        }

        public Builder textSize(float size) {
            mTextSize = size;
            return this;
        }

        public Builder maskColorInt(int colorInt) {
            mMaskColor = colorInt;
            return this;
        }

        public Builder maskColorRes(int colorRes) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mMaskColor = mContext.getResources().getColor(colorRes, null);
            } else {
                mMaskColor = mContext.getResources().getColor(colorRes);
            }
            return this;
        }

        public Builder direction(ShapeMask.Direction direction) {
            mDirection = direction;
            return this;
        }

        public Builder oval(boolean oval) {
            mOval = oval;
            return this;
        }

        public Builder cornerRadius(float radius) {
            mCornerRadius = radius;
            return this;
        }

        public Builder margin(float margin) {
            mMargin = margin;
            return this;
        }

        public ImageUploadMask build() {
            Assertions.assertCondition(mTargetView != null, "TargetView can not be null!");

            ShapeMask shapeMask = null;
            if (mOval) {
                shapeMask = new OvalMask(mContext);
            } else {
                shapeMask = new RoundRectMask(mContext);
                shapeMask.setCornerRadius(mCornerRadius);
            }

            shapeMask.setDirection(mDirection);
            shapeMask.setTextSize(mTextSize);
            shapeMask.setTextColor(mTextColor);
            shapeMask.setMaskColor(mMaskColor);
            shapeMask.setCornerRadius(mCornerRadius);
            shapeMask.setMargin(mMargin);
            ImageUploadMask mask = new ImageUploadMask(shapeMask);

            if (shapeMask.getParent() != null) {
                ((ViewGroup) shapeMask.getParent()).removeView(shapeMask);
            }

            ViewParent parent = mTargetView.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup parentContainer = (ViewGroup) parent;
                int viewIndex = ((ViewGroup) parent).indexOfChild(mTargetView);
                parentContainer.removeView(mTargetView);
                ViewGroup.LayoutParams containerParams = mTargetView.getLayoutParams();
                FrameLayout container = new FrameLayout(mContext);
                container.setLayoutParams(containerParams);
                container.setId(mTargetView.getId());
                shapeMask.setLayoutParams(containerParams);
                container.addView(mTargetView);
                container.addView(shapeMask);
                parentContainer.addView(container, viewIndex);
            }
            return mask;
        }

    }

}
