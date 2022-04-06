package com.example.VismaInternalMeetings;

import com.example.VismaInternalMeetings.controller.MeetingController;
import com.example.VismaInternalMeetings.model.Meeting;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VismaInternalMeetingsApplicationTests {

	MeetingController meetingController;

	@Test
	void contextLoads() {

		List<Meeting> meetings = meetingController.getAll();
	}

}
