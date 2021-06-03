package com.tongtongbigboy.util;

public class LogUtils {

    public static String current(){
        String className = Thread.currentThread().getStackTrace()[2].getClassName();//调用的类名
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();//调用的方法名
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();//调用的行数
        return className+"."+methodName+":"+lineNumber+'\t';
    }

    public static String higher(){
        String className = Thread.currentThread().getStackTrace()[3].getClassName();//调用的类名
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();//调用的方法名
        int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();//调用的行数
        return className+"."+methodName+":"+lineNumber+'\t';
    }

}
