package com.alura.forohub_challenge.domain.validation.topicValidation.updateTopic;

import com.alura.forohub_challenge.domain.topic.UpdateTopicData;

public interface IValidationUpdateTopic {
    void validation(Long id, UpdateTopicData updateTopicData);
}

