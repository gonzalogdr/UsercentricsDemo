package com.gguzman.usercentricsdemo

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.usercentrics.sdk.BannerSettings
import com.usercentrics.sdk.ButtonLayout
import com.usercentrics.sdk.ButtonSettings
import com.usercentrics.sdk.ButtonType
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

//region Usercentrics initialization
private val YOUR_SETTINGS_ID = "Ebbizn5Jn2mbWD"
private val YOUR_RULESET_ID = "fXUmw96Il7APpG"
//endregion

class MainActivity : AppCompatActivity() {

    //region Variable Definition
    private val showFirstLayerBtn by lazy {
        findViewById<View>(R.id.showFirstLayerBtn)
    }

    private val showSecondLayerBtn by lazy {
        findViewById<View>(R.id.showSecondLayerBtn)
    }

    //region Usercentrics initialization
    private val options = UsercentricsOptions(
        settingsId = YOUR_SETTINGS_ID, //YOUR_SETTINGS_ID
        loggerLevel = UsercentricsLoggerLevel.DEBUG,
        //ruleSetId = YOUR_RULESET_ID
        /*
        More parameters:
        - ruleSetID --> If we are using geolocation rules
        - version
        - defaultLanguage,
        - LoggerLevel,
        ...
         */
    )
    //endregion

    private var banner: UsercentricsBanner ?= null
    private var customFirstLayer: CustomFirstLayer? = null
    private var customSecondLayer: CustomSecondLayer? = null
    private var customGeneralStyle: CustomGeneralStyle? = null

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

        customFirstLayer = CustomFirstLayer()
        customSecondLayer = CustomSecondLayer()
        customGeneralStyle = CustomGeneralStyle()
    }

    override fun onDestroy() {
        banner?.dismiss()
        banner = null

        customFirstLayer = null
        customSecondLayer = null
        customGeneralStyle = null
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
        /*customGeneralStyle?.layerBgColor = Color.CYAN
        customGeneralStyle?.layerBgSecondColor = Color.YELLOW

        customFirstLayer?.firstLayerLayout = UsercentricsLayout.Popup(PopupPosition.CENTER)
        val settings = BannerSettings(firstLayerStyleSettings = customFirstLayer?.getFirstLayerSettings(), secondLayerStyleSettings = customSecondLayer?.getSecondLayerSettings(), generalStyleSettings = customGeneralStyle?.getGeneralStyleSettings())*/

        val customGeneralStyleA: CustomGeneralStyle = CustomGeneralStyle()
        customGeneralStyleA.layerBgColor = Color.CYAN

        val customGeneralStyleB: CustomGeneralStyle = CustomGeneralStyle()
        customGeneralStyleB.layerBgColor = Color.GREEN

        val settingsA = BannerSettings(generalStyleSettings = customGeneralStyleA.getGeneralStyleSettings())
        val settingsB = BannerSettings(generalStyleSettings = customGeneralStyleB.getGeneralStyleSettings())

        banner = UsercentricsBanner(this, getABTesting(settingsA, settingsB))
        banner?.showFirstLayer() { usercentricsConsentUserResponse ->
            applyAcceptedConsents(usercentricsConsentUserResponse?.consents)
        }
    }

    private fun showSecondLayer() {
        customSecondLayer?.showCloseBtn = false
        customSecondLayer?.buttonLayout = ButtonLayout.Row(
            listOf(
                ButtonSettings(
                    type = ButtonType.SAVE,
                    cornerRadius = 50,
                ),
                ButtonSettings(
                    type = ButtonType.ACCEPT_ALL,
                    cornerRadius = 50,
                ),
            )
        )
        val settings = BannerSettings(firstLayerStyleSettings = customFirstLayer?.getFirstLayerSettings(), secondLayerStyleSettings = customSecondLayer?.getSecondLayerSettings(), generalStyleSettings = customGeneralStyle?.getGeneralStyleSettings())

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

    //region Usercentrics initialization
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
    //endregion

    private fun enableButtons(value: Boolean) {
        showFirstLayerBtn.isEnabled = value
        showSecondLayerBtn.isEnabled = value
    }

    //region ABTesting
    /*
    To combine both Geolocation rulesets and ABTesting, enable ABTesting in every configuration.
    Users are distributed evenly according to the number of variants we set from Admin UI
     */

    private fun getABTesting(bannerSetingsA: BannerSettings, bannerSettingsB: BannerSettings): BannerSettings {
        val variant = Usercentrics.instance.getABTestingVariant()
        val abSettings = when(variant) {
            "variantA" -> {
                bannerSetingsA
            }
            "variantB" -> {
                bannerSettingsB
            }
            else -> {
                bannerSetingsA
            }
        }
        return abSettings
    }
    //endregion
}