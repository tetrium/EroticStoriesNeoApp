package com.hardcodeflow.eroticstories.views.splashview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import com.hardcodeflow.eroticstories.R
class SplashActivity: AppCompatActivity(),ISplash.View {

    private var splashPresenter:ISplash.Presenter =SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       // Tools.setSystemBarPrimaryColor(this)

        //Util.fillScreenDimensions(this)
        splashPresenter.launchNextActivity()


    }

    override fun getContext(): Context {
        return this
    }

    override fun getActivity(): Activity {
        return this
    }

}
