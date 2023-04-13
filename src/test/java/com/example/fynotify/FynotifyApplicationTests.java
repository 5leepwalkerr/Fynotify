package com.example.fynotify;

import com.example.fynotify.config.WebSocketConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SpringBootTest()
@RunWith(MockitoJUnitRunner.class)
public class FynotifyApplicationTests {
    @Value("${spring.rabbitmq.host}")
    private String name;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;

    @Mock
    private StompEndpointRegistry stompEndpointRegistry;
    @Mock
    private MessageBrokerRegistry messageBrokerRegistry;
    @InjectMocks
    private WebSocketConfig webSocketConfig;

    @Test
    public void testRegisterStompEndpoints(){
        webSocketConfig.registerStompEndpoints(stompEndpointRegistry);
        Mockito.verify(stompEndpointRegistry).addEndpoint(WebSocketConfig.REGISTRY).withSockJS();
    }
    @Test
    public void testConfigureMessageBroker(){
        webSocketConfig.configureMessageBroker(messageBrokerRegistry);
        Mockito.verify(messageBrokerRegistry).enableStompBrokerRelay(WebSocketConfig.TOPIC_DESTINATION_PREFIX)
                .setRelayHost(name)
                .setClientLogin(username)
                .setClientPasscode(password);
        Mockito.verify(messageBrokerRegistry).setApplicationDestinationPrefixes("/app");
    }

}