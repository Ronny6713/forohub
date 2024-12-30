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
        var status = StatusTopic.ACTIVE;
        boolean visible = true;
        var date = LocalDateTime.now();
        //modificar el id de curso y user
        var topic = new Topic(null, dataCreateTopic.title(), dataCreateTopic.message(),  date, status,course, user,visible);
        topicRepository.save(topic);
        return new DataTopic(topic);
    }

    public DataTopic updateTopic(Long id, DataUpdateTopic dataUpdateTopic) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (!optionalTopic.isPresent()) {
            throw new ValidationExceptionApi("El Topico solicitado no existe");
        }
        boolean optionalCourse = courseRepository.existsById(dataUpdateTopic.idCourse());
        if (!optionalCourse) {
            throw new ValidationExceptionApi("El Course no existe");
        }
        Topic topic = optionalTopic.get();
        topic.updateTopic(dataUpdateTopic);
        return new DataTopic(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
