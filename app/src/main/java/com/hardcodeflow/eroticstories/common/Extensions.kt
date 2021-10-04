package com.hardcodeflow.eroticstories.common

import android.content.Context
import android.text.Selection
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


fun Any.toast(context: Context) {
    Toast.makeText(context, this.toString(), Toast.LENGTH_LONG).show()
}
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(getAdapterPosition(), getItemViewType())
    }
    return this
}



fun TextView.makeLinks(parentView: ViewGroup, vararg links: Pair<String, View.OnClickListener>) {
    val spannableString = SpannableString(this.text)
    for (link in links) {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Selection.setSelection((view as TextView).text as Spannable, 0)
                view.invalidate()
                var linear= LinearLayout (view.context)

                // Create a new TextView instance programmatically
                val text_view: TextView = TextView(view.context)

                // Creating a LinearLayout.LayoutParams object for text view
                var params  =  android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT, // This will define text view width
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT // This will define text view height
                )

                // Add margin to the text view
                params.setMargins(0,0,0,0)

                // Now, specify the text view width and height (dimension)
                text_view.layoutParams = params


                // Put some padding on text view text
                text_view.setPadding(0,0,0,0)
                parentView.addView(text_view)
                var viewGroup=linear.getRootView() as ViewGroup

                Log.d("ROK","rootview:"+text_view.getRootView().toString())

                //Log.d("ROK",text_view.rootView)
                link.second.onClick(view)

            }
        }
        val startIndexOfLink = this.text.toString().indexOf(link.first)
        spannableString.setSpan(clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        //  spannableString.
    }
    this.movementMethod = LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}


