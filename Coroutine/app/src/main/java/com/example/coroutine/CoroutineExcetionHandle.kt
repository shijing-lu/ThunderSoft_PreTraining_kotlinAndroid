package com.example.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineExcetionHandle {
}

//fun main()= runBlocking{
//    println("this is the father coroutine")
//    launch {
//        println("this is the 1th coroutine")
//        delay(1000L)
//        throw NullPointerException()
//        launch {
//            println("this is the 1th's son coroutine")
//            delay(2000L)
//            println("1th's son coroutine completed!")
//        }
//        println(" 1th coroutine completed!")
//    }
//    launch {
//        println("this is the 2th coroutine")
//        delay(2000L)
//        println("2th coroutine completed!")
//    }
//    launch {
//        println("this is the 3th coroutine")
//        delay(2000L)
//        println("3th coroutine completed!")
//
//    }
//    delay(2000L)
//    println(" father coroutine completed!")
//}

//异常处理

//fun main()=runBlocking {
//    launch {
//        delay(1000L)
//        try {
//            throw NullPointerException()
//        }
//        catch (e: Exception){
//            e.printStackTrace()
//        }
//    }
//    delay(1000L)
//}

//全局处理异常

fun main()=runBlocking {
    val scope = CoroutineScope(Job() + CoroutineExceptionHandler { _, _ -> })
    scope.launch(CoroutineName("A")) {
        delay(1000L)
        throw NullPointerException()
    }
    launch(CoroutineName("B")) {
        delay(1000L)
        println("Coroutine B is compeled!")
    }
    delay(1000L)
}




