package com.solar.studybasic.kotlin

class LazyInitialization constructor(
    // lateinit var firstMsg: String   // X
) {
    /*lateinit val secondMsg: String  // X
    lateinit var thirdMsg: String?  // X

    lateinit var count: Int         // X
    lateinit var timeMills: Long    // X
    lateinit var isLoaded: Boolean  // X*/

    private val msg: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { "Message"}
    lateinit var adapter: String
}