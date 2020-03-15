package com.qienclass.mailanduploaddemo.service.persistence;

import com.qienclass.mailanduploaddemo.domain.UploadedFile;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository
        extends CrudRepository<UploadedFile, Long> {
}
