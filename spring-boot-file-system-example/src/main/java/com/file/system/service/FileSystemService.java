package com.file.system.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.system.entity.FileSystem;
import com.file.system.repo.FileSystemRepo;

@Service
public class FileSystemService {

	@Autowired
	private FileSystemRepo repo;
	
	public FileSystem store(MultipartFile file)throws IOException{
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		FileSystem fileSystem=new FileSystem(fileName, file.getContentType(), file.getBytes());
		return repo.save(fileSystem);
	}
		
		public FileSystem getFile(String id) {
			return repo.findById(id).get();
		}
		
		public Stream<FileSystem>getAllFiles(){
			return repo.findAll().stream();
	}
}
