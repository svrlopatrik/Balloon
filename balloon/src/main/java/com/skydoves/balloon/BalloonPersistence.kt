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

import android.annotation.SuppressLint
import android.content.Context

/** BalloonPreferenceManager helps to persist showing counts. */
internal class BalloonPersistence private constructor(context: Context) {

  private val sharedPreferenceManager by lazy {
    context.getSharedPreferences("com.skydoves.balloon", Context.MODE_PRIVATE)
  }

  /** should show or not the popup. */
  fun shouldShowUp(name: String, counts: Int): Boolean {
    return getPersistedCounts(name) < counts
  }

  /** puts a incremented show-up counts to the preference. */
  fun putIncrementedCounts(name: String) {
    putCounts(name, getPersistedCounts(name) + 1)
  }

  /** puts show-up counts to the preference. */
  fun putCounts(name: String, counts: Int) {
    sharedPreferenceManager.edit().putInt(getPersistName(name), counts).apply()
  }

  /** clear all preferences. */
  @SuppressLint("ApplySharedPref")
  fun clearAllPersistence() {
    sharedPreferenceManager.edit().clear().commit()
  }

  /** clear single preference. */
  @SuppressLint("ApplySharedPref")
  fun clearPreference(name: String) {
    sharedPreferenceManager.edit().remove(getPersistName(name)).commit()
  }

  /** gets show-up counts from the preference. */
  private fun getPersistedCounts(name: String): Int {
    return sharedPreferenceManager.getInt(getPersistName(name), 0)
  }

  private fun getPersistName(name: String) = SHOWED_UP + name

  companion object : SingletonHolder<BalloonPersistence, Context>(::BalloonPersistence) {
    private const val SHOWED_UP = "SHOWED_UP"
  }
}
