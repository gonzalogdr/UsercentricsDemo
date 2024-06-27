package com.gguzman.usercentricsdemo

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.usercentrics.sdk.BannerSettings
import com.usercentrics.sdk.PopupPosition
import com.usercentrics.sdk.SecondLayerStyleSettings
import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.UsercentricsBanner
import com.usercentrics.sdk.UsercentricsLayout
import com.usercentrics.sdk.UsercentricsOptions
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.models.common.UsercentricsLoggerLevel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private val YOUR_SETTINGS_ID = "Ebbizn5Jn2mbWD"
private val YOUR_RULESET_ID = "fXUmw96Il7APpG"

class MainActivity : AppCompatActivity() {

    //region Variable Definition
    private val showFirstLayerBtn by lazy {
        findViewById<View>(R.id.showFirstLayerBtn)
    }

    private val showSecondLayerBtn by lazy {
        findViewById<View>(R.id.showSecondLayerBtn)
    }

    private val options = UsercentricsOptions(
        //settingsId = YOUR_SETTINGS_ID, //YOUR_SETTINGS_ID
        loggerLevel = UsercentricsLoggerLevel.DEBUG,
        ruleSetId = YOUR_RULESET_ID
        /*
        More parameters:
        - ruleSetID --> If we are using geolocation rules
        - version
        - defaultLanguage,
        - LoggerLevel,
        ...
         */
    )

    private var banner: UsercentricsBanner ?= null

    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        enableEdgeToEdge()

        setButtonListeners()

        //region Usercentrics initialization
        initUsercentricsSDK(this, options)
        isUsercentricsReady()
        //endregion
    }

    override fun onDestroy() {
        banner?.dismiss()
        banner = null
        super.onDestroy()
    }

    private fun setButtonListeners(){
        showFirstLayerBtn.setOnClickListener {
            showFirstLayer()
        }
        showSecondLayerBtn.setOnClickListener {
            showSecondLayer()
        }
    }

    private fun showFirstLayer(){
        CustomGeneralStyle.layerBgColor = Color.BLUE
        CustomFirstLayer.firstLayerLayout = UsercentricsLayout.Popup(PopupPosition.CENTER)
        CustomFirstLayer.bgColor = Color.YELLOW
        val settings = BannerSettings(firstLayerStyleSettings = CustomFirstLayer.getFirstLayerSettings(), secondLayerStyleSettings = CustomSecondLayer.getSecondLayerSettings(), generalStyleSettings = CustomGeneralStyle.getGeneralStyleSettings())

        banner = UsercentricsBanner(this, settings)
        banner?.showFirstLayer() { usercentricsConsentUserResponse ->
            applyAcceptedConsents(usercentricsConsentUserResponse?.consents)
        }
    }

    private fun showSecondLayer() {
        CustomSecondLayer.showCloseBtn = false
        val settings = BannerSettings(firstLayerStyleSettings = CustomFirstLayer.getFirstLayerSettings(), secondLayerStyleSettings = CustomSecondLayer.getSecondLayerSettings(), generalStyleSettings = CustomGeneralStyle.getGeneralStyleSettings())

        banner = UsercentricsBanner(this, settings)
        banner?.showSecondLayer {
            usercentricsConsentUserResponse -> Log.d("Usercentrics", "Second layer consents: " + usercentricsConsentUserResponse?.consents)
        }
    }

    private fun applyAcceptedConsents(consents: List<UsercentricsServiceConsent>?) {
        consents?.forEach { service ->
            when (service.templateId) {
                /*"diWdt4yLB" -> { // Google Analytics for Firebase Template ID

                    // Google Firebase Consent Mode API
                    val firebaseConsentStatus = if (service.status) ConsentStatus.GRANTED else ConsentStatus.DENIED
                    Firebase.analytics.setConsent {
                        analyticsStorage(firebaseConsentStatus)
                        adStorage(firebaseConsentStatus)
                    }
                    initializeFirebase()

                }
                // Other Service Template ID
                "x-XXXxXx" -> {
                    // Initialize or pass consent to framework with service.status
                }
                else -> {
                    // Log a warning if a service was not caught or do nothing
                }*/
            }
        }
    }

    private fun isUsercentricsReady() {
        Usercentrics.isReady(onSuccess = { status ->
            if (status.shouldCollectConsent) {
                //collectConsents() --> How to configure banner and show
                //Show first layer to collect consent
                showFirstLayer()
            } else {
                //applyConsents()
                //Apply existing consents
                applyAcceptedConsents(status.consents)
            }
            enableButtons(true)
        }, onFailure =  { error ->
            error.printStackTrace()
        })
    }

    // Creates a coroutine to initialize UC SDK avoiding potential issues blocking main thread
    private fun initUsercentricsSDK(context: Context, options: UsercentricsOptions) = runBlocking {
        launch {
            Usercentrics.initialize(context, options)
        }
    }

    private fun enableButtons(value: Boolean) {
        showFirstLayerBtn.isEnabled = value
        showSecondLayerBtn.isEnabled = value
    }
}