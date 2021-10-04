package com.hardcodeflow.masteraudiorecorder.common
import android.R
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Point
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.webkit.URLUtil
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.gson.annotations.SerializedName
import com.hardcodeflow.eroticstories.common.ApplicationConfiguration
import java.io.UnsupportedEncodingException
import java.net.URI
import java.net.URISyntaxException


/*
 * ClickableString class
 */

class ClickableString (listener:View.OnClickListener ) : ClickableSpan() {
    var  mListener:View.OnClickListener?=null

    init{
        mListener = listener;
    }

    override fun  onClick( v:View) {
        mListener!!.onClick(v);
    }
}
object Util {

        private val HANDLER = Handler()

         val REQUEST_RECORD_AUDIO:Int=0
        val RQUEST_WRITE_EXTERNAL_STORAGE:Int=0
    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }
    fun <E : Enum<*>> getSerializedNameValue(e: E): String {
        try {
            return e.javaClass.getField(e.name).getAnnotation(SerializedName::class.java).value
        } catch (exception: NoSuchFieldException) {
            exception.printStackTrace()
        }

        return ""
    }
    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

         fun showTip(context:Context,view:View,wordText:String){

    }
        fun getScreenWidth(activity:Activity): Int {
            val columnWidth: Int
            val wm = activity
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val point = Point()
            point.x = display.width
            point.y = display.height
            columnWidth = point.x
            return columnWidth
        }


        fun convertUTF8ToString(s: String): String? {
            var out: String? = null
            out = try {
                String(s.toByteArray(charset("ISO-8859-1")), Charsets.UTF_8)
            } catch (e: UnsupportedEncodingException) {
                return null
            }
            return out
        }
        fun convertStringToUTF8(s: String): String? {
            var out: String? = null
            out = try {
                String(s.toByteArray(charset("UTF-8")), Charsets.ISO_8859_1)
            } catch (e: UnsupportedEncodingException) {
                return null
            }
            return out
        }
        fun   makeLinkSpan( text:CharSequence,  listener:View.OnClickListener) : SpannableString {
            var link =  SpannableString(text);
            link.setSpan( ClickableString(listener), 0, text.length,
                SpannableString.SPAN_INCLUSIVE_EXCLUSIVE);
            return link;
        }

        private fun appendQuery(
            uri: String,
            appendQuery: String
        ): String? {
            return try {
                val oldUri = URI(uri)
                var newQuery = oldUri.query
                if (newQuery == null) {
                    newQuery = appendQuery
                } else {
                    newQuery += "&$appendQuery"
                }
                val newUri = URI(
                    oldUri.scheme,
                    oldUri.authority,
                    oldUri.path, newQuery, oldUri.fragment
                )
                newUri.toString()
            } catch (e: Exception) {
                e.printStackTrace()
                uri
            }
        }
        fun changeOverflowMenuIconColor(toolbar: Toolbar, @ColorInt color: Int) {
            try {
                val drawable = toolbar.overflowIcon
                drawable!!.mutate()
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            } catch (e: java.lang.Exception) {
            }
        }

        fun setSystemBarLight(act: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val view =
                    act.findViewById<View>(R.id.content)
                var flags = view.systemUiVisibility
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                view.systemUiVisibility = flags
            }
        }
        fun setSystemBarColor(act: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = act.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = act.resources.getColor(R.color.background_dark)
            }
        }
        fun setSystemBarColor(act: Activity, @ColorRes color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = act.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = act.resources.getColor(color)
            }
        }

        fun getHostName(url: String?): String? {
            return try {
                val uri = URI(url)
                var new_url = uri.host
                if (!new_url.startsWith("www.")) new_url = "www.$new_url"
                new_url
            } catch (e: URISyntaxException) {
                if (e.message != null) {
                    Log.e("ERROR", e.message.toString())
                }
                url
            }
        }



        fun openInAppBrowser(
            activity: Activity,
            url: String,
            from_notif: Boolean
        ) {
            var url = url
            url = appendQuery(
                url,
                "t=" + System.currentTimeMillis()
            ).toString()
            if (!URLUtil.isValidUrl(url)) {
                Toast.makeText(activity, "Ops, Cannot open url", Toast.LENGTH_LONG).show()
                return
            }
           // ActivityWebView.navigate(activity, url, from_notif)
        }

        fun changeMenuIconColor(menu: Menu, @ColorInt color: Int) {
            for (i in 0 until menu.size()) {
                val drawable = menu.getItem(i).icon ?: continue
                drawable.mutate()
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            }
        }
        fun directLinkToBrowser(activity: Activity, url: String?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                activity.startActivity(intent)
            } catch (e: java.lang.Exception) {
                Toast.makeText(activity, "Ops, Cannot open url", Toast.LENGTH_LONG).show()
            }
        }

        fun rateAction(activity: Activity) {
            val uri =
                Uri.parse("market://details?id=" + activity.packageName)
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)
            try {
                activity.startActivity(goToMarket)
            } catch (e: ActivityNotFoundException) {
                activity.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + activity.packageName)
                    )
                )
            }
        }

        fun requestPermission(activity: Activity?, permission: String,requestCode:Int) {
            if (ContextCompat.checkSelfPermission(activity!!, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode)
            }
        }
        fun wait(millis: Int, callback: Runnable?) {
           // HANDLER.postDelayed(callback, millis.toLong())
        }

    fun isBrightColor(color: Int): Boolean {
        if (R.color.transparent == color) {
            return true
        }
        val rgb = intArrayOf(
            Color.red(color),
            Color.green(color),
            Color.blue(color)
        )
        val brightness = Math.sqrt(
            rgb[0] * rgb[0] * 0.241 + rgb[1] * rgb[1] * 0.691 + rgb[2] * rgb[2] * 0.068
        ).toInt()
        return brightness >= 200
    }

    fun getDarkerColor(color: Int): Int {
        val factor = 0.8f
        val a = Color.alpha(color)
        val r = Color.red(color)
        val g = Color.green(color)
        val b = Color.blue(color)
        return Color.argb(
            a,
            Math.max((r * factor).toInt(), 0),
            Math.max((g * factor).toInt(), 0),
            Math.max((b * factor).toInt(), 0)
        )
    }

    fun formatSeconds(seconds: Int): String? {
        return (getTwoDecimalsValue(seconds / 3600) + ":"
                + getTwoDecimalsValue(seconds / 60) + ":"
                + getTwoDecimalsValue(seconds % 60))
    }

    private fun getTwoDecimalsValue(value: Int): String {
        return if (value >= 0 && value <= 9) {
            "0$value"
        } else {
            value.toString() + ""
        }
    }
    fun fillScreenDimensions(activity:Activity){
        val columnWidth: Int
        val wm = activity
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val point = Point()
        point.x = display.width
        point.y = display.height
        columnWidth = point.x
        ApplicationConfiguration.screenWidth=point.x.toFloat()
        ApplicationConfiguration.screenHeight=point.y.toFloat()

        Log.d("ROK","screen dimensions: "+ApplicationConfiguration.screenWidth+"x"+ApplicationConfiguration.screenHeight)

    }
}