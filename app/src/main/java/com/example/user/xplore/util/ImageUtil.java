//package com.example.user.xplore.util;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.widget.ImageView;
//
//public class ImageUtil extends ImageView {
//    public ImageUtil(Context context) {
//        super(context);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.save();
//
//        drawPath();
//
//        canvas.clipPath(mPath);
//
//        super.onDraw(canvas);
//
//        canvas.restore();
//
//        drawCanvas(canvas);
//        super.onDraw(canvas);
//    }
//
//    private void drawPath() {
//    }
//}
