package org.inrikys.adapters.message.kafka.in;

import io.smallrye.reactive.messaging.kafka.api.IncomingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.inrikys.adapters.store.entities.DltEntity;
import org.inrikys.adapters.store.repository.DltRepository;
import org.jboss.logging.Logger;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ReviewDltConsumer {

    private static final Logger LOG = Logger.getLogger(ReviewDltConsumer.class);
    private final DltRepository dltRepository;

    public ReviewDltConsumer(DltRepository dltRepository) {
        this.dltRepository = dltRepository;
    }

    @Incoming("reviews-created-dlt-in")
    public CompletionStage<Void> consumeReview(Message<String> msg) {
        LOG.info("Consuming message to DLT: " + msg);

        try {

            var metadata = msg.getMetadata(IncomingKafkaRecordMetadata.class).orElseThrow();

            DltEntity entity = new DltEntity(
                    UUID.randomUUID().toString(),
                    metadata.getTopic(),
                    metadata.getPartition(),
                    metadata.getOffset(),
                    metadata.getKey().toString(),
                    msg.getPayload(),
                    metadata.getHeaders().toString()
            );

            dltRepository.persist(entity);

        } catch (Exception e) {
            LOG.error("Error to consume DLT message", e);
        }

        return msg.ack();
    }

}