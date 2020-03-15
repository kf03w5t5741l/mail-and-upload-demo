package com.qienclass.mailanduploaddemo.service.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import com.qienclass.mailanduploaddemo.domain.UploadedFile;

/* StackAbuse guide to uploading files with Spring Boot:
 * https://stackabuse.com/uploading-files-with-spring-boot/
 */
@Service
@Transactional
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    @Value("${app.upload.dir}")
    private String uploadDir;

    public void storeFile(Path path, MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(),
                path,
                StandardCopyOption.REPLACE_EXISTING);
    }

    public Path save(MultipartFile file) {
        Path uploadLocation = Paths.get(uploadDir
                + File.separator
                + StringUtils.cleanPath(file.getOriginalFilename()));
        UploadedFile uploadedFile = new UploadedFile(uploadLocation.toString());

        try {
            this.storeFile(uploadLocation, file);
            this.fileRepository.save(uploadedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return uploadLocation;
    }

    public Path updateById(Long id, MultipartFile file) {
        UploadedFile fileToUpdate = this.findById(id).get();
        Path fileLocation = Paths.get(fileToUpdate.getPath());

        try {
            this.storeFile(fileLocation, file);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return fileLocation;
    }

    public Optional<UploadedFile> findById(Long id) {
        return this.fileRepository.findById(id);
    }

    public Iterable<UploadedFile> findAll() {
        return this.fileRepository.findAll();
    }

    public void deleteById(Long id) {
        try {
            Files.delete(Paths.get(findById(id).get().getPath()));
            this.fileRepository.deleteById(id);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void deleteAll() {
        for (UploadedFile file : this.findAll()) {
            try {
                Files.delete(Paths.get(file.getPath()));
                this.fileRepository.deleteAll();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
