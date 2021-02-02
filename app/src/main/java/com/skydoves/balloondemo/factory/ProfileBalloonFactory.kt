/*
 * Copyright (C) 2019 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.balloondemo.factory

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.createBalloon
import com.skydoves.balloondemo.BalloonUtils
import com.skydoves.balloondemo.R

class ProfileBalloonFactory : Balloon.Factory() {

  override fun create(context: Context, lifecycle: LifecycleOwner?): Balloon {
    return createBalloon(context) {
      setWidth(BalloonSizeSpec.WRAP)
      setHeight(BalloonSizeSpec.WRAP)
      setLayout(R.layout.layout_custom_profile)
      setArrowSize(10)
      setPadding(12)
      setArrowOrientation(ArrowOrientation.TOP)
      setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
      setArrowPosition(0.5f)
      isRtlSupport(BalloonUtils.isRtlLayout())
      setCornerRadius(4f)
      setElevation(6)
      setBackgroundColorResource(R.color.background800)
      setBalloonAnimation(BalloonAnimation.CIRCULAR)
      setDismissWhenTouchOutside(true)
      setDismissWhenShowAgain(true)
      setLifecycleOwner(lifecycle)
    }
  }
}
