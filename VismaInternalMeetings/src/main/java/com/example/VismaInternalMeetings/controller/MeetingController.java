package com.example.VismaInternalMeetings.controller;


import com.example.VismaInternalMeetings.model.Meeting;
import com.example.VismaInternalMeetings.model.Participant;
import com.example.VismaInternalMeetings.repository.MeetingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingRepository repository;


    public MeetingController(MeetingRepository repository) {
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/participants")
    public List<Participant> createParticipants(@RequestBody Participant participant) {
        Meeting meeting = repository.findAll().get(0);
        List<Participant> allParticipants = meeting.getParticipants();
        for (int i = 0; i < allParticipants.size(); i++) {
            if (allParticipants.get(i) == participant) {
                System.out.println("Cannot add the same person twice");
            }
            allParticipants.add(participant);
            meeting.setParticipants(allParticipants);
        }
        return allParticipants;

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

   @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/participant")
    public String deleteParticipant(@PathVariable ("id") Long id, @RequestParam String name) {
       Optional<Meeting> meetingOptional = this.repository.findById(id);
       if (!meetingOptional.isPresent()) {
           return null;
       }
       Meeting meeting = meetingOptional.get();
       List<Participant> allParticipants = meeting.getParticipants();
       if (meeting.getResponsiblePerson() != name) {
           allParticipants.remove(name);
       } else {
           System.out.println("Cannot remove responsible person!");
       }
       return name;
   }

   @GetMapping("/meetings/search")
    public List<Meeting> searchMeeting(@RequestParam(name = "description", required = false) String description,
                                       @RequestParam(name = "responsiblePerson", required = false) String responsiblePerson,
                                       @RequestParam(name = "category", required = false) String category,
                                       @RequestParam(name = "type", required = false) String type,
                                       @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
                                       @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
                                       @RequestParam(name = "numberOfAttendees", required = false) List<Participant> participants) {

        if (description != null) {
            return this.repository.findByDescription(description);
        }
        if (responsiblePerson != null) {
            return this.repository.findByResponsiblePerson(responsiblePerson);
        }
        if (category != null) {
            return this.repository.findByCategory(category);
        }
        if (type != null) {
            return this.repository.findByType(type);
        }
        if ((LocalDateTime.now().isAfter(startDate)) || (LocalDateTime.now().isAfter(startDate) && LocalDateTime.now().isBefore(endDate))) {
            return this.repository.findByStartDateAfter(startDate);
        }
        return new ArrayList<>();
   }
}


