package com.example.teaching.controller;

import com.example.teaching.entity.Announcement;
import com.example.teaching.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {


    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService){this.announcementService = announcementService;}

    @GetMapping
    public List<Announcement> getAllAnnouncement() {
        return announcementService.getAllAnnouncement();
    }
}