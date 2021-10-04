package com.hardcodeflow.eroticstories.views.splashview

import android.app.Activity
import android.content.Context

interface ISplash {
    interface  View{
        fun getContext():Context
        fun getActivity():Activity
    }
    interface  Presenter{
        fun launchNextActivity()

       // fun checkUserLoginHandler(webApiErrorData: WebApiErrorData)
    }
    interface Model{
        fun checkUserLogin(context: Context)

    }


}