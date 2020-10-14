package experttalk.kafka.sample

import org.apache.kafka.clients.producer.ProducerRecord
import java.time.Duration

fun main() {
    with(Kafka().consumer) {
        subscribe(listOf(DEFAULT_TOPIC))
        for (message in poll(Duration.ofMinutes(1))) {
            println("Recebida: $message")
        }
    }
}