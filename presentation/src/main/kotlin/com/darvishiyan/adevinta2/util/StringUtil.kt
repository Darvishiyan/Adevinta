package com.darvishiyan.adevinta2.util

fun String.normalizeMobileImageUrl(imageSize: ImageSize) = "https://" + this.replace("m.mobile.de/yams-proxy/", "") + imageSize.rule