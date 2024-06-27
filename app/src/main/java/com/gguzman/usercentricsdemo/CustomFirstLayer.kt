package com.gguzman.usercentricsdemo

import androidx.annotation.ColorInt
import com.usercentrics.sdk.ButtonLayout
import com.usercentrics.sdk.FirstLayerStyleSettings
import com.usercentrics.sdk.HeaderImageSettings
import com.usercentrics.sdk.MessageSettings
import com.usercentrics.sdk.TitleSettings
import com.usercentrics.sdk.UsercentricsLayout

class CustomFirstLayer private constructor(){
    //region FIRST LAYER
    companion object {

        //region firstLayer GETTERS & SETTERS
        var firstLayerLayout: UsercentricsLayout?
            get() {
                return firstLayerObject._layout
            }
            set(value) {
                firstLayerObject._layout = value
            }

        var headerImage: HeaderImageSettings?
            get() {
                return firstLayerObject._headerImage
            }
            set(value) {
                firstLayerObject._headerImage = value
            }

        var title: TitleSettings?
            get() {
                return firstLayerObject._title
            }
            set(value) {
                firstLayerObject._title = value
            }

        var message: MessageSettings?
            get() {
                return firstLayerObject._message
            }
            set(value) {
                firstLayerObject._message = value
            }

        var btnLayout: ButtonLayout?
            get() {
                return firstLayerObject._btnLayout
            }
            set(value) {
                firstLayerObject._btnLayout = value
            }

        var bgColor: Int?
            get() {
                return firstLayerObject._bgColor
            }
            set(value) {
                firstLayerObject._bgColor = value
            }

        var cornerRadius: Int?
            get() {
                return firstLayerObject._cornerRadius
            }
            set(value) {
                firstLayerObject._cornerRadius = value
            }

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
    }
    //endregion
}