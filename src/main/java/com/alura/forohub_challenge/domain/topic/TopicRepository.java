package com.alura.forohub_challenge.domain.topic;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByStatus(StatusTopic visible,Pageable pageable);

    boolean existsByTitleAndMessage(String title, String message);

   List<Topic> findAllByUserId(Long id);

}
