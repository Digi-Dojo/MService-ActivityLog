package com.startupsdigidojo.activitylog.placeEvents.kafka;

import com.startupsdigidojo.activitylog.placeEvents.dto.PlaceCreatedEvent;
import com.startupsdigidojo.activitylog.placeEvents.dto.PlaceDeletedEvent;
import com.startupsdigidojo.activitylog.placeEvents.dto.PlaceUpdatedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class PlaceKafkaConfiguration {
    @Value("${spring.kafka.properties.bootstrap.servers}")
    private String bootstrapServers;

    @Value("${com.startupsdigidojo.activitylog.userEvents.application.kafka.consumer.group_id}")
    private String consumerGroupId;

    @Value("${spring.kafka.properties.sasl.mechanism}")
    private String saslMechanism;

    @Value("${spring.kafka.properties.sasl.jaas.config}")
    private String saslJaasConfig;

    @Value("${spring.kafka.properties.security.protocol}")
    private String securityProtocol;

    @Bean
    public Map<String, Object> basePlaceConsumerProperties() {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                "sasl.mechanism", saslMechanism,
                "sasl.jaas.config", saslJaasConfig,
                "security.protocol", securityProtocol,
                ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId,
                ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false,
                ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000
        );
    }

    @Bean
    public ConsumerFactory<String, PlaceCreatedEvent> placeCreatedEventConsumerFactory() {
        JsonDeserializer<PlaceCreatedEvent> jsonDeserializer = new JsonDeserializer<>(PlaceCreatedEvent.class);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                basePlaceConsumerProperties(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PlaceCreatedEvent>> placeCreatedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PlaceCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(placeCreatedEventConsumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory<String, PlaceDeletedEvent> placeDeletedEventConsumerFactory() {
        JsonDeserializer<PlaceDeletedEvent> jsonDeserializer = new JsonDeserializer<>(PlaceDeletedEvent.class);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                basePlaceConsumerProperties(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PlaceDeletedEvent>> placeDeletedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PlaceDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(placeDeletedEventConsumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory<String, PlaceUpdatedEvent> placeUpdatedEventConsumerFactory() {
        JsonDeserializer<PlaceUpdatedEvent> jsonDeserializer = new JsonDeserializer<>(PlaceUpdatedEvent.class);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                basePlaceConsumerProperties(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PlaceUpdatedEvent>> placeUpdatedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PlaceUpdatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(placeUpdatedEventConsumerFactory());

        return factory;
    }
}
