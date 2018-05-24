package com.wzq.mvp_retrofit.base;

import android.app.Application;

import com.apkfuns.logutils.LogLevel;
import com.apkfuns.logutils.LogUtils;

/**
 * author:Created by WangZhiQiang on 2018/5/22.
 */

public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();

    }


    private void initLog() {
        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix("LogUtilsDemo")
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}")
                .configShowBorders(true)
//                .configMethodOffset(1)
                .configLevel(LogLevel.TYPE_VERBOSE);
//                .addParserClass(OkHttpResponseParse.class);


        /*LogUtils.getLog2FileConfig().configLog2FileEnable(true)
                .configLog2FilePath("/sdcard/LogUtils/logs/")
                .configLog2FileNameFormat("Hi-%d{yyyyMMdd}-1.txt")
                .configLog2FileLevel(LogLevel.TYPE_VERBOSE)
//                .configLogFileFilter(new LogFileFilter() {
//                        @Override
//                        public boolean accept(@LogLevel.LogLevelType int level, String tag, String logContent) {
//                            if (logContent.contains("name")) {
//                                return false;
//                            }
//                            return true;
//                        }
//                })
                .configLogFileEngine(new LogFileEngineFactory());*/
    }
}
