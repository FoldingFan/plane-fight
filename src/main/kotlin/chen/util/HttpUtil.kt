package chen.util

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

/**
 * @Author: chen
 * @Date: 2020/3/11 15:24
 * @VERSION 1.0
 *
 */
fun get(uri: String): HttpResponse<String> {
    val get = HttpRequest.newBuilder()
            .GET()
            .version(HttpClient.Version.HTTP_2)
            .uri(URI.create(uri))
            .build()
    val build = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()
    val sendAsync = build.sendAsync(get, HttpResponse.BodyHandlers.ofString())
    return sendAsync.get()
}

fun main() {
    val get = get("http://www.baidu.com")
    println(get.body())
}
