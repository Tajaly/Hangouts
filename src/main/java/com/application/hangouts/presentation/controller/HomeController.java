package com.application.hangouts.presentation.controller;

import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.logic.domain.services.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Controller
public class HomeController {

    private final PersonRepository personRepository;

    public HomeController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //TODO name und bio hinzufügen

    @GetMapping("/")
    public String getHome (    OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        String username = oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
       // System.out.println(oAuth2AuthenticationToken);
        Optional<Person> person = personRepository.findPersonByUsername(username);
        if(person.isEmpty()) {
            personRepository.saveNewPerson(new Person(username, username));
        };
        return "index";
    }


    //http://localhost:8080/circles
    @GetMapping("/circles")
    @ResponseStatus(HttpStatus.OK)
    public String getCirclesOverview () {
        return "circle/my-circles";
    }

    //http://localhost:8080/hangouts
    @GetMapping("/hangouts")
    @ResponseStatus(HttpStatus.OK)
    public String getUpcomingHangouts () {
        return "hangout/scheduled-hangouts";
    }


}
