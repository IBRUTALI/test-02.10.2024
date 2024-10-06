package com.ighorosipov.test_02102024.feature.devices.domain

import androidx.annotation.StringRes
import com.ighorosipov.test_02102024.R

enum class FilterTag(val title: String, @StringRes val resId: Int) {
    ALL("all", R.string.all),
    LIVE("live", R.string.live),
    APPROVED("approved", R.string.approved),
    MUTE("mute", R.string.mute),
    BLOCKED("blocked", R.string.blocked),
    DEAD("dead", R.string.dead)
}