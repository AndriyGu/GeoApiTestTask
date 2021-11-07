package com.example.geoApiTest.repository;

import com.example.geoApiTest.model.Account;
import com.example.geoApiTest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findById(int id);

    Account findOneById(int id);

    @Query("Select a from Account a WHERE a.role=?1")
    List<Account> findByRole(Role role);

    @Query("SELECT a FROM Account a WHERE a.email=?1")
    Account findByEmail(String email);
}
