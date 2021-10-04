package com.hardcodeflow.eroticstories.common

import android.app.Activity
import android.app.Dialog
import android.content.*
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Point
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.util.TypedValue
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.hardcodeflow.eroticstories.R
import java.net.URI
import java.net.URISyntaxException
import java.text.SimpleDateFormat
import java.util.*

object Tools {


        val REQUEST_RECORD_AUDIO:Int=1001
        val REQUEST_READ_EXTERNAL_STORAGE:Int=2
        val EXTRA_DECK_ID:String="EXTRA_DECK_ID"

    fun getScreenDimensions(activity:Activity){
        val columnWidth: Int
        val wm = activity
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val point = Point()
        point.x = display.width
        point.y = display.height
        columnWidth = point.x
        AppSettings.screenWidth=point.x.toFloat()
        AppSettings.screenHeight=point.y.toFloat()

        Log.d("ROK","screen dimensions: "+AppSettings.screenWidth+"x"+AppSettings.screenHeight)

    }
    fun requestPermission(activity: Activity?, permission: String,requestCode:Int) {
            if (ContextCompat.checkSelfPermission(activity!!, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode)
            }


        }
        fun distanceBetweenStrings( s1:String,s2:String):Int
{
        var distance=0;
    val re = Regex("[^A-Za-z0-9 ]")

    var s1Clean =re.replace(s1, "").trim().toLowerCase()
    var s2Clean  =re.replace(s2, "").trim().toLowerCase()
    if(s1Clean.equals(s2Clean)){
        return 0
    }





    for(i in s1.indices){
        Log.d("UTILS","s1 -> "+s1[i]+" "+s1[i].toChar().toInt())

        distance+=s1[i].toChar().toInt()

    }
    for(i in s2.indices){
        Log.d("UTILS","s2 -> "+s2[i]+" "+s2[i].toChar().toInt())
        distance-=s2[i].toChar().toInt()

    }
    if(distance<0) return distance*-1
    return distance;
}




        fun permissionGranted(activity: Activity?, permission: String) :Boolean{
            if (ContextCompat.checkSelfPermission(activity!!, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
            return true

        }

        /*
        fun wait(millis: Int, callback: Runnable?) {
            HANDLER.postDelayed(callback, millis.toLong())
        }*/

        fun setSystemBarPrimaryColor(act: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = act.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = ContextCompat.getColor(act, R.color.colorPrimary)
            }
        }
    fun setSystemBarWhiteColor(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = act.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(act, R.color.white)
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
        fun setSystemBarColor(act: Activity,  color: Int,x:Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = act.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor =color

            }
        }
        fun setSystemBarColorInt(act: Activity, @ColorInt color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = act.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = color
            }
        }

        fun setSystemBarColorDialog(
            act: Context,
            dialog: Dialog, @ColorRes color: Int
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = dialog.window
                window!!.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = act.resources.getColor(color)
            }
        }

        fun setSystemBarLight(act: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val view = act.findViewById<View>(R.id.content)
                var flags = view.systemUiVisibility
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                view.systemUiVisibility = flags
            }
        }

        fun setSystemBarLightDialog(dialog: Dialog) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val view =
                    dialog.findViewById<View>(R.id.content)
                var flags = view.systemUiVisibility
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                view.systemUiVisibility = flags
            }
        }

        fun clearSystemBarLight(act: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val window = act.window
                window.statusBarColor = ContextCompat.getColor(act, R.color.colorPrimaryDark)
            }
        }

        /**
         * Making notification bar transparent
         */
        fun setSystemBarTransparent(act: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = act.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            }
        }

        fun displayImageOriginal(
            ctx: Context?,
            img: ImageView?, @DrawableRes drawable: Int
        ) {
            try {
               /* Glide.with(ctx).load(drawable)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(img)*/
            } catch (e: Exception) {
            }
        }

        fun displayImageRound(
            ctx: Context,
            img: ImageView, @DrawableRes drawable: Int
        ) {
            try {
               /* Glide.with(ctx).load(drawable).asBitmap().centerCrop()
                    .into(object : BitmapImageViewTarget(img) {
                        override fun setResource(resource: Bitmap) {
                            val circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(ctx.resources, resource)
                            circularBitmapDrawable.isCircular = true
                            img.setImageDrawable(circularBitmapDrawable)
                        }
                    })*/
            } catch (e: Exception) {
            }
        }

        fun displayImageOriginal(
            ctx: Context?,
            img: ImageView?,
            url: String?
        ) {
            try {
               /* Glide.with(ctx).load(url)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(img)*/

            } catch (e: Exception) {
            }
        }

        fun getFormattedDateShort(dateTime: Long?): String? {
            val newFormat = SimpleDateFormat("MMM dd, yyyy")
            return newFormat.format(Date(dateTime!!))
        }

        fun getFormattedDateSimple(dateTime: Long?): String? {
            val newFormat = SimpleDateFormat("MMMM dd, yyyy")
            return newFormat.format(Date(dateTime!!))
        }

        fun getFormattedDateEvent(dateTime: Long?): String? {
            val newFormat = SimpleDateFormat("EEE, MMM dd yyyy")
            return newFormat.format(Date(dateTime!!))
        }

        fun getFormattedTimeEvent(time: Long?): String? {
            val newFormat = SimpleDateFormat("h:mm a")
            return newFormat.format(Date(time!!))
        }

        fun getEmailFromName(name: String?): String? {
            return if (name != null && name != "") {
                name.replace(" ".toRegex(), ".").toLowerCase() + "@mail.com"
            } else name
        }

        fun dpToPx(c: Context, dp: Int): Int {
            val r = c.resources
            return Math.round(
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dp.toFloat(),
                    r.displayMetrics
                )
            )
        }


        fun copyToClipboard(context: Context, data: String?) {
            val clipboard =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("clipboard", data)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        fun nestedScrollTo(nested: NestedScrollView, targetView: View) {
            nested.post { nested.scrollTo(500, targetView.bottom) }
        }

        fun dip2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }

        fun px2dip(context: Context, pxValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (pxValue / scale + 0.5f).toInt()
        }

        fun toggleArrow(view: View): Boolean {
            return if (view.rotation == 0f) {
                view.animate().setDuration(200).rotation(180f)
                true
            } else {
                view.animate().setDuration(200).rotation(0f)
                false
            }
        }

        fun toggleArrow(show: Boolean, view: View): Boolean {
            return toggleArrow(show, view, true)
        }

        fun toggleArrow(
            show: Boolean,
            view: View,
            delay: Boolean
        ): Boolean {
            return if (show) {
                view.animate().setDuration(if (delay) 200 else 0.toLong()).rotation(180f)
                true
            } else {
                view.animate().setDuration(if (delay) 200 else 0.toLong()).rotation(0f)
                false
            }
        }

        fun changeNavigateionIconColor(toolbar: Toolbar, @ColorInt color: Int) {
            val drawable = toolbar.navigationIcon
            drawable!!.mutate()
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }

        fun changeMenuIconColor(menu: Menu, @ColorInt color: Int) {
            for (i in 0 until menu.size()) {
                val drawable = menu.getItem(i).icon ?: continue
                drawable.mutate()
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            }
        }

        fun changeOverflowMenuIconColor(toolbar: Toolbar, @ColorInt color: Int) {
            try {
                val drawable = toolbar.overflowIcon
                drawable!!.mutate()
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            } catch (e: Exception) {
            }
        }

        fun getScreenWidth(): Int {
            return Resources.getSystem().displayMetrics.widthPixels
        }

        fun getScreenHeight(): Int {
            return Resources.getSystem().displayMetrics.heightPixels
        }

        fun toCamelCase(input: String): String? {
            var input = input
            input = input.toLowerCase()
            val titleCase = StringBuilder()
            var nextTitleCase = true

            for ( c in input.toCharArray()) {
                var tempc=c
                if (Character.isSpaceChar(c)) {
                    nextTitleCase = true
                } else if (nextTitleCase) {
                    tempc = Character.toTitleCase(c)
                    nextTitleCase = false
                }
                titleCase.append(tempc)
            }
            return titleCase.toString()
        }

        fun insertPeriodically(
            text: String,
            insert: String,
            period: Int
        ): String? {
            val builder =
                StringBuilder(text.length + insert.length * (text.length / period) + 1)
            var index = 0
            var prefix = ""
            while (index < text.length) {
                builder.append(prefix)
                prefix = insert
                builder.append(text.substring(index, Math.min(index + period, text.length)))
                index += period
            }
            return builder.toString()
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

        /**
         * For device info parameters
         */
        fun getDeviceName(): String? {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                model
            } else {
                "$manufacturer $model"
            }
        }

        fun getAndroidVersion(): String? {
            return Build.VERSION.RELEASE + ""
        }

        fun getVersionCode(ctx: Context): Int {
            return try {
                val manager = ctx.packageManager
                val info = manager.getPackageInfo(ctx.packageName, 0)
                info.versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                -1
            }
        }


        fun getVersionName(ctx: Context): String? {
            return try {
                val manager = ctx.packageManager
                val info = manager.getPackageInfo(ctx.packageName, 0)
                ctx.getString(R.string.app_version) + " " + info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                ctx.getString(R.string.version_unknown)
            }
        }

        fun getVersionNamePlain(ctx: Context): String? {
            return try {
                val manager = ctx.packageManager
                val info = manager.getPackageInfo(ctx.packageName, 0)
                info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                ctx.getString(R.string.version_unknown)
            }
        }

        fun getDeviceID(context: Context): String? {
            var deviceID = Build.SERIAL
            if (deviceID == null || deviceID.trim { it <= ' ' }.isEmpty() || deviceID == "unknown") {
                try {
                    deviceID = Settings.Secure.getString(
                        context.contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                } catch (e: Exception) {
                }
            }
            return deviceID
        }

        fun getFormattedDateOnly(dateTime: Long?): String? {
            val newFormat = SimpleDateFormat("dd MMM yy")
            return newFormat.format(Date(dateTime!!))
        }

        fun directLinkToBrowser(activity: Activity, url: String?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                activity.startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(activity, "Ops, Cannot open url", Toast.LENGTH_LONG).show()
            }
        }

        private fun appendQuery(uri: String?, appendQuery: String): String? {
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

        fun openInAppBrowser(
            activity: Activity?,
            url: String?,
            from_notif: Boolean
        ) {
            var url = url
            url = appendQuery(url, "t=" + System.currentTimeMillis())
            if (!URLUtil.isValidUrl(url)) {
                Toast.makeText(activity, "Ops, Cannot open url", Toast.LENGTH_LONG).show()
                return
            }
         //   ActivityWebView.navigate(activity, url, from_notif)
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
    }
