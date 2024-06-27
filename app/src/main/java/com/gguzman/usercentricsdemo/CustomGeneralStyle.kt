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

class CustomGeneralStyle(){
    //region GENERAL STYLE
    init {
        println("CustomGeneralStyle object created")
    }
    //region General Style GETTERS & SETTERS

    /**
     * Edit the color for the borders of the Category and Services content section,
     * Category and Service components and Service Information Tags.
     */
    var bordersColor: Int?
        get() {
            return generalStyleObject._bordersColor
        }
        set(value) {
            generalStyleObject._bordersColor = value
        }

    /**
     * Disable system back button.
     */
    var disableSystemBackBtn: Boolean?
        get() {
            return generalStyleObject._disableSystemBackBtn
        }
        set(value) {
            generalStyleObject._disableSystemBackBtn = value
        }

    /**
     * Pass both Regular and Bold fonts to be used in the banner.
     */
    var font: BannerFont?
        get() {
            return generalStyleObject._font
        }
        set(value) {
            generalStyleObject._font = value
        }

    /**
     * Edit the color of the First Layer, and Header and Footer of the Second Layer.
     */
    var layerBgColor: Int?
        get() {
            return generalStyleObject._layerBgColor
        }
        set(value) {
            generalStyleObject._layerBgColor = value
        }

    /**
     * Edit the color of the background in the content section.
     */
    var layerBgSecondColor: Int?
        get() {
            return generalStyleObject._layerBgSecondColor
        }
        set(value) {
            generalStyleObject._layerBgSecondColor = value
        }

    /**
     * Edit the color of all available links.
     */
    var linkColor: Int?
        get() {
            return generalStyleObject._linkColor
        }
        set(value) {
            generalStyleObject._linkColor = value
        }

    /**
     * Customize the visibility of the legal links: .both (default),
     * .firstLayerOnly, .secondLayerOnly and .hidden.
     */
    var links: LegalLinksSettings?
        get() {
            return generalStyleObject._links
        }
        set(value) {
            generalStyleObject._links = value
        }

    /**
     * Pass a local image to be rendered as a logo in both First Layer and Second Layer.
     */
    var logo: UsercentricsImage?
        get() {
            return generalStyleObject._logo
        }
        set(value) {
            generalStyleObject._logo = value
        }

    /**
     * Edit the color of the status bar when the banner is displayed.
     */
    var statusBarColor: Int?
        get() {
            return generalStyleObject._statusBarColor
        }
        set(value) {
            generalStyleObject._statusBarColor = value
        }

    /**
     * Edit the color of the Category and Services Tabs.
     */
    var tabColor: Int?
        get() {
            return generalStyleObject._tabColor
        }
        set(value) {
            generalStyleObject._tabColor = value
        }

    /**
     * Edit the text color for both First Layer and Second Layer.
     */
    var textColor: Int?
        get() {
            return generalStyleObject._textColor
        }
        set(value) {
            generalStyleObject._textColor = value
        }

    /**
     * Edit the toggle colors for: Active, Inactive and Disabled states.
     */
    var toggleStyleSettings: ToggleStyleSettings?
        get() {
            return generalStyleObject._toggleStyleSettings
        }
        set(value) {
            generalStyleObject._toggleStyleSettings = value
        }

    /**
     * Enable/Disable Banner in fullscreen mode.
     */
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
    //endregion
}