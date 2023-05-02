package edu.mariadb.ex.repository;

import edu.mariadb.ex.entity.Authorities;
import edu.mariadb.ex.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthoritiesRepositoryTest {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    @Commit
    void testSave(){

        Users user = Users.builder()
                .password("1234")
                .username("user1")
                .build();

        usersRepository.save(user);

        Authorities authorities = Authorities.builder()
                .user(user)
                .authority("ROLE_USER")
                .build();

        authoritiesRepository.save(authorities);
    }

    @Test
    @Commit
    void testSave2(){

        Users user = Users.builder()
                .id(1L)
                .build();

        Authorities authorities = Authorities.builder()
                .user(user)
                .authority("ROLE_ADMIN")
                .build();

        authoritiesRepository.save(authorities);
    }

    @Test
    @Commit
    void testFindAll(){

        // 1. 전체 수 조회
        long count  = authoritiesRepository.count();
        System.out.println(count);
        //assertEquals(1L,count);

        Optional<Authorities> optional =  authoritiesRepository.findById(1L);
        System.out.println("나와라" + optional.get().getUser().getUsername());


        // 2.  리스트 조회
        List<Authorities> authorities = authoritiesRepository.findAll();

        System.out.println(authorities);
    }

    @Test
    @Commit
    void testDelete(){

        // 1. User 조회
        Users user   = usersRepository.findById(1L).get();
        System.out.println(user.getUsername());
        //assertEquals(1L,count);

        // 2. User 삭제
        Authorities authorities = Authorities.builder()
                .user(user).id(1L)
                .build();

        authoritiesRepository.delete(authorities);
    }
}