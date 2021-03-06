package com.example.VismaInternalMeetings.repository;

import com.example.VismaInternalMeetings.model.Meeting;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingRepository {
    List<Meeting> findAll();
    Optional<Meeting> findById(Long id);
    List<Meeting> findByResponsiblePerson(String responsiblePerson);
    List<Meeting> findByCategory(String category);
    List<Meeting> findByType(String type);
    List<Meeting> findByDescription(String description);
    List<Meeting> findAllWithStartDateAfter(LocalDateTime startDate);
    List<Meeting> findAllWithEndDateBefore(LocalDateTime endDate);
    List<Meeting> findByAttendees(List<String> participants);

    Meeting save(Meeting meeting);

    void delete(Meeting meetingToDelete);
}
