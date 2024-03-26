import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable

@Serializable
data class DiscordMessage(val content: String)

fun main() {
    val client = HttpClient {
        install(WebSockets)
    }

    embeddedServer(Netty, port = 8080) {
        install(io.ktor.features.ContentNegotiation) {
            // JSON serialization
            // Pomocne biblioteki: Gson, kotlinx.serialization, itp.
        }
        routing {
            get("/categories") {
                // Obsługa żądania zwracającego listę kategorii
                val categories = listOf("Kategoria 1", "Kategoria 2", "Kategoria 3")
                call.respond(categories)
            }
        }
    }.start(wait = true)

    // Wysyłanie wiadomości do Discorda
    val botToken = "TWÓJ_TOKEN_BOTA"
    val channelId = "ID_KANAŁU"
    val message = DiscordMessage("Testowa wiadomość")
    runBlocking {
        sendMessageToDiscord(botToken, channelId, message)
    }
}

// suspend fun sendMessageToDiscord(botToken: String, channelId: String, message: DiscordMessage) {
//     val client = HttpClient {
//         install(WebSockets)
//     }

//     client.use { httpClient ->
//         httpClient.post<HttpResponse>("https://discord.com/api/v9/channels/$channelId/messages") {
//             headers {
//                 append("Authorization", "Bot $botToken")
//                 append("Content-Type", "application/json")
//             }
//             body = message
//         }
//     }
// }
