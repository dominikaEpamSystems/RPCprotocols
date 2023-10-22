package com.epam.Avro;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class KafkaAvroProducer {

    public static void main(String[] args) throws IOException {
        String kafkaServer = "localhost:9092";
        String schemaRegistryUrl = "http://localhost:8081";
        String topic = "avro-topic";

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        properties.put("schema.registry.url", schemaRegistryUrl);

        Producer<String, GenericRecord> producer = new KafkaProducer<>(properties);

        Schema schema = new Schema.Parser().parse(new File("src/main/avro/serialize_schema.avsc"));
        GenericRecord message = new GenericData.Record(schema);

        ProducerRecord<String, GenericRecord> record = new ProducerRecord<>(topic, message);
        producer.send(record);
        producer.close();

    }
}
