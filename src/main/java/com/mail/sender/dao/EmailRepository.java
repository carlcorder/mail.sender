package com.mail.sender.dao;

import com.mail.sender.domain.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email, Long> {

    List<Email> findByToAddress(String toAddress);

}
