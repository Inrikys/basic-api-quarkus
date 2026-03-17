package org.inrikys.adapters.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name= "dlt_entity")
@Table(name= "DLT_ENTITY")
public class DltEntity {

    @Id
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

    @Column(name = "exception")
    String exception;

    @CreationTimestamp
    LocalDateTime creationTime;

    public DltEntity() {
    }

    public DltEntity(String id, String topic, Integer partition, Long offset, String key, String payload, String headers, String exception) {
        this.id = id;
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
        this.key = key;
        this.payload = payload;
        this.headers = headers;
        this.exception = exception;
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

    public String getException() {
        return exception;
    }
}
