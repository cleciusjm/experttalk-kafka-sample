package experttalk.kafka.sample

import kotlinx.coroutines.delay
import org.apache.kafka.clients.producer.ProducerRecord

suspend fun main() {
    with(Kafka().producer) {
        val amount = 1000
        println("Produzindo $amount mensagens para $DEFAULT_TOPIC")
        for (i in (0..amount)) {
            send(ProducerRecord(DEFAULT_TOPIC, "msg $i"))
            delay(500)
        }
    }
}