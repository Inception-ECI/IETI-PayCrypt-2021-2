package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB User Repository
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserRepository extends MongoRepository<User, String> {

}
