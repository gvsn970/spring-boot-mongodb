package com.onpassive.spring.mongo.api.file;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileUpload {
	
	public Map<String, String> saveFileByMongoDBStoreForAttachment(MultipartFile[] files)
			throws IOException;

	public	Optional< FileUploadModel> findById(String id);
}
