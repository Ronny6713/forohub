package com.alura.forohub_challenge.domain.Topic;

import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.domain.Course.CourseRepository;
import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.user.User;
import com.alura.forohub_challenge.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ServiceTopic {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    public DataTopic createTopic(DataCreateTopic dataCreateTopic) {
        Course course = courseRepository.findById(dataCreateTopic.idCourse()).orElse(null);
        User user = userRepository.findById(dataCreateTopic.idUser()).orElse(null);
        var title = dataCreateTopic.title().trim().toLowerCase();
        var message = dataCreateTopic.message().trim().toLowerCase();
        boolean topicVerification = topicRepository.existsByTitleAndMessage(title, message);
        if (topicVerification) {
            throw new ValidationExceptionApi("The entered topic already exists.");
        }
        var status = StatusTopic.ACTIVE;
        boolean visible = true;

        var date = LocalDateTime.now();
        var topic = new Topic(null, dataCreateTopic.title(), dataCreateTopic.message(), date,status,course,user,visible);
        topicRepository.save(topic);
        return new DataTopic(topic);
    }

    public DataTopic updateTopic(Long id, UpdateTopicData updateTopicData) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (!optionalTopic.isPresent()) {
            throw new ValidationExceptionApi("The requested topic does not exist.");
        }
        boolean optionalCourse = courseRepository.existsById(updateTopicData.idCourse());
        if (!optionalCourse) {
            throw new ValidationExceptionApi("The course does not exist.");
        }
        Topic topic = optionalTopic.get();
        topic.updateTopic(updateTopicData);
        return new DataTopic(topic);
    }

    public DataTopic topicByID(Long id) {
        boolean topicValidation = topicRepository.existsById(id);
        if (!topicValidation) {
            throw new ValidationExceptionApi("The topic does not exist.");
        }
        var data = topicRepository.findById(id);
        Topic topic = data.get();
        return new DataTopic(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

}
