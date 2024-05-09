/*
 *     Pentris/Pentris.app.main
 *     Type.kt Copyrighted by Yamin Siahmargooei at 2024/5/9
 *     Type.kt Last modified at 2024/5/9
 *     This file is part of Pentris/Pentris.app.main.
 *     Copyright (C) 2024  Yamin Siahmargooei
 *
 *     Pentris/Pentris.app.main is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Pentris/Pentris.app.main is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Pentris.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.yamin8000.pentris.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import io.github.yamin8000.pentris.R

private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val font = FontFamily(
    Font(
        googleFont = GoogleFont("Vazirmatn"),
        fontProvider = provider,
    )
)

private val baseline = Typography()

internal val typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = font),
    displayMedium = baseline.displayMedium.copy(fontFamily = font),
    displaySmall = baseline.displaySmall.copy(fontFamily = font),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = font),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = font),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = font),
    titleLarge = baseline.titleLarge.copy(fontFamily = font),
    titleMedium = baseline.titleMedium.copy(fontFamily = font),
    titleSmall = baseline.titleSmall.copy(fontFamily = font),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = font),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = font),
    bodySmall = baseline.bodySmall.copy(fontFamily = font),
    labelLarge = baseline.labelLarge.copy(fontFamily = font),
    labelMedium = baseline.labelMedium.copy(fontFamily = font),
    labelSmall = baseline.labelSmall.copy(fontFamily = font),
)
