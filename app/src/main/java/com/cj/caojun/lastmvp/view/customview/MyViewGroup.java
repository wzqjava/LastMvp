package com.cj.caojun.lastmvp.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.cj.caojun.lastmvp.R;

/**
 * Created by caojun on 2017/12/1.
 */

public class MyViewGroup extends ViewGroup {

    private int orientation = 0;
    private final int mMarginVertical = 20;
    private final int mMarginHorizontal = 20;
    int mTop = 20;
    int mLeft = 20;

    public MyViewGroup(Context context) {
        this(context, null);

    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyViewGroup);
        orientation = typedArray.getInt(R.styleable.MyViewGroup_ori, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int totalHeight = 0;
        int totalWidth = 0;

        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);

            if (orientation == 0) {
                totalHeight += childAt.getMeasuredHeight() + mMarginVertical;
                totalWidth = childAt.getMeasuredWidth() + mLeft * 2;
            } else if (orientation == 1) {
                totalWidth += childAt.getMeasuredWidth() + mMarginHorizontal;
                totalHeight = childAt.getMeasuredHeight() + mTop * 2;
            } else if (orientation == 2) {

                totalHeight += childAt.getMeasuredHeight() + mMarginVertical;
                totalWidth += childAt.getMeasuredWidth() + mMarginHorizontal;
            }
        }


        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        if (orientation == 0) {
            //纵向
            switch (modeHeight) {
                case MeasureSpec.EXACTLY:
                    //dp match_parent
                    totalHeight = sizeHeight;
                    break;
                case MeasureSpec.AT_MOST:
                    //wrap_content
                    totalHeight += mTop;
                    break;
                case MeasureSpec.UNSPECIFIED:
                    break;
            }

        } else if (orientation == 1) {
            //横向
            switch (modeWidth) {
                case MeasureSpec.EXACTLY:
                    //dp match_parent
                    totalWidth = sizeWidth;
                    break;
                case MeasureSpec.AT_MOST:
                    //wrap_content
                    totalWidth += mLeft;
                    break;
                case MeasureSpec.UNSPECIFIED:
                    break;
            }


        } else if (orientation == 2) {
            switch (modeWidth) {
                case MeasureSpec.EXACTLY:
                    //dp match_parent
                    totalWidth = sizeWidth;
                    break;
                case MeasureSpec.AT_MOST:
                    //wrap_content
                    totalWidth += mLeft;
                    totalHeight += mTop * 2;
                    break;
                case MeasureSpec.UNSPECIFIED:
                    break;
            }
            totalHeight += mTop;
        }


        setMeasuredDimension(totalWidth, totalHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int marginVertical = mMarginVertical;
        int top = mTop;
        int marginHorizontal = mMarginHorizontal;
        int left = mLeft;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.layout(0 + left, 0 + top, childAt.getMeasuredWidth() + left, childAt.getMeasuredHeight() + top);
            if (orientation == 0) {
                top += childAt.getMeasuredHeight() + marginVertical;
            } else if (orientation == 1) {
                left += childAt.getMeasuredWidth() + marginHorizontal;
            } else if (orientation == 2) {
                top += childAt.getMeasuredHeight() + marginVertical;
                left += childAt.getMeasuredWidth() + marginHorizontal;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
