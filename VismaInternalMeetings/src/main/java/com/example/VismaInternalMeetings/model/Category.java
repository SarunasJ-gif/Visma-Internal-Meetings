package com.example.VismaInternalMeetings.model;

   enum Category {

       CODEMONKEY ("CodeMonkey"),
       HUB ("Hub"),
       SHORT ("Short"),
       TEAMBUILDING ("TeamBuilding");

       private final String category;


       Category(String category) {
           this.category = category;
       }
   }
