package com.yuanjingtech.recruit.app.kmp

import com.yuanjingtech.boot.app.kmp.subapp.SubApp
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal val recruitModule = module {
    single { RecruitSubApp() } bind SubApp::class
}

@Suppress("unused")
@Module
@Configuration
class RecruitModule {
    val module get() = recruitModule
}