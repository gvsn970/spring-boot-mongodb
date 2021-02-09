package com.onpassive.spring.mongo.api.file;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends MongoRepository<FileUploadModel, String> {
	
}
