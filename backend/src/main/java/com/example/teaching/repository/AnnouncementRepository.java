package com.example.teaching.repository;

import com.example.teaching.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findByTitle(String title);
    List<Announcement> findByContent(String content);
    List<Announcement> findByPublishTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

}