package com.alura.forohub_challenge.domain.Topic;

import aj.org.objectweb.asm.commons.Remapper;
import com.alura.forohub_challenge.user.UserTopicData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByStatus(StatusTopic visible,Pageable pageable);

    boolean existsByTitleAndMessage(String title, String message);

   List<Topic> findAllByUserId(Long id);
}
