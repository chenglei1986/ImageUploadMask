# ImageUploadMask

[ ![Download](https://api.bintray.com/packages/darren/maven/image-upload-mask/images/download.svg) ](https://bintray.com/darren/maven/image-upload-mask/_latestVersion)

## Preview

![](screenshots/GIF.gif)

## Download

```gradle
compile 'com.chenglei.imageuploadmask:image-upload-mask:1.0.1'
```

## Useage

```java
ImageView imageView = (ImageView) findViewById(R.id.imageView);

ImageUploadMask mask = new ImageUploadMask.Builder(this)
    .oval(true)
    .direction(ShapeMask.Direction.LTR)
    .maskColorInt(0x88000000)
    .cornerRadius(12)
    .textColorInt(Color.WHITE)
    .textSize(12)
    .margin(1)
    .bind(imageView)
    .build();

mask.setProgress(50);
```