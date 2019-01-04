package pl.poznan.put.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
