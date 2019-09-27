package com.africa.common.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.africa.news.common.R;

/**
 * Created by yangmeng on 2019/8/16
 */
public class CommonDialogFragment extends DialogFragment {

  public static final String STRING_TITLE = "STRING_TITLE";
  public static final String STRING_MSG = "STRING_MSG";
  public static final String STRING_OK = "STRING_OK";
  public static final String ONOKCLICKLISTENER = "ONOKCLICKLISTENER";
  public static final String STRING_CANCEL = "STRING_CANCEL";
  public static final String ONCANCELCLICKLISTENER = "ONCANCELCLICKLISTENER";
  public static final String CANCELEDONTOUCHOUTSIDE = "canceledOnTouchOutside";
  public static final String CANCELEDONTOUCHOUTSIDE_LISTENER = "CANCELEDONTOUCHOUTSIDE_LISTENER";
  public static final String ONDISMISSLISTENER = "ONDISMISSLISTENER";
  private Activity mActivity;
  private String title;
  private String msg;
  private String cancelStr;
  private Builder.OnClickListener onOKClickListener;
  private Builder.OnClickListener onCanceledOnTouchOutsideClickListener;
  private Builder.OnClickListener onCancelClickListener;
  private Builder.OnClickListener onDismissListener;
  private String okStr;
  private boolean canceledOnTouchOutside;


  private TextView mTvTitle;
  private TextView mTvCheckHint;
  private View mLine;
  private TextView mTvOk;
  private TextView mTvCancel;
  private View mVerticalLine;


  private static CommonDialogFragment newInstance(String title, String msg, String cancelStr,
                                                  Builder.OnClickListener onCancelClickListener,
                                                  String okStr, Builder.OnClickListener onOKClickListener,
                                                  boolean canceledOnTouchOutside, Builder.OnClickListener onCanceledOnTouchOutsideClickListener, Builder.OnClickListener onDismissListener) {
    CommonDialogFragment checkReplyDialogFragment = new CommonDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putString(STRING_TITLE, title);
    bundle.putString(STRING_MSG, msg);
    bundle.putString(STRING_OK, okStr);
    bundle.putParcelable(ONOKCLICKLISTENER, onOKClickListener);
    bundle.putString(STRING_CANCEL, cancelStr);
    bundle.putParcelable(ONCANCELCLICKLISTENER, onCancelClickListener);
    bundle.putBoolean(CANCELEDONTOUCHOUTSIDE, canceledOnTouchOutside);
    bundle.putParcelable(CANCELEDONTOUCHOUTSIDE_LISTENER, onCanceledOnTouchOutsideClickListener);
    bundle.putParcelable(ONDISMISSLISTENER, onDismissListener);
    checkReplyDialogFragment.setArguments(bundle);
    return checkReplyDialogFragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mActivity = getActivity();
    Bundle bundle = getArguments();
    if (bundle != null) {
      title = bundle.getString(STRING_TITLE);
      msg = bundle.getString(STRING_MSG);
      okStr = bundle.getString(STRING_OK);
      onOKClickListener = bundle.getParcelable(ONOKCLICKLISTENER);
      onCanceledOnTouchOutsideClickListener = bundle.getParcelable(CANCELEDONTOUCHOUTSIDE_LISTENER);
      cancelStr = bundle.getString(STRING_CANCEL);
      onCancelClickListener = bundle.getParcelable(ONCANCELCLICKLISTENER);
      onDismissListener = bundle.getParcelable(ONDISMISSLISTENER);
      canceledOnTouchOutside = bundle.getBoolean(CANCELEDONTOUCHOUTSIDE, false);
    }
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    Dialog dialog = new Dialog(mActivity, R.style.check_reply_dialog);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(R.layout.fragment_check_reply_dialog);
    final Window window = dialog.getWindow();
    if (window != null) {
      window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      final WindowManager.LayoutParams lp = window.getAttributes();
      lp.gravity = Gravity.CENTER;
      lp.width = WindowManager.LayoutParams.MATCH_PARENT;
      lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
      window.setAttributes(lp);
    }
    initDialog(dialog);
    return dialog;
  }

  @Override
  public void onCancel(DialogInterface dialog) {
    super.onCancel(dialog);
    //点击区域外消失回调
    if (onCanceledOnTouchOutsideClickListener != null) {
      onCanceledOnTouchOutsideClickListener.onClick(dialog);
    }
  }

  @Override
  public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);
    if (onDismissListener != null) {
      onDismissListener.onClick(dialog);
    }
  }

  private void initDialog(Dialog dialog) {
    mVerticalLine = dialog.findViewById(R.id.vertical_line);
    mTvTitle = dialog.findViewById(R.id.tv_title);
    mTvCheckHint = dialog.findViewById(R.id.tv_check_hint);
    mLine = dialog.findViewById(R.id.line);
    mTvOk = dialog.findViewById(R.id.tv_ok);
    mTvCancel = dialog.findViewById(R.id.tv_cancel);
    dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
    if (!TextUtils.isEmpty(okStr)) {
      mTvOk.setText(okStr);
      mTvOk.setVisibility(View.VISIBLE);
      mTvOk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (onOKClickListener != null) {
            onOKClickListener.onClick(getDialog());
          }
        }
      });
    }
    if (!TextUtils.isEmpty(cancelStr)) {
      if (mTvOk.getVisibility() == View.VISIBLE) {
        mVerticalLine.setVisibility(View.VISIBLE);
      }
      mTvCancel.setText(cancelStr);
      mTvCancel.setVisibility(View.VISIBLE);
      mTvCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (onCancelClickListener != null) {
            onCancelClickListener.onClick(getDialog());
          }
        }
      });
    }

    if (!TextUtils.isEmpty(title)) {
      mTvTitle.setVisibility(View.VISIBLE);
      mTvTitle.setText(title);
    }

    if (!TextUtils.isEmpty(msg)) {
      mTvCheckHint.setVisibility(View.VISIBLE);
      mTvCheckHint.setText(msg);
    }
  }


  public static class Builder {
    String okStr;
    OnClickListener onCanceledOnTouchOutsideClickListener;
    OnClickListener onDismissListener;
    OnClickListener onOKClickListener;
    String cancelStr;
    OnClickListener onCancelClickListener;
    String msg;
    String title;
    boolean canceledOnTouchOutside = true;

    public Builder setOkStr(String okStr, OnClickListener onOKClickListener) {
      this.onOKClickListener = onOKClickListener;
      this.okStr = okStr;
      return this;
    }


    public Builder setCancelStr(String cancelStr, OnClickListener onCancelClickListener) {
      this.onCancelClickListener = onCancelClickListener;
      this.cancelStr = cancelStr;
      return this;

    }

    public Builder setOnDismissListener(OnClickListener onDismissListener) {
      this.onDismissListener = onDismissListener;
      return this;

    }

    public Builder setMsg(String msg) {
      this.msg = msg;
      return this;
    }

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside, OnClickListener onCanceledOnTouchOutsideClickListener) {
      this.onCanceledOnTouchOutsideClickListener = onCanceledOnTouchOutsideClickListener;
      this.canceledOnTouchOutside = canceledOnTouchOutside;
      return this;
    }

    public void show(FragmentManager fragmentManager) {
      CommonDialogFragment dialogFragment = CommonDialogFragment.newInstance(title, msg, cancelStr, onCancelClickListener, okStr, onOKClickListener, canceledOnTouchOutside, onCanceledOnTouchOutsideClickListener, onDismissListener);
      dialogFragment.show(fragmentManager, "change_language");
    }

    public static class OnClickListener implements Parcelable {

      public void onClick(DialogInterface dialog) {

      }

      @Override
      public int describeContents() {
        return 0;
      }

      @Override
      public void writeToParcel(Parcel dest, int flags) {
      }

      public OnClickListener() {
      }

      protected OnClickListener(Parcel in) {
      }

      public static final Parcelable.Creator<OnClickListener> CREATOR = new Parcelable.Creator<OnClickListener>() {
        @Override
        public OnClickListener createFromParcel(Parcel source) {
          return new OnClickListener(source);
        }

        @Override
        public OnClickListener[] newArray(int size) {
          return new OnClickListener[size];
        }
      };
    }

  }
}
