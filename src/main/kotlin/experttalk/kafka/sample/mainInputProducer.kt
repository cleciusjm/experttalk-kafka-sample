package experttalk.kafka.sample

import org.apache.kafka.clients.producer.ProducerRecord

fun main() {
    with(Kafka().producer) {

        while (true) {
            print("Mensagem: ")
            val message = readLine() ?: continue
            send(ProducerRecord(DEFAULT_TOPIC, message))
        }
    }
}