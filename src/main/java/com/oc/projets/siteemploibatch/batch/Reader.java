package com.oc.projets.siteemploibatch.batch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oc.projets.siteemploibatch.model.Notification;
import com.oc.projets.siteemploibatch.service.TokenService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Reader implements ItemReader<Notification> {

    List<Notification> notificationList = new ArrayList<>();
    private WebClient webClient;
    private int count = 0;
    private JsonNode jsonNode;
    private ObjectMapper objectMapper;
    private TokenService tokenService;
    private String email;
    private String password;
    private String urlAuthentication;
    private String urlNotifications;

    public Reader(TokenService tokenService, String email, String password, String urlAuthentication, String urlNotifications)  {
        // TODO Auto-generated constructor stub
        this.webClient = WebClient.create();
        this.objectMapper = new ObjectMapper();
        this.tokenService = tokenService;
        this.email = email;
        this.password = password;
        this.urlAuthentication = urlAuthentication;
        this.urlNotifications = urlNotifications;
        System.out.println(this.email + " , " + this.password);
    }

    @Override
    public Notification read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // TODO Auto-generated method stub
        String json = "{ \"username\": \"" + this.email + "\", \"password\":\"" + this.password +"\" }";
        System.out.println(json);
        //ObjectMapper objectMapper = new ObjectMapper();
        this.jsonNode = this.objectMapper.readTree(json);

        String result;

        result =  this.webClient.post()
                .uri(urlAuthentication)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(this.jsonNode)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        JsonNode jsonNodeTokeNode = this.objectMapper.readTree(result);
        System.out.println("token : " + jsonNodeTokeNode.get("token"));
        tokenService.setToken(jsonNodeTokeNode.get("token").asText());
        String token = tokenService.getToken();

        Flux<Notification> flux = this.webClient.get().uri(urlNotifications)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(token))
                .retrieve().bodyToFlux(Notification.class);

        this.notificationList = flux.collectList().block();

//        System.out.println("size liste notifications : " + this.notificationList.size());

        if(count < this.notificationList.size()) {
            System.out.println(this.notificationList.get(count).toString());
            return this.notificationList.get(count++);
        } else {
            count = 0;
        }

        return null;
    }
}
