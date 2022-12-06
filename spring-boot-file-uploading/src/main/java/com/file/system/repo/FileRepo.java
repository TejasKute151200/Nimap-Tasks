package com.file.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.file.system.entity.FileSystem;

@Repository
public interface FileRepo extends JpaRepository<FileSystem, String>{

}
