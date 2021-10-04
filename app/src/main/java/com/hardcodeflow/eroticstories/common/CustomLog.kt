package com.hardcodeflow.eroticstories.common

import android.util.Log
import com.google.gson.Gson



object CustomLog {
    const val TAG_DEBUG = "ROKD"

    //Thread.currentThread().getStackTrace()[2].getLineNumber()
    fun print(obj: Any, message: String, lineNumber: Int) {
        try {
            var classNameMin = obj.javaClass.name.substring(
                obj.javaClass.name
                    .lastIndexOf(".") + 1
            )
            classNameMin = classNameMin.replace("$1", "")
            Log.d(TAG_DEBUG, "($classNameMin.kt:$lineNumber) ->$message")
        } catch (ex: Exception) {
        }
    }
    fun print(obj: Any, message: String,objJson:Any, lineNumber: Int) {
        try {
            var classNameMin = obj.javaClass.name.substring(
                obj.javaClass.name
                    .lastIndexOf(".") + 1
            )

            var objStr= Gson().toJson(obj)

            classNameMin = classNameMin.replace("$1", "")
            Log.d(TAG_DEBUG, "($classNameMin.kt:$lineNumber) ->$message \b ${objStr}")
        } catch (ex: Exception) {
        }
    }
    fun print(className: String, message: String, lineNumber: Int) {
        Log.d(TAG_DEBUG, "($className.java:$lineNumber)->$message")
        // showLogCat(Constants.TAG_DEBUG,className+": "+lineNumber+"->"+message);
    }

    fun print(msg: String?, stackTraceElement: Array<StackTraceElement>) {
        val tag = TAG_DEBUG

        //StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        var currentIndex = -1
        for (i in stackTraceElement.indices) {
            if (stackTraceElement[i].methodName.compareTo("showLogCat") == 0) {
                currentIndex = i + 1
                break
            }
        }
        val fullClassName = stackTraceElement[currentIndex].className
        val className = fullClassName.substring(
            fullClassName
                .lastIndexOf(".") + 1
        )
        val methodName = stackTraceElement[currentIndex].methodName
        val lineNumber = stackTraceElement[currentIndex].lineNumber.toString()
        Log.d(tag, msg.toString())
        Log.i(
            "$tag position", "at " + fullClassName + "." + methodName + "("
                    + className + ".java:" + lineNumber + ")"
        )
    }

    fun getCleanClassName(obj: Any): String {
        return obj.javaClass.name.replace("com.vierge.prosapax.", "")
    }
}
