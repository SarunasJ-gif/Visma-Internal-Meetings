package com.example.VismaInternalMeetings.model;

public enum MeetingType {
    LIVE ("Live"),
    INPERSON ("InPerson");

    private final String typeValues;

    MeetingType(String typeValues) {
        this.typeValues = typeValues;
    }

}
