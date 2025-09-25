package com.example.demo;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker//메시지 브로커 설정
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");//구독신청 = 송신
    config.setApplicationDestinationPrefixes("/app");//메시지보낼때 쓰는 url = 수신
  }
//
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/websocketServer");
  }

}