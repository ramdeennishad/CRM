package com.crmproject.Repository;

import com.crmproject.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository extends JpaRepository<Contact,Long> {


}
