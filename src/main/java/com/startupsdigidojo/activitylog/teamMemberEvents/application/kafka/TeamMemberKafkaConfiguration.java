package com.startupsdigidojo.activitylog.teamMemberEvents.application.kafka;

import com.startupsdigidojo.activitylog.teamMemberEvents.application.dto.StartupAddedUserEvent;
import com.startupsdigidojo.activitylog.teamMemberEvents.application.dto.StartupRemovedUserEvent;
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
public class TeamMemberKafkaConfiguration {
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
    public Map<String, Object> baseTeamMemberConsumerProperties() {
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
    public ConsumerFactory<String, StartupAddedUserEvent> startupAddedUserEventConsumerFactory() {
        JsonDeserializer<StartupAddedUserEvent> jsonDeserializer = new JsonDeserializer<>(StartupAddedUserEvent.class);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                baseTeamMemberConsumerProperties(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, StartupAddedUserEvent>> startupAddedUserEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StartupAddedUserEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(startupAddedUserEventConsumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory<String, StartupRemovedUserEvent> startupRemovedUserEventConsumerFactory() {
        JsonDeserializer<StartupRemovedUserEvent> jsonDeserializer = new JsonDeserializer<>(StartupRemovedUserEvent.class);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                baseTeamMemberConsumerProperties(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, StartupRemovedUserEvent>> startupRemovedUserEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StartupRemovedUserEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(startupRemovedUserEventConsumerFactory());

        return factory;
    }
}
