package com.hardcodeflow.eroticstories.common

import android.app.Activity
import android.app.Dialog
import android.content.Intent

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Handler
import android.view.View

import android.view.Window
import android.view.WindowManager

import com.hardcodeflow.eroticstories.R
import kotlinx.android.synthetic.main.dialog_about.*
import kotlinx.android.synthetic.main.dialog_about.closeButton
import kotlinx.android.synthetic.main.dialog_about.shareButton
import kotlinx.android.synthetic.main.dialog_choose_gender_and_birthday.*
import kotlinx.android.synthetic.main.dialog_exit.*
import kotlinx.android.synthetic.main.dialog_choose_conversation_chat_mode.*
import kotlinx.android.synthetic.main.dialog_heart_break.*

enum class OkCancelDialogResult(s:Int){
    Exit(1),
    Cancel(2)

}

object  DialogManager {



    fun showAboutDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before

        dialog.setContentView(R.layout.dialog_about)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT

        dialog.closeButton.setOnClickListener {
            dialog.dismiss()

        }

        dialog.shareButton.setOnClickListener {

            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            var url= Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())
            val shareBody = "Download English Cards Lite And Improve your English Speaking\n"+url
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            activity.startActivity(Intent.createChooser(sharingIntent, "Share via"))

        }

        //sharedPref.setFirstLaunch(false)
        dialog.show()
        dialog.window!!.attributes = lp
    }

    fun showHeartBreakDialog(activity: Activity,message:String) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before
        dialog.setCanceledOnTouchOutside(false);

        dialog.setContentView(R.layout.dialog_heart_break)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.heartBreakMessage.text=message
        Handler().postDelayed({
            dialog.dismiss()
        }, 2000)

        dialog.show()
        dialog.window!!.attributes = lp
    }

    fun showChooseConversationChatModeLoading(dialog:Dialog) {
        // val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before

        dialog.setContentView(R.layout.dialog_choose_conversation_chat_mode)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT

        dialog.chooseProgressBar.visibility= View.VISIBLE
        dialog.progressTextView.visibility= View.VISIBLE

        dialog.microphoneImageView.visibility= View.GONE
        dialog.askForMicrophoneTextView.visibility= View.GONE
        dialog.buttonsHolder.visibility= View.GONE




        //sharedPref.setFirstLaunch(false)
        if(!dialog.isShowing)
            dialog.show()
        dialog.window!!.attributes = lp
    }


    fun showChooseConversationChatMode(dialog:Dialog,listener: (result:OkCancelDialogResult)->Unit) {
       // val dialog = Dialog(activity)
        /*dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before

        dialog.setContentView(R.layout.dialog_choose_conversation_chat_mode)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        */
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT

        dialog.chooseProgressBar.visibility= View.GONE
        dialog.progressTextView.visibility= View.GONE

        dialog.microphoneImageView.visibility= View.VISIBLE
        dialog.askForMicrophoneTextView.visibility= View.VISIBLE
        dialog.buttonsHolder.visibility= View.VISIBLE


        dialog.buttonMicCancel.setOnClickListener {
            listener(OkCancelDialogResult.Cancel)
            dialog.dismiss()

        }
        dialog.buttonMicOk.setOnClickListener {
            listener(OkCancelDialogResult.Exit)
            dialog.dismiss()

        }



        //sharedPref.setFirstLaunch(false)
        if(!dialog.isShowing)
            dialog.show()
        dialog.window!!.attributes = lp
    }



     fun showExitActivity(activity:Activity,listener: (result:OkCancelDialogResult)->Unit) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before

        dialog.setContentView(R.layout.dialog_exit)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT



         dialog.buttonCancel.setOnClickListener {
             listener(OkCancelDialogResult.Cancel)
             dialog.dismiss()

         }
         dialog.buttonExit.setOnClickListener {
             listener(OkCancelDialogResult.Exit)
             dialog.dismiss()

         }



        //sharedPref.setFirstLaunch(false)
        dialog.show()
        dialog.window!!.attributes = lp
    }
}