package io.josebrains.springbootquickstart.topic;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TopicService {

    List<Topic> topics = new ArrayList<Topic>();

    public List<Topic> getTopics() {
        return topics;
    }

    public void updateTopic(String id, Topic topic){
        for (int i=0 ; i < topics.size() ; i++){
            Topic t = topics.get(i);

            if (t.getId().equals(id)){
                topic.setId(t.getId());
                topics.remove(i);
                addTopic(topic);
                break;
            }
        }
    }

    public void addTopic(Topic topic){
        if (topic.getId() == null) {
            topic.setId(UUID.randomUUID().toString());
        }
        topics.add(topic);
    }

    public void deleteTopicById(String id){
        for (int i=0 ; i < topics.size() ; i++){
            Topic t = topics.get(i);

            if (t.getId().equals(id)){
                topics.remove(i);
                break;
            }
        }
    }

    public Topic getTopicByName(final String name){
        //return topics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
        for (Topic t : topics) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

}
