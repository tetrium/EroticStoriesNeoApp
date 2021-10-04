package com.hardcodeflow.eroticstories.common

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.lang.Exception
import java.util.*

object TextToSpeechManager {

    private var tts: TextToSpeech? = null
    private var initSuccess=false

    fun speak(text:String){

        CustomLog.print(
            this,
            "android.os.Build.VERSION.SDK_INT  "+android.os.Build.VERSION.SDK_INT +" android.os.Build.VERSION_CODES.LOLLIPOP "+android.os.Build.VERSION_CODES.LOLLIPOP,
            Thread.currentThread().stackTrace[2].lineNumber
        )
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            try {
                tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
                CustomLog.print(
                    this,
                    "tts!!.speak",
                    Thread.currentThread().stackTrace[2].lineNumber
                )
            }catch (e:Exception){

                CustomLog.print(
                    this,
                    "tts!!.speak e "+e.message,
                    Thread.currentThread().stackTrace[2].lineNumber
                )
            }
        } else{

        }

    }
    fun canSpeak():Boolean{

        return initSuccess;
    }
    fun init(context: Context,listener:(successInit: Boolean)->Unit){
        if (android.os.Build.VERSION.SDK_INT< android.os.Build.VERSION_CODES.LOLLIPOP){
            listener(false)
        } else{
            tts = TextToSpeech(context, object:TextToSpeech.OnInitListener{


                override fun onInit(status: Int) {
                    if (status == TextToSpeech.SUCCESS) {
                        // set US English as language for tts
                        val result = tts!!.setLanguage(Locale.US)

                        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            listener(false)
                        } else {
                            initSuccess=true
                            listener(true)
                        }

                    } else {
                        Log.d("TTS", "Initilization Failed!")
                        listener(false)
                    }
                }


            })
        }




    }


}