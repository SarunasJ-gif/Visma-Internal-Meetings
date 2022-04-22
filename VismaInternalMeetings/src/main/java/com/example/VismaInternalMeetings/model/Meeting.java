package com.example.VismaInternalMeetings.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Meeting {

    @Id
    private Long id;

    private String name;
    private String responsiblePerson;
    private String description;
    private String category;
    private String type;
    private Date startDate;
    private Date endDate;
    private List<Participant> participants;

    public Meeting() {
    }

    public Meeting(Long id,
                   String name,
                   String responsiblePerson,
                   String description,
                   String category,
                   String type,
                   Date startDate,
                   Date endDate,
                   List<Participant> participants) {

        this.id = id;
        this.name = name;
        this.responsiblePerson = responsiblePerson;
        this.description = description;
        this.category = category;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id) && Objects.equals(name, meeting.name) && Objects.equals(responsiblePerson, meeting.responsiblePerson) && Objects.equals(description, meeting.description) && Objects.equals(category, meeting.category) && Objects.equals(type, meeting.type) && Objects.equals(startDate, meeting.startDate) && Objects.equals(endDate, meeting.endDate) && Objects.equals(participants, meeting.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, responsiblePerson, description, category, type, startDate, endDate, participants);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", participants=" + participants +
                '}';
    }
}
