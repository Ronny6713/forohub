package com.alura.forohub_challenge.domain.validation.topicValidation.createTopic;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.course.CourseRepository;
import com.alura.forohub_challenge.domain.topic.DataCreateTopic;
import com.alura.forohub_challenge.domain.topic.TopicRepository;
import com.alura.forohub_challenge.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicCreationValidation implements  IValidationCreateTopic{
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validation(DataCreateTopic dataCreateTopic) {
        var validationTitle =  dataCreateTopic.title().trim().toLowerCase();
        var validationMessage = dataCreateTopic.message().trim().toLowerCase();
        boolean topicVerification = topicRepository.existsByTitleAndMessage(validationTitle, validationMessage);
        if (topicVerification) {
            throw new ValidationExceptionApi("The entered topic already exists.");
        }
    }
}
