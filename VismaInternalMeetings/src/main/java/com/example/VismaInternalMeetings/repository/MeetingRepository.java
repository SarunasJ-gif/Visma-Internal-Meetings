package com.example.VismaInternalMeetings.repository;


import com.example.VismaInternalMeetings.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, String> {

        List<Meeting> findAll();
        Optional<Meeting> findById(Long id);
        List<Meeting> findByResponsiblePerson(String responsiblePerson);
        List<Meeting> findByCategory(String category);
        List<Meeting> findByType(String type);
        List<Meeting> findByStartDateAfter(LocalDateTime startDate);
        List<Meeting> findByEndsDateBefore(LocalDateTime endDate);
        List<Meeting> findByAttendees();
        List<Meeting> findByDescription(String description);


}
