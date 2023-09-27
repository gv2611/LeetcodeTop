package org.example.twilio;


// Topics in the messaging queue
//service a will have a topic, publish messages there. order-management
// have a in process queue for both and delete on successful processing
// service a will create a new topic and publish messages to that topic, should create topic with diffrenet names order-management2

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Topic {

    private String name;
    private int capacity;

    private Queue<String> topicQueue;


    Topic(int capacity, String name){
        this.capacity= capacity;
        this.name = name;
        this.topicQueue = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Queue<String> getTopicQueue() {
        return topicQueue;
    }

    public void setTopicQueue(Queue<String> topicQueue) {
        this.topicQueue = topicQueue;
    }

}

public class MessagingQueue {
    static HashMap<String, Queue> topics = new HashMap<>();

    public static Topic  createTopic(int capacity, String name){
        Topic topic = new Topic(capacity, name);
        topics.put(name, topic.getTopicQueue());
        return topic;
    }

    public static void main(String[] args){

        Topic orderManagement1=createTopic(100, "order-management");
        System.out.println(topics);

        ServiceA serviceA = new ServiceA();
        serviceA.publishMessage("Task1", orderManagement1);
        serviceA.publishMessage("Task2", orderManagement1);
        ServiceC serviceC = new ServiceC(orderManagement1);
        serviceC.consumeMessage();
        serviceC.consumeMessage();
    }
}

class ServiceA {

    public String publishMessage (String message, Topic topic){
        topic.getTopicQueue().add(message);
        return "Message added successfully to queue "+ topic.getName();
    }
}

class ServiceC {

    Topic topic;

    ServiceC(Topic topic){
        this.topic = topic;
    }

    public void consumeMessage(){
        String message = this.topic.getTopicQueue().poll();
        System.out.println("Message read from topic "+ topic.getName()+" is : "+ message);
    }

}