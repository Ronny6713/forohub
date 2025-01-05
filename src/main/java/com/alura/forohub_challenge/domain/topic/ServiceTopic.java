package com.alura.forohub_challenge.domain.topic;

import com.alura.forohub_challenge.domain.course.Course;
import com.alura.forohub_challenge.domain.course.CourseRepository;
import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.validation.topicValidation.createTopic.IValidationCreateTopic;
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
    @Autowired
    private List <IValidationCreateTopic> validationCreateTopic;


    public DataTopic createTopic(DataCreateTopic dataCreateTopic) {
        validationCreateTopic.forEach(v -> v.validation(dataCreateTopic));
        Optional<Course> course = courseRepository.findById(dataCreateTopic.idCourse());
        Optional<User> user = userRepository.findById(dataCreateTopic.idUser());
        if (!course.isPresent()) {
            throw new ValidationExceptionApi("The course does not exist");
        } else if (!user.isPresent()) {
            throw new ValidationExceptionApi("The user does not exist");
        }
        var topic = new Topic(null, dataCreateTopic.title(), dataCreateTopic.message(),
                LocalDateTime.now(),StatusTopic.ACTIVE,course.get(),user.get(),true);
        topicRepository.save(topic);
        return new DataTopic(topic);
    }

    public DataTopic updateTopic(Long id, UpdateTopicData updateTopicData) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        Optional <Course> optionalCourse = courseRepository.findById(updateTopicData.idCourse());
        if (!optionalTopic.isPresent()) {
            throw new ValidationExceptionApi("The requested topic does not exist.");
        } else if (!optionalCourse.isPresent()) {
            throw new ValidationExceptionApi("The course does not exist.");
        }
        var date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm - dd/MM/yyyy"));
        var topic = optionalTopic.get();
        topic.updateTopic(updateTopicData);
        return new DataTopic(topic);
    }

    public DataTopic topicByID(Long id) {
        Optional<Topic> topicValidation = topicRepository.findById(id);
        if (!topicValidation.isPresent()) {
            throw new ValidationExceptionApi("The topic does not exist.");
        }
        Topic topic = topicValidation.get();
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
                    topic.getUser().getUsername());
        }).collect(Collectors.toList());
        return topicData;
    }



}
