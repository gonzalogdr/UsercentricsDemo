package com.gguzman.usercentricsdemo

import androidx.annotation.ColorInt
import com.usercentrics.sdk.ButtonLayout
import com.usercentrics.sdk.FirstLayerStyleSettings
import com.usercentrics.sdk.HeaderImageSettings
import com.usercentrics.sdk.MessageSettings
import com.usercentrics.sdk.TitleSettings
import com.usercentrics.sdk.UsercentricsLayout

class CustomFirstLayer{
    //region FIRST LAYER
    init {
        println("CustomFirstLayer object created")
    }

    //region firstLayer GETTERS & SETTERS

    /**
     * Select the Layout of the First Layer: Sheet, Popup Center, Popup Bottom, Full.
     */
    var firstLayerLayout: UsercentricsLayout?
        get() {
            return firstLayerObject._layout
        }
        set(value) {
            firstLayerObject._layout = value
        }

    /**
     * Customize the layout of the image at the top of your banner: .logo (default), .extended or .hidden.
     */
    var headerImage: HeaderImageSettings?
        get() {
            return firstLayerObject._headerImage
        }
        set(value) {
            firstLayerObject._headerImage = value
        }

    /**
     * Customize the appearance of the title label: Font, Text Size, Text Color and Text Alignment.
     */
    var title: TitleSettings?
        get() {
            return firstLayerObject._title
        }
        set(value) {
            firstLayerObject._title = value
        }

    /**
     * Customize the appearance of the message label: Font, Text Size, Text Color, Text Alignment,
     * Link Text Color and Link Text Underline.
     */
    var message: MessageSettings?
        get() {
            return firstLayerObject._message
        }
        set(value) {
            firstLayerObject._message = value
        }

    /**
     * Customize the layout of the action buttons: .column (default), .grid, .row.
     * You may also pass an array of ButtonSettings to define the order and appearance of the buttons.
     */
    var btnLayout: ButtonLayout?
        get() {
            return firstLayerObject._btnLayout
        }
        set(value) {
            firstLayerObject._btnLayout = value
        }

    /**
     * Edit the color of the First Layer background.
     */
    var bgColor: Int?
        get() {
            return firstLayerObject._bgColor
        }
        set(value) {
            firstLayerObject._bgColor = value
        }

    /**
     * Edit the corner radius of the banner.
     */
    var cornerRadius: Int?
        get() {
            return firstLayerObject._cornerRadius
        }
        set(value) {
            firstLayerObject._cornerRadius = value
        }

    /**
     * Edit the color of the First Layer overlay.
     */
    var overlayColor: Int?
        get() {
            return firstLayerObject._overlayColor
        }
        set(value) {
            firstLayerObject._overlayColor = value
        }
    //endregion

    data class FirstLayer(var _layout: UsercentricsLayout? = null, var _headerImage: HeaderImageSettings? = null, var _title: TitleSettings? = null, var _message: MessageSettings? = null,
                          var _btnLayout: ButtonLayout? = null, @ColorInt var _bgColor: Int? = null, var _cornerRadius: Int? = null, @ColorInt var _overlayColor: Int? = null)
    private val firstLayerObject = FirstLayer()

    fun getFirstLayerSettings(): FirstLayerStyleSettings{
        return FirstLayerStyleSettings(
            firstLayerLayout, headerImage, title, message,
            btnLayout, bgColor, cornerRadius, overlayColor
        )
    }
    //endregion
}