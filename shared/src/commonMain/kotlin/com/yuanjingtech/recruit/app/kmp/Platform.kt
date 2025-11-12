package com.yuanjingtech.recruit.app.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform