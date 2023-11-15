package pl.edu.ug.tent.springintro.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.ug.tent.springintro.domain.Person;

@Configuration
public class PersonServiceConfig {

    @Bean
    public Person prezes() {
        return new Person("Chrystal", "Havoc", "chavocr@yahoo.com", "Mymm");
    }

    @Bean
    public Person wiceprezes() {
        return new Person("Halley", "Gadaud", "hgadaud9@sohu.com", "Oyope");
    }

    @Bean
    public Person sekretarka() {
        return new Person("Kirbie", "Wrettum", "kwrettumj@slideshare.net", "Browsetype");
    }

}
