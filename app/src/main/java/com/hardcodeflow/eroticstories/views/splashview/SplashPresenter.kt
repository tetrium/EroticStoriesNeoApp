package com.hardcodeflow.eroticstories.views.splashview

import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hardcodeflow.eroticstories.MainActivity

class SplashPresenter(private var splashView:ISplash.View):ISplash.Presenter{


    private var splashModel:ISplash.Model=SplashModel(this)

    override fun launchNextActivity() {
        splashModel.checkUserLogin(splashView.getContext())
    }



    fun launchMainActivity(){
        var context=splashView.getContext()
        var appCompat=(splashView.getActivity() as AppCompatActivity)
        var activity=splashView.getActivity()


            var intent= Intent(context, MainActivity::class.java)
            Handler().postDelayed({
                context.startActivity(intent)
                activity.finish()
            }, 2000)


    }
    fun launchWelcomeActivity(){
        var context=splashView.getContext()
        var appCompat=(splashView.getActivity() as AppCompatActivity)
        var activity=splashView.getActivity()


      /*  var intent= Intent(context,WelcomeActivity::class.java)
        Handler().postDelayed({
            context.startActivity(intent)
            activity.finish()
        }, 2000)
*/


    }

    fun showNextActivity(){
        var context=splashView.getContext()
        var appCompat=(splashView.getActivity() as AppCompatActivity)
        var activity=splashView.getActivity()

        /*if(UserSessionManager.getInstance(context).getFirstTimeUsingApp()){

            var intent= Intent(context,WelcomeActivity::class.java)
            Handler().postDelayed({
                context.startActivity(intent)
                activity.finish()
            }, 2000)

        }else{*/

            var intent= Intent(context,MainActivity::class.java)
            Handler().postDelayed({
                context.startActivity(intent)
                activity.finish()
            }, 2000)

       // }


    }

}