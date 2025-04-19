package com.example.teaching.service;

import com.example.teaching.entity.Announcement;
import com.example.teaching.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Optional<Announcement> getAnnouncementById(Long id) {
        return announcementRepository.findById(id);
    }

    public Announcement addAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public Optional<Announcement> updateAnnouncement(Announcement announcement) {
        Optional<Announcement> existingAnnouncement = announcementRepository.findById(announcement.getId());
        if (existingAnnouncement.isPresent()) {
            return Optional.of(announcementRepository.save(announcement));
        }
        return Optional.empty();
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }
}