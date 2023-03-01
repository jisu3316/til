package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    /* http://localhost:8080/actuator/httpexchanges 최대 100개의 요청을 제공한다.
        setCapacity(100); 요청 개수 변경 가능
        운영에서는 핀포인트, zipkin 사용
     */
    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository() {
        InMemoryHttpExchangeRepository inMemoryHttpExchangeRepository = new InMemoryHttpExchangeRepository();
        inMemoryHttpExchangeRepository.setCapacity(100);
        return inMemoryHttpExchangeRepository;
    }
}
