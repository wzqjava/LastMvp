package com.africa.common.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.africa.common.utils.UiUtils;
import com.africa.news.common.R;

public class CommonToast extends Toast {

	private static CommonToast mToast;

	public CommonToast(Context context) {
		super(context);
	}

	public static CommonToast makeText(Context context, CharSequence text, int duration) {
		cancelToast();
		mToast = makeText(context, text, duration, 0, UiUtils.dp2Pix(context, 66));
		return mToast;
	}

	public static CommonToast makeText(Context context, CharSequence text, int duration, int xOffset, int yOffset) {
		cancelToast();
		mToast = new CommonToast(context);

		LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflate.inflate(R.layout.common_toast, null);
		TextView tv = v.findViewById(R.id.message);
		tv.setText(text);

		mToast.setView(v);
		mToast.setGravity(Gravity.TOP, xOffset, yOffset);
		mToast.setDuration(duration);

		return mToast;
	}

	public static void cancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}

	public static CommonToast makeText(Context context, int resId, int duration) {
		cancelToast();
		mToast = makeText(context, context.getResources().getText(resId), duration);
		return mToast;
	}

	public static CommonToast normarlStyle(Context context, CharSequence text, int duration) {
		cancelToast();
		mToast = new CommonToast(context);

		LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflate.inflate(R.layout.common_toast_normal, null);
		TextView tv = v.findViewById(R.id.message);
		tv.setText(text);

		mToast.setView(v);
		mToast.setGravity(Gravity.TOP, 0, UiUtils.dp2Pix(context, 90));
		mToast.setDuration(duration);

		return mToast;
	}

}
