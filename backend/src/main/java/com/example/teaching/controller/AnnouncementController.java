package com.example.teaching.controller;

import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Announcement;
import com.example.teaching.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author: WQL
 * @Date: 2024/2/29
 * @Description: 公告controller
 */
@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {


    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService){this.announcementService = announcementService;}

    @GetMapping
    public Result<List<Announcement>> getAllAnnouncements() {
        List<Announcement> allAnnouncements = announcementService.getAllAnnouncements();
        return ResultUtils.success(allAnnouncements);
    }

    /**
     * @param id 公告id
     * @return 公告
     */
    @GetMapping("/{id}")
    public Result<Announcement> getAnnouncementById(@PathVariable Long id) {
        Optional<Announcement> announcement = announcementService.getAnnouncementById(id);
        return announcement.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }

    /**
     * @param announcement 公告
     * @return 保存后的公告
     */
    @PostMapping
    public Result<Announcement> addAnnouncement(@RequestBody Announcement announcement) {
        Announcement savedAnnouncement = announcementService.addAnnouncement(announcement);
        return ResultUtils.success(savedAnnouncement);
    }
    @PutMapping("/{id}")
    public Result<Announcement> updateAnnouncement(@PathVariable Long id, @RequestBody Announcement announcement) {
        announcement.setId(id);
        Optional<Announcement> updatedAnnouncement = announcementService.updateAnnouncement(announcement);
        return updatedAnnouncement.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
    @DeleteMapping("/{id}")
    public Result<String> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return ResultUtils.success(null);
    }
}