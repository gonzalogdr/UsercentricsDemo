package com.gguzman.usercentricsdemo

import androidx.annotation.ColorInt
import com.usercentrics.sdk.ButtonLayout
import com.usercentrics.sdk.FirstLayerStyleSettings
import com.usercentrics.sdk.HeaderImageSettings
import com.usercentrics.sdk.MessageSettings
import com.usercentrics.sdk.SecondLayerStyleSettings
import com.usercentrics.sdk.TitleSettings
import com.usercentrics.sdk.UsercentricsLayout

class CustomSecondLayer private constructor(){
    //region SECOND LAYER
    companion object {

        //region secondLayer GETTERS & SETTERS
        var buttonLayout: ButtonLayout?
            get() {
                return secondLayerObject._btnLayout
            }
            set(value) {
                secondLayerObject._btnLayout = value
            }

        var showCloseBtn: Boolean?
            get() {
                return secondLayerObject._showCloseBtn
            }
            set(value) {
                secondLayerObject._showCloseBtn = value
            }

        //endregion

        data class SecondLayer(var _btnLayout: ButtonLayout? = null, var _showCloseBtn: Boolean? = null)
        private val secondLayerObject = SecondLayer()

        fun getSecondLayerSettings(): SecondLayerStyleSettings{
            return SecondLayerStyleSettings(buttonLayout, showCloseBtn)
        }
    }
    //endregion
}