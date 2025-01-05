package com.alura.forohub_challenge.domain.validation.topicValidation.updateTopic;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.topic.TopicRepository;
import com.alura.forohub_challenge.domain.topic.UpdateTopicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicUpdateValidation implements  IValidationUpdateTopic{
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validation(Long id, UpdateTopicData updateTopicData) {
        var validationTitle =  updateTopicData.title().trim().toLowerCase();
        var validationMessage = updateTopicData.message().trim().toLowerCase();
        boolean topicVerification = topicRepository.existsByTitleAndMessage(validationTitle, validationMessage);
        if (topicVerification) {
            throw new ValidationExceptionApi("The entered topic already exists.");
        }
    }
}
