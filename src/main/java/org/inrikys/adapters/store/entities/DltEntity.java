package org.inrikys.adapters.store.entities;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class DltEntity {

    @Column(name = "id")
    String id;

    @Column(name = "topic")
    String topic;

    @Column(name = "partition")
    Integer partition;

    @Column(name = "offset")
    Long offset;

    @Column(name = "key")
    String key;

    @Column(name = "payload")
    String payload;

    @Column(name = "headers")
    String headers;

    @CreationTimestamp
    LocalDateTime creationTime;

    public DltEntity() {
    }

    public DltEntity(String id, String topic, Integer partition, Long offset, String key, String payload, String headers) {
        this.id = id;
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
        this.key = key;
        this.payload = payload;
        this.headers = headers;
    }

    public String getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getPartition() {
        return partition;
    }

    public Long getOffset() {
        return offset;
    }

    public String getKey() {
        return key;
    }

    public String getPayload() {
        return payload;
    }

    public String getHeaders() {
        return headers;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
