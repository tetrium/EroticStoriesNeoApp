package com.hardcodeflow.eroticstories.common.customviews

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.hardcodeflow.eroticstories.R


object CustomToastManager {

    private fun toastFloating(activity: Activity) {
        val toast = Toast(activity.getApplicationContext())
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val custom_view: View =
            activity.getLayoutInflater().inflate(R.layout.toast_floating, null)
        custom_view.findViewById<View>(R.id.tv_undo).visibility = View.GONE
        custom_view.findViewById<View>(R.id.separator).visibility = View.GONE
        toast.view = custom_view
        toast.show()
    }

    private fun toastFloatingDark(activity: Activity) {
        val toast = Toast(activity.getApplicationContext())
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val custom_view: View =
            activity.getLayoutInflater().inflate(R.layout.toast_floating_dark, null)
        custom_view.findViewById<View>(R.id.tv_undo).visibility = View.GONE
        custom_view.findViewById<View>(R.id.separator).visibility = View.GONE
        toast.view = custom_view
        toast.show()
    }

    private fun toastFloatingImage(activity: Activity) {
        val toast = Toast(activity.getApplicationContext())
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val custom_view: View =
            activity.getLayoutInflater().inflate(R.layout.toast_floating_image, null)
        custom_view.findViewById<View>(R.id.tv_undo).visibility = View.GONE
        custom_view.findViewById<View>(R.id.separator).visibility = View.GONE
        toast.view = custom_view
        toast.show()
    }

    public fun toastIconError(activity: Activity, message:String) {
        val toast = Toast(activity.getApplicationContext())
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val custom_view: View =
            activity.getLayoutInflater().inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text =message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(
            R.drawable.ic_close
        )
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.getResources().getColor(R.color.red_300)
        )
        toast.view = custom_view
        toast.show()
    }

    private fun toastIconSuccess(activity: Activity) {
        val toast = Toast(activity.getApplicationContext())
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val custom_view: View =
            activity.getLayoutInflater().inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = "Success!"
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(
            R.drawable.ic_arrow_back
        )
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity. getResources().getColor(R.color.green)
        )
        toast.view = custom_view
        toast.show()
    }

    private fun toastIconInfo(activity: Activity) {
        val toast = Toast(activity.getApplicationContext())
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val custom_view: View =
            activity.getLayoutInflater().inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = "Some Info Text Here"
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(
            R.drawable.ic_library
        )
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.getResources().getColor(R.color.blue_500)
        )
        toast.view = custom_view
        toast.show()
    }

}