package experttalk.kafka.sample

import kotlinx.coroutines.delay
import org.apache.kafka.clients.producer.ProducerRecord

suspend fun main() {
    with(Kafka().producer) {
        for (i in (0..10)) {
            send(ProducerRecord("experttalk.sample.topic", "msg $i"))
            delay(500)
        }
    }
}