package com.gguzman.usercentricsdemo

import androidx.annotation.ColorInt
import com.usercentrics.sdk.BannerFont
import com.usercentrics.sdk.ButtonLayout
import com.usercentrics.sdk.FirstLayerStyleSettings
import com.usercentrics.sdk.GeneralStyleSettings
import com.usercentrics.sdk.HeaderImageSettings
import com.usercentrics.sdk.LegalLinksSettings
import com.usercentrics.sdk.MessageSettings
import com.usercentrics.sdk.TitleSettings
import com.usercentrics.sdk.ToggleStyleSettings
import com.usercentrics.sdk.UsercentricsImage
import com.usercentrics.sdk.UsercentricsLayout

class CustomGeneralStyle private constructor(){
    //region GENERAL STYLE
    companion object {

        //region General Style GETTERS & SETTERS
        var bordersColor: Int?
            get() {
                return generalStyleObject._bordersColor
            }
            set(value) {
                generalStyleObject._bordersColor = value
            }

        var disableSystemBackBtn: Boolean?
            get() {
                return generalStyleObject._disableSystemBackBtn
            }
            set(value) {
                generalStyleObject._disableSystemBackBtn = value
            }

        var font: BannerFont?
            get() {
                return generalStyleObject._font
            }
            set(value) {
                generalStyleObject._font = value
            }

        var layerBgColor: Int?
            get() {
                return generalStyleObject._layerBgColor
            }
            set(value) {
                generalStyleObject._layerBgColor = value
            }

        var layerBgSecondColor: Int?
            get() {
                return generalStyleObject._layerBgSecondColor
            }
            set(value) {
                generalStyleObject._layerBgSecondColor = value
            }

        var linkColor: Int?
            get() {
                return generalStyleObject._linkColor
            }
            set(value) {
                generalStyleObject._linkColor = value
            }

        var links: LegalLinksSettings?
            get() {
                return generalStyleObject._links
            }
            set(value) {
                generalStyleObject._links = value
            }

        var logo: UsercentricsImage?
            get() {
                return generalStyleObject._logo
            }
            set(value) {
                generalStyleObject._logo = value
            }

        var statusBarColor: Int?
            get() {
                return generalStyleObject._statusBarColor
            }
            set(value) {
                generalStyleObject._statusBarColor = value
            }

        var tabColor: Int?
            get() {
                return generalStyleObject._tabColor
            }
            set(value) {
                generalStyleObject._tabColor = value
            }

        var textColor: Int?
            get() {
                return generalStyleObject._textColor
            }
            set(value) {
                generalStyleObject._textColor = value
            }

        var toggleStyleSettings: ToggleStyleSettings?
            get() {
                return generalStyleObject._toggleStyleSettings
            }
            set(value) {
                generalStyleObject._toggleStyleSettings = value
            }

        var windowFullscreen: Boolean?
            get() {
                return generalStyleObject._windowFS
            }
            set(value) {
                generalStyleObject._windowFS = value
            }
        //endregion

        data class GeneralStyle(var _bordersColor: Int? = null, var _disableSystemBackBtn: Boolean? = null, var _font: BannerFont? = null, @ColorInt var _layerBgColor: Int? = null,
                                @ColorInt var _layerBgSecondColor: Int? = null, @ColorInt var _linkColor: Int? = null, var _links: LegalLinksSettings? = null, var _logo: UsercentricsImage? = null,
                                @ColorInt var _statusBarColor: Int? = null, @ColorInt var _tabColor: Int? = null, @ColorInt var _textColor: Int? = null, var _toggleStyleSettings: ToggleStyleSettings? = null,
                                var _windowFS: Boolean? = null)
        private val generalStyleObject = GeneralStyle()

        fun getGeneralStyleSettings(): GeneralStyleSettings{
            return GeneralStyleSettings(
                textColor, layerBgColor, layerBgSecondColor, linkColor, tabColor,
                bordersColor, toggleStyleSettings, font, logo, links, disableSystemBackBtn, statusBarColor, windowFullscreen
            )
        }
    }
    //endregion
}