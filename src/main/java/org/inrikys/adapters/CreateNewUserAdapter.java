package org.inrikys.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.inrikys.adapters.store.entities.UserEntity;
import org.inrikys.adapters.store.repository.UserRepository;
import org.inrikys.domain.models.User;
import org.inrikys.domain.ports.CreateNewUserPort;

import java.util.Optional;

@ApplicationScoped
public class CreateNewUserAdapter implements CreateNewUserPort {

    public final UserRepository userRepository;

    public CreateNewUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User saveNewUser(User newUser) {

        Optional<UserEntity> possibleUserEntity = userRepository.findByEmail(newUser.getEmail());

        if (possibleUserEntity.isPresent()) {
            // Idempotencia
        }

        UserEntity userEntity = new UserEntity(newUser);
        userRepository.persist(userEntity);

        return userEntity.toUser();
    }
}
