package com.example.VismaInternalMeetings;

import com.example.VismaInternalMeetings.model.Meeting;
import com.example.VismaInternalMeetings.repository.MeetingJsonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class VismaInternalMeetingsApplicationTests {

//	MeetingController meetingController;
	@Autowired
	MeetingJsonRepository meetingJsonRepository;
	@Test
	void meetingsExistTest() {
		List<Meeting> allMeetings = meetingJsonRepository.findAll();
		Assert.isTrue(allMeetings.size()>0, "No meetings");
//		List<Meeting> meetings = meetingController.getAll();
	}

}
