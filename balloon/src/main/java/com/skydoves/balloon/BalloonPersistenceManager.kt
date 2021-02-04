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

package com.skydoves.balloon

import android.content.Context

class BalloonPersistenceManager private constructor(context: Context) {

  private val persistence by lazy { BalloonPersistence.getInstance(context) }

  /**
   * Sets showing counts to reach its value immediately.
   *
   * @param preferenceName preference name for persisting showing counts.
   * @param showTimes value set by [Balloon.Builder.setShowCounts] otherwise [Int.MAX_VALUE].
   */
  fun setShowCountsReached(preferenceName: String, showTimes: Int = Int.MAX_VALUE) {
    persistence.putCounts(preferenceName, showTimes)
  }

  /**
   * Clear show times set by [Balloon.Builder.setShowCounts] for a single preference.
   *
   * @param preferenceName preference name for persisting showing counts.
   */
  fun clearPreference(preferenceName: String) {
    persistence.clearPreference(preferenceName)
  }

  /** Clear show times set by [Balloon.Builder.setShowCounts] for all preferences. */
  fun clearAllPreferences() {
    persistence.clearAllPersistence()
  }

  companion object : SingletonHolder<BalloonPersistenceManager, Context>(::BalloonPersistenceManager)
}
