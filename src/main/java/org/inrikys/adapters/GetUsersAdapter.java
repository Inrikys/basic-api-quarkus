package org.inrikys.adapters;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import org.inrikys.adapters.store.entities.UserEntity;
import org.inrikys.adapters.store.repository.UserRepository;
import org.inrikys.domain.models.User;
import org.inrikys.domain.ports.GetUsersPort;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GetUsersAdapter implements GetUsersPort {

    private static final Logger LOG = Logger.getLogger(GetUsersAdapter.class);
    private final UserRepository userRepository;

    public GetUsersAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        LOG.info("Retrieving users from DB");
        PanacheQuery<UserEntity> allUsersEntity = this.userRepository.findAll();
        return allUsersEntity.stream().map(UserEntity::toUser).toList();
    }

    @Override
    public Boolean existsById(Long userId) {
        LOG.info("Retrieving user " + userId + " from DB");
        Optional<UserEntity> possibleUser = this.userRepository.findByIdOptional(userId);
        return possibleUser.isPresent();
    }
}
