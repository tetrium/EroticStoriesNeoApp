package com.hardcodeflow.eroticstories.ads

import android.app.Activity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

enum class AdResponse{
    Success,
    Failed,
    NoLoaded

}


class AdsManager {


    lateinit var  activity:Activity
    lateinit var  rewardedAd: RewardedAd
    var initialized=false
    var adLoaded=false


    companion object{
        //DEMO
     /*  var adAdaptativeId="ca-app-pub-3940256099942544/2247696110"
        var rewardedId="ca-app-pub-3940256099942544/5224354917"
        var bannerId="ca-app-pub-3940256099942544/9214589741"
*/
        //real
     var adAdaptativeId="ca-app-pub-2439011458733064/3761365004"
        var rewardedId="ca-app-pub-2439011458733064/5010867490"
        var bannerId="ca-app-pub-2439011458733064/3490542890"

    }

    fun createRewardedAd(activity:Activity,listener:()->Unit){

        this.activity=activity
        if(!initialized){

            MobileAds.initialize(activity)

            rewardedAd=RewardedAd(activity,rewardedId)
            initialized=true


        }

        if(!adLoaded){

            val adLoadCallBack=object:RewardedAdLoadCallback(){

                override fun onRewardedAdLoaded() {

                    adLoaded=true
                    listener()
                }


                override fun onRewardedAdFailedToLoad(p0: LoadAdError?) {
                   adLoaded=false

                    listener()
                }


            }

            rewardedAd.loadAd(AdRequest.Builder().build(),adLoadCallBack)

        }

    }




    fun loadRewardedAd(listener:(response:AdResponse)->Unit){

        var earned=false
        if(rewardedAd.isLoaded){

            val adCallback=object:RewardedAdCallback(){

                override fun onRewardedAdClosed() {
                    if(earned){

                        listener(AdResponse.Success)
                    }else{
                        listener(AdResponse.Failed)


                    }
                }
                override fun onUserEarnedReward(p0: RewardItem) {
                    earned=true
                }

                override fun onRewardedAdFailedToShow(p0: AdError?) {
                    listener(AdResponse.NoLoaded)
                }


            }
            rewardedAd.show(activity,adCallback)
        }else{
            listener(AdResponse.Failed)

        }

    }


}