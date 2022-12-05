/*
 * Copyright 2022 Maximillian Leonov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maximillianleonov.blurimage.transformation

import android.graphics.Bitmap
import coil.size.Size
import coil.transform.Transformation
import com.google.android.renderscript.Toolkit

/**
 * A custom Coil transformation for blurring images.
 */
internal class BlurTransformation(private val radius: Int) : Transformation {
    override val cacheKey: String = "${javaClass.name}-$radius"

    override suspend fun transform(input: Bitmap, size: Size): Bitmap =
        Toolkit.blur(inputBitmap = input, radius = radius)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return other is BlurTransformation && radius == other.radius
    }

    override fun hashCode(): Int = radius.hashCode()
}
