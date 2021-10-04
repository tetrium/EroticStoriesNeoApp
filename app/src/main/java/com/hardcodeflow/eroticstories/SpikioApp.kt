package com.hardcodeflow.eroticstories

import android.app.Application
import android.content.Intent
import android.os.Handler
import com.hardcodeflow.eroticstories.views.splashview.SplashActivity

class SpikioApp : Application(){


    override fun onCreate() {
        super.onCreate()
        var intent= Intent(baseContext, SplashActivity::class.java)
        //refWatcher=LeakCanary.install(this)
        Handler().postDelayed({
            baseContext.startActivity(intent)
            //baseContext.finish()
        }, 2000)



    }


}