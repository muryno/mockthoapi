package com.moctho.mockthoapi.config;

import com.moctho.mockthoapi.exception.SSLRelatedException;
import com.moctho.mockthoapi.model.users;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;


public class AppConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        TrustStrategy trustStrategy = (X509Certificate[] chain, String authType)->true;

        SSLContext sslContext = null;
         try{
             sslContext = SSLContexts.custom().loadTrustMaterial(null,trustStrategy).build();
         }catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e){
             throw  new SSLRelatedException(e.getMessage(),e);
         }


        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient  httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        return  new RestTemplate(requestFactory);

    }

}
