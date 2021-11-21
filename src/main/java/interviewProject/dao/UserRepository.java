package interviewProject.dao;

import interviewProject.model.entities.User;
import interviewProject.model.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);
    Optional<List> findAllByUserStatus(UserStatus userStatus);
}
