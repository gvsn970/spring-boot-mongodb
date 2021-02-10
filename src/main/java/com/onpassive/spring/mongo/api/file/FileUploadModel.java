package com.onpassive.spring.mongo.api.file;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "files")
public class FileUploadModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Field(value = "FILE_NAME")
	private String name;
	@Field(value = "FILE_TYPE")
	private String type;
	
	@Field(value = "FILE_DATA")
	private byte[] data;

	@Field(value = "FILE_URL")
	private String url;

	@Field(value = "CREATED_TIME")
	private LocalDateTime createdTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileUploadModel [id=");
		builder.append(id);
		builder.append(", na"
				+ "me=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", data=");
		builder.append(Arrays.toString(data));
		builder.append(", url=");
		builder.append(url);
		builder.append(", createdTime=");
		builder.append(createdTime);
		builder.append("]");
		return builder.toString();
	}

	public FileUploadModel(String name, String type, byte[] data, String url, LocalDateTime createdTime) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.url = url;
		this.createdTime = createdTime;
	}
	
	

	
}
