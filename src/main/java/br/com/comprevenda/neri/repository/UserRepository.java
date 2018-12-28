package br.com.comprevenda.neri.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.comprevenda.neri.security.entity.User;

/**
 * Created by NeriDev on 05/06/2018.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
    


}