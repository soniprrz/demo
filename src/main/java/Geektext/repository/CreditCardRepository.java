package Geektext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import profilemanagement.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
