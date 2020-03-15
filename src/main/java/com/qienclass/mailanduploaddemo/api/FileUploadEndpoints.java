package com.qienclass.mailanduploaddemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Optional;

import com.qienclass.mailanduploaddemo.domain.UploadedFile;
import com.qienclass.mailanduploaddemo.service.persistence.FileService;

@RestController
@RequestMapping("/api/upload")
public class FileUploadEndpoints {
    @Autowired
    private FileService fileService;

    @GetMapping
    public Iterable<UploadedFile> readAllFiles() {
        return this.fileService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UploadedFile> readFile(@PathVariable Long id) {
        return this.fileService.findById(id);
    }

    @PostMapping
    public String createFile(@RequestBody MultipartFile file) {
        Path filePath = this.fileService.save(file);
        return filePath.toString();
    }

    @PutMapping("/{id}")
    public String updateFile(@PathVariable Long id,
                                   @RequestBody MultipartFile file) {
        Path filePath = this.fileService.updateById(id, file);
        return filePath.toString();
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Long id) {
        this.fileService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        this.fileService.deleteAll();
    }

}
