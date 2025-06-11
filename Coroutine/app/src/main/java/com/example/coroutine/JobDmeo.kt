package com.example.coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class JobDmeo {
}
fun main() = runBlocking {
    val Job = launch {
        delay(1000L)
    }
    println("Active")
    Job.log()
    Job.cancel()
    println("cancelling")
    Job.log()
    delay(100L)
    println("cancelled")
    Job.log()
    delay(1500L)
}
/**
 * 打印Job的状态信息
 */
fun Job.log() {
    println("""================================
    isActive = $isActive
    isCancelled = $isCancelled
    isCompleted = $isCompleted
================================""")
}

