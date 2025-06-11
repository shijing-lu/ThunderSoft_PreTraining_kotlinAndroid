package com.example.coroutine


import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class Coroutinekt {
}
//    launch启动
//fun main() {
//
//    GlobalScope.launch {                // 1
//        println("Coroutine started!")   // 2
//        delay(1000L)                    // 3
//        println("Hello World!")         // 4
//    }
//    println("After launch!")            // 5
//    Thread.sleep(2000L)                 // 6
//    println("Process end!")             // 7
//
//}
//
//runBlocking启动
//fun main(){
//    runBlocking {
//        println("First:${Thread.currentThread().name}")
//        delay(1000L)
//        println("Hello First!")
//    }
//
//    runBlocking {
//        println("Second:${Thread.currentThread().name}")
//        delay(1000L)
//        println("Hello Second!")
//    }
//
//    runBlocking {
//        println("Third:${Thread.currentThread().name}")
//        delay(1000L)
//        println("Hello Third!")
//    }
//    println("Process end!")
//}

// Async 启动

    fun main() = runBlocking {
        println("In runBlocking:${Thread.currentThread().name}")
        val deferred: Deferred<String> = async {
            println("In async:${Thread.currentThread().name}")
            delay(1000L) // 模拟耗时操作
            return@async "Task completed!"
        }
        println("After async:${Thread.currentThread().name}")
        val result = deferred.await()
        println("Result is: $result")
    }


