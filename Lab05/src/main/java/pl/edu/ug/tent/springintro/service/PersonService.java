package pl.edu.ug.tent.springintro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springintro.domain.Person;

@Service
public class PersonService {

    @Autowired
    @Qualifier("prezes")
    Person prezes;

    Person getPrezes() {
        return prezes;
    }

    @Autowired
    @Qualifier("wiceprezes")
    Person wiceprezes;

    Person getWiceprezes() {
        return wiceprezes;
    }

    @Autowired
    @Qualifier("sekretarka")
    Person sekretarka;

    Person getSekretarka() {
        return sekretarka;
    }


}
