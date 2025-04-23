package com.example.teaching.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Announcement;
import com.example.teaching.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 公告控制器
 */
@Tag(name = "公告管理")

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {


    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    /**
     * 获取所有公告
     * @return 包含所有公告信息的 Result 对象
     */
    @Operation(summary = "获取所有公告")
    @GetMapping
    public Result<List<Announcement>> getAllAnnouncements() {
        List<Announcement> allAnnouncements = announcementService.getAllAnnouncements();
        return ResultUtils.success(allAnnouncements);
    }

    /**
     * 根据 ID 获取公告
     * @param id 公告 ID
     * @return 包含公告信息的 Result 对象
     */
    @Operation(summary = "根据 ID 获取公告")
    @GetMapping("/{id}")
    public Result<Announcement> getAnnouncementById(@PathVariable Long id) {
        Optional<Announcement> announcement = announcementService.getAnnouncementById(id);
        return announcement.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
    /**
     * 添加公告
     * @param announcement 公告对象
     * @return 包含保存后的公告信息的 Result 对象
     */
    @Operation(summary = "添加公告")
    @PostMapping
    public Result<Announcement> addAnnouncement(@RequestBody Announcement announcement) {
        Announcement savedAnnouncement = announcementService.addAnnouncement(announcement);
        return ResultUtils.success(savedAnnouncement);
    }
    @Operation(summary = "更新公告")
    @PutMapping("/{id}")
    public Result<Announcement> updateAnnouncement(@PathVariable Long id, @RequestBody Announcement announcement) {
        announcement.setId(id);
        Optional<Announcement> updatedAnnouncement = announcementService.updateAnnouncement(announcement);
        return updatedAnnouncement.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
    @Operation(summary = "删除公告")
    @DeleteMapping("/{id}")
    public Result<String> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return ResultUtils.success(null);
    }
}