package com.example.VismaInternalMeetings.model;

    enum Type {
    LIVE ("Live"),
    INPERSON ("InPerson");

    private final String typeValues;

     Type(String typeValues) {
        this.typeValues = typeValues;
    }

}
