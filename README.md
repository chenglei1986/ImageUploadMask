# ImageUploadMask

## Preview

![](screenshots/GIF.gif)

## Useage

```java
ImageUploadMask mask = new ImageUploadMask.Builder(this)
    .oval(true)
    .direction(ShapeMask.Direction.LTR)
    .maskColorInt(0x88000000)
    .cornerRadius(12)
    .textColorInt(Color.WHITE)
    .textSize(12)
    .margin(1)
    .bind(mImageView1)
    .build();

mask.setProgress(50);
```