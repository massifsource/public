package com.massifsource.sync.db.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;

import com.massifsource.sync.db.h2.model.Directory;

@Repository
@Transactional(readOnly = true, isolation=Isolation.READ_UNCOMMITTED)
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

}
