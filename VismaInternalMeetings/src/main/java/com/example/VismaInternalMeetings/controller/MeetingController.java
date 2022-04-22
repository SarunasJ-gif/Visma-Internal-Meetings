package com.example.VismaInternalMeetings.controller;


import com.example.VismaInternalMeetings.model.Meeting;
import com.example.VismaInternalMeetings.model.Participant;
import com.example.VismaInternalMeetings.repository.MeetingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private final MeetingRepositoryImpl repository;


    public MeetingController(MeetingRepositoryImpl repository) {
        this.repository = repository;
    }

    @GetMapping("/meetings")
    public List<Meeting> getAll() {
        return repository.findAll();
    }

    @GetMapping("/meetings/{id}")
    public Optional<Meeting> getByName(@PathVariable ("id") Long id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/meetings")
    public Meeting createNewMeeting(@RequestBody Meeting meeting) {
       // Meeting newMeeting = this.repository(meeting);
        return repository.save(meeting);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Meeting delete(@PathVariable ("id") Long id) {
        Optional<Meeting> meetingToDeleteOptional = this.repository.findById(id);
        if (!meetingToDeleteOptional.isPresent()) {
            return null;
        }
        Meeting meetingToDelete = meetingToDeleteOptional.get();
        this.repository.delete(meetingToDelete);
        return meetingToDelete;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/participant")
    public List<Participant> addParticipant(@RequestBody Participant participant, @PathVariable ("id") Long id) {
        Optional<Meeting> meetingOptional = repository.findById(id);
        if(!meetingOptional.isPresent()){
            return null;
        }
        Meeting meeting = meetingOptional.get();

        List<Participant> allParticipants = meeting.getParticipants();
        for (int i = 0; i < allParticipants.size(); i++) {
            if (allParticipants.get(i) == participant) {
                System.out.println("Cannot add the same person twice");
                return null;
            }
        }

        allParticipants.add(participant);
        meeting.setParticipants(allParticipants);
        return allParticipants;

    }



   @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/participant")
    public String deleteParticipant(@PathVariable ("id") Long id, @RequestParam Participant participant) {
       Optional<Meeting> meetingOptional = this.repository.findById(id);
       if (!meetingOptional.isPresent()) {
           return null;
       }
       Meeting meeting = meetingOptional.get();

       List<Participant> allParticipants = meeting.getParticipants();
       if (meeting.getResponsiblePerson() != participant.getName()) {
           allParticipants.remove(participant);
       } else {
           System.out.println("Cannot remove responsible person!");
       }
       return participant.getName();
   }

   @GetMapping("/meetings/search")
    public List<Meeting> searchMeeting(@RequestParam(name = "description", required = false) String description,
                                       @RequestParam(name = "responsiblePerson", required = false) String responsiblePerson,
                                       @RequestParam(name = "category", required = false) String category,
                                       @RequestParam(name = "type", required = false) String type,
                                       @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
                                       @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
                                       @RequestParam(name = "numberOfAttendees", required = false) Long count) {

        if (description != null) {
            return repository.findByDescription(description);
        }
        if (responsiblePerson != null) {
            return repository.findByResponsiblePerson(responsiblePerson);
        }
        if (category != null) {
            return repository.findByCategory(category);
        }
        if (type != null) {
            return repository.findByType(type);
        }
        if ((LocalDateTime.now().isAfter(startDate)) || (LocalDateTime.now().isAfter(startDate) && LocalDateTime.now().isBefore(endDate))) {
            return repository.findAllWithStartDateAfter(startDate);
        }

        if (count != null) {
            List<Meeting> meetings = repository.findAll();
            List<Meeting> resultMeetings = new ArrayList<>();
            for (Meeting meeting : meetings){
                if (meeting.getParticipants().size() > count){
                    resultMeetings.add(meeting);
                }
            }
            return resultMeetings;
        }

        return new ArrayList<>();
   }
}


