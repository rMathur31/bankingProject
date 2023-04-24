package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Customer;

public interface AccountRepository extends JpaRepository<Account, String> {

}
