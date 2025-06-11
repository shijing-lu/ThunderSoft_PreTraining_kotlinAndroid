package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

class suspendDemo {
}

 fun main(){
    GlobalScope.launch {
        fetchData()
//        val user = getUserInfo()
//        val friendList = getFriendList(user)
//        val feedList = getFeedList(friendList)
//        println(feedList)
    }
     sleep(4000L)
}
//挂起函数
suspend fun getUserInfo(): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }
    return "BoyCoder"
}
suspend fun getFriendList(user: String): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }
    return "Tom, Jack"
}
suspend fun getFeedList(list: String): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }
    return "{FeedList..}"
}


suspend fun fetchData()=coroutineScope {
    val Job1 = launch { delay(1000L) }
    val Job2 = launch { delay(1000L) }
    Job1.join()   // 等待用户数据
    Job2.join()   // 等待帖子数据
    print("ok!")

}




