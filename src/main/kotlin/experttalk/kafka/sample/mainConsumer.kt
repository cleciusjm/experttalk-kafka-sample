package experttalk.kafka.sample

import java.time.Duration

fun main() = with(Kafka().consumer) {
    println("[Consumer1] Consumindo mensagens de $DEFAULT_TOPIC")
    subscribe(listOf(DEFAULT_TOPIC))
    while (true) {
        for (message in poll(Duration.ofDays(1))) {
            println("Recebida: ${message.value()}")
        }
    }
}