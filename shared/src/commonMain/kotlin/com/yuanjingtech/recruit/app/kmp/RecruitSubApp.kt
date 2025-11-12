package com.yuanjingtech.recruit.app.kmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yuanjingtech.boot.app.kmp.subapp.SubApp

internal class RecruitSubApp : SubApp {
    override val id: String
        get() = "subapp_recruit"
    override val name: String
        get() = "招募"
    override val description: String
        get() = "招募"

    override fun content(): @Composable ((modifier: Modifier) -> Unit) {
        return { modifier ->
            RecruitScreen(modifier)
        }
    }

}