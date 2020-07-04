package com.moctho.mockthoapi.repository;

import com.moctho.mockthoapi.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<users,Long> {

}
