package experttalk.kafka.sample

import java.time.Duration

fun main() = with(Kafka(clientId = "kafka-client2").consumer) {
    println("[Consumer2] Consumindo mensagens de $DEFAULT_TOPIC")
    subscribe(listOf(DEFAULT_TOPIC))
    while (true) {
        for (message in poll(Duration.ofDays(1))) {
            println("Recebida: ${message.value()}")
        }
    }
}