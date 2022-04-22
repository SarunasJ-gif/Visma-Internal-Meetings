package com.example.VismaInternalMeetings.repository;


import com.example.VismaInternalMeetings.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingJsonRepository extends JpaRepository<Meeting, Long> {

        List<Meeting> findByResponsiblePerson(String responsiblePerson);
        List<Meeting> findByCategory(String category);
        List<Meeting> findByType(String type);
        List<Meeting> findByDescription(String description);
        List<Meeting> findByStartDate(LocalDateTime startDate);
        List<Meeting> findByEndDate(LocalDateTime endDate);
        List<Meeting> findAllWithStartDateAfter(LocalDateTime startDate);
        List<Meeting> findAllWithEndDateBefore(LocalDateTime endDate);

}

