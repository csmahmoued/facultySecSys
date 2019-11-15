package com.facultysys.service;

import com.facultysys.model.Events;
import com.facultysys.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository ep;

    public List<Events> getAllEvents(){
        return  ep.findAll();
    }
    public Events getEvent(int id){
        return ep.findById(id).get();

    }

    public  Events addEvent(Events event){
        return  ep.save(event);
    }

    public  void deleteEvent(int id){
        ep.deleteById(id);
    }



}
