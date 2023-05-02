package edu.mariadb.ex.repository;



import edu.mariadb.ex.entity.Authorities;
import edu.mariadb.ex.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users,Long> {
}
