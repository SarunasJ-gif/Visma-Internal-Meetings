package com.example.VismaInternalMeetings.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ComponentScan({"com.example.VismaInternalMeetings"})
@EntityScan("com.example.VismaInternalMeetings.model")
public class DataConfig {

    @PersistenceContext
    private EntityManager entityManager;

}
