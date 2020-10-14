package experttalk.kafka.sample

import kotlinx.coroutines.delay
import org.apache.kafka.clients.producer.ProducerRecord

suspend fun main() {
    with(Kafka().producer) {
        for (i in (0..1000)) {
            send(ProducerRecord(DEFAULT_TOPIC, "msg $i"))
            delay(500)
        }
    }
}