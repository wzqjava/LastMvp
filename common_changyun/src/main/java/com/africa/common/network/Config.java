package com.africa.common.network;

import android.content.Context;

public class Config {

  private static Context context;

  public static void init(Context context) {
    Config.context = context;
  }

  public static Context getContext() {
    return context;
  }
}
