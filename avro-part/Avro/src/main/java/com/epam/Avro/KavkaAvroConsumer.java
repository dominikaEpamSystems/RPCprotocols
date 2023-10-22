package com.epam.Avro;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class KavkaAvroConsumer {

    public static void main(String[] args) {
        String kafkaServer = "localhost:9092";
        String schemaRegistryUrl = "http://localhost:8081";
        String topic = "avro-topic";

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "avro-consumer");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        properties.put("schema.registry.url", schemaRegistryUrl);

        KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            ConsumerRecords<String, GenericRecord> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, GenericRecord> record : records) {
                Schema schema = record.value().getSchema();

                DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);

                try {
                    GenericRecord deserializedRecord = datumReader.read(null, DecoderFactory.get().binaryDecoder(
                            record.value().toString().getBytes(), null));

                    System.out.println("Received Avro record:" + deserializedRecord);

                    String name = deserializedRecord.get("name").toString();
                    String favNumber = deserializedRecord.get("favorite_number").toString();
                    String favColor = deserializedRecord.get("favorite_color").toString();

                    System.out.println("Name: " + name);
                    System.out.println("Favorite number: " + favNumber);
                    System.out.println("Favorite Color: " + favColor);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
