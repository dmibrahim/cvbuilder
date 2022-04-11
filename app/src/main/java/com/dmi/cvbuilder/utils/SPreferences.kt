package com.dmi.cvbuilder.utils

import android.content.Context
import android.content.SharedPreferences
import com.dmi.cvbuilder.ui.activity.LoginActivity

private lateinit var sharedPref: SharedPreferences

class AppUtils {
    companion object {
        @JvmStatic
        fun setPref(activity: LoginActivity): SharedPreferences {
            sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
            return sharedPref
        }

        fun getPref(key: String): String? {
            return sharedPref.getString(key, "")
        }
    }
}


