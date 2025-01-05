package com.alura.forohub_challenge.domain.Topic;

import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.domain.Course.CourseRepository;
import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.user.User;
import com.alura.forohub_challenge.user.UserRepository;
import com.alura.forohub_challenge.user.UserTopicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        var date = (LocalDateTime.now());
        var topic = new Topic(null, dataCreateTopic.title(), dataCreateTopic.message(),date,status,course,user,visible);
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
        var date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm - dd/MM/yyyy"));
        var topic = optionalTopic.get();
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

    public List<UserTopicData> listTopicsByUser(Long id) {
        boolean userExist = userRepository.existsById(id);
        if (!userExist) {
            throw new ValidationExceptionApi("User does not exist.");
        }
        var list = topicRepository.findAllByUserId(id);
        if (list.isEmpty()) {
            throw new ValidationExceptionApi("The user has no topics available.");
        }

        List<UserTopicData> topicData = list.stream().map(topic -> {
            return new UserTopicData(
                    topic.getTitle(),
                    topic.getDate().format(DateTimeFormatter.ofPattern("hh:mm - dd/MM/yyyy")),
                    topic.getStatus(),
                    topic.getCourse().getNameCourse(),
                    topic.getUser().getUsername()
            );
        }).collect(Collectors.toList());
        return topicData;
    }

}
