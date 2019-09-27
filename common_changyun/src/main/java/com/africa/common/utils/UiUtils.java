package com.africa.common.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;

/**
 * Created by wang on 31/07/2017.
 */

public class UiUtils {

  public static int dp2Pix(Context context, int pix) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (pix * scale + 0.5f);
  }

  public static int px2dip(Context context, float pxValue) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }


  public static Drawable getRectDrawble(@ColorInt int strokeColor, int strokeWidth, int cornerRadius) {
    return getRectDrawble(Color.TRANSPARENT, strokeColor, strokeWidth, cornerRadius);
  }


  public static Drawable getRectDrawble(@ColorInt int solidColor, @ColorInt int strokeColor, int strokeWidth, int cornerRadius) {
    GradientDrawable shape = new GradientDrawable();
    shape.setShape(GradientDrawable.RECTANGLE);
    shape.setCornerRadii(new float[]{cornerRadius, cornerRadius, cornerRadius,
        cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius});
    shape.setColor(solidColor);
    if (strokeWidth > 0) {
      shape.setStroke(strokeWidth, strokeColor);
    }
    return shape;
  }

  /**
   * 将px值转换为sp值，保证文字大小不变
   *
   * @param pxValue （DisplayMetrics类中属性scaledDensity）
   * @return
   */
  public static int px2sp(Context context, float pxValue) {
    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (pxValue / fontScale + 0.5f);
  }

  /**
   * 将sp值转换为px值，保证文字大小不变
   *
   * @param spValue （DisplayMetrics类中属性scaledDensity）
   * @return
   */
  public static int sp2px(Context context, float spValue) {


    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * fontScale + 0.5f);
  }
}
