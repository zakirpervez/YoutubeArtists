package com.ofroad.android.app.exceptions

class ApiException(message: String, val statusCode: Int) : RuntimeException(message)