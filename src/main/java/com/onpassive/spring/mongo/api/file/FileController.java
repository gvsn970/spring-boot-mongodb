package com.onpassive.spring.mongo.api.file;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	FileUpload fileUpload;
	
	@Autowired
	private FileDBRepository fileDBRepository;



	@PostMapping(value = "/fileuplod", consumes = { "multipart/form-data" })
	public Map<String, String> sendEmail(@RequestParam("file") MultipartFile[] files)
			throws IOException {
		Map<String, String> result = fileUpload.saveFileByMongoDBStoreForAttachment(files);
		return result;
	}
	
	@GetMapping(value = "/getAttachment/{id}")
	public ResponseEntity<?> getAttachment(@PathVariable String id) throws IOException {
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" +fileUpload.findById(id).get().getName() + "\"")
				.body(fileDBRepository.findById(id).get().getData());

	}
//
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
//			@RequestParam("file") MultipartFile file) {
//		if (!file.isEmpty()) {
//			try {
//				gridFsTemplate.store(file.getInputStream(), name, "image/png");
//				return "You successfully uploaded " + name + "!";
//			} catch (Exception e) {
//				return "You failed to upload " + name + " => " + e.getMessage();
//			}
//		} else {
//			return "You failed to upload " + name + " because the file was empty.";
//		}
//	}
}
