package com.onpassive.spring.mongo.api.file;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class FileUploadImpl implements FileUpload {

	@Autowired
	private FileDBRepository fileDBRepository;

	@Override
	@SuppressWarnings("rawtypes")
	public Map<String, String> saveFileByMongoDBStoreForAttachment(MultipartFile[] files) throws IOException {
		Map<String, String> result = null;
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getOriginalFilename();
			System.out.println("fileName " + fileName);

			InputStream is = files[i].getInputStream();
			byte[] data = IOUtils.toByteArray(is);
			String fileType = FilenameUtils.getExtension(fileName);
			System.out.println(fileType);
			LocalDateTime createdTime = LocalDateTime.now();
			String fileAttchmentDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/api/getAttachment").toUriString();
			FileUploadModel omailFileDB = new FileUploadModel(fileName, fileType, data, fileAttchmentDownloadUri,
					createdTime);
			fileDBRepository.save(omailFileDB);

			Optional<FileUploadModel> omailFile = fileDBRepository.findById(omailFileDB.getId());
			result = new HashMap<>();
			result.put(omailFile.get().getName(), omailFile.get().getUrl() + "/" + omailFile.get().getId());
		}
		return result;

	}

	public Optional<FileUploadModel> findById(String id) {

		Optional<FileUploadModel> findById = fileDBRepository.findById(id);
		try {
			if (findById.isPresent()) {
				return findById;
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return findById;

	}

}
