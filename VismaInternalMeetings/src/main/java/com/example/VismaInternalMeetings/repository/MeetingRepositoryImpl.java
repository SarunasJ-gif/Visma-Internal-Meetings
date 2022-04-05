package com.example.VismaInternalMeetings.repository;

import com.example.VismaInternalMeetings.model.Meeting;
import com.example.VismaInternalMeetings.model.MeetingType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MeetingRepositoryImpl implements MeetingRepository {

    private MeetingJsonRepository meetingJsonRepository;


    @Override
    public List<Meeting> findAll() {
        return meetingJsonRepository.findAll();
    }

    @Override
    public Optional<Meeting> findById(Long id) {
        return meetingJsonRepository.findById(id);
    }

    @Override
    public List<Meeting> findByResponsiblePerson(String responsiblePerson) {
        return meetingJsonRepository.findByResponsiblePerson(responsiblePerson);
    }

    @Override
    public List<Meeting> findByCategory(String category) {
        return meetingJsonRepository.findByCategory(category);
    }

    @Override
    public List<Meeting> findByType(MeetingType type) {
        return meetingJsonRepository.findByType(type);
    }

    @Override
    public List<Meeting> findByDescription(String description) {
        return meetingJsonRepository.findByDescription(description);
    }

    @Override
    public List<Meeting> findAllWithStartDateAfter(LocalDateTime startDate) {
        return meetingJsonRepository.findAllWithStartDateAfter(startDate);

    }

    @Override
    public List<Meeting> findAllWithEndDateBefore(LocalDateTime endDate) {
        return meetingJsonRepository.findAllWithEndDateBefore(endDate);
    }

    @Override
    public List<Meeting> findByAttendees(List<String> participants) {
        List<Meeting> resultMeetings = new ArrayList<>();
        List<Meeting> allMeetings = meetingJsonRepository.findAll();
        for(String participant:participants){
            for(Meeting meeting:allMeetings){
                List<String> meetingParticipants = meeting.getParticipants().stream().map(partc->partc.getName()).collect(Collectors.toList());
                if(meetingParticipants.contains(participant)){
                    resultMeetings.add(meeting);
                }
            }
        }
        return resultMeetings;
    }
}
