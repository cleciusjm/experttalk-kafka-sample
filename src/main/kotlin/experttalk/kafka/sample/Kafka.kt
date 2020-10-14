package experttalk.kafka.sample

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*

private const val STR_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer"
private const val STR_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer"
const val DEFAULT_TOPIC = "experttalk.sample.topic"

class Kafka(
        private val server: String = "localhost:9092",
        private val clientId: String = "kafka-sample"
) {

    val producer by lazy {
        KafkaProducer<String, String>(Properties().also {
            it[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = server
            it[ProducerConfig.CLIENT_ID_CONFIG] = clientId
            it[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = STR_SERIALIZER
            it[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = STR_SERIALIZER
        })
    }


    val consumer by lazy {
        KafkaConsumer<String, String>(Properties().also {
            it[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = server
            it[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = "true"
            it[ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG] = "1000"
            it[ConsumerConfig.GROUP_ID_CONFIG] = clientId
            it[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = STR_DESERIALIZER
            it[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = STR_DESERIALIZER
        })
    }

}