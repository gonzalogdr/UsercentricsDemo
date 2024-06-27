package com.gguzman.usercentricsdemo

import androidx.annotation.ColorInt
import com.usercentrics.sdk.ButtonLayout
import com.usercentrics.sdk.FirstLayerStyleSettings
import com.usercentrics.sdk.HeaderImageSettings
import com.usercentrics.sdk.MessageSettings
import com.usercentrics.sdk.SecondLayerStyleSettings
import com.usercentrics.sdk.TitleSettings
import com.usercentrics.sdk.UsercentricsLayout

class CustomSecondLayer(){
    //region SECOND LAYER
    //companion object {
    init {
        println("CustomSecondLayer object created")
    }


    //region secondLayer GETTERS & SETTERS

    /**
     * Customize the layout of the action buttons: .column (default), .grid, .row.
     * You may also pass an array of ButtonSettings to define the order and appearance of the buttons.
     */
    var buttonLayout: ButtonLayout?
        get() {
            return secondLayerObject._btnLayout
        }
        set(value) {
            secondLayerObject._btnLayout = value
        }

    /**
     * Show a close button in the Second Layer to allow users to dismiss the banner without editing consent.
     */
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
    //endregion
}