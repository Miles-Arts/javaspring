package com.subida.archivos.services.impl;

import com.subida.archivos.services.IUploadFilesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFilesServiceImpl implements IUploadFilesService {


    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {

        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if (fileSize > maxFileSize) {
                return "File size must be less the or equal 5MB";
            }

            if (
                    !fileOriginalName.endsWith(".jpg") && !fileOriginalName.endsWith(".png") && !fileOriginalName.endsWith(".jpeg")
            ) {
                return "Only JPG, PNG or JPEG files are allowed";
            }

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));

            String newFileName = fileName + fileExtension;

            File folder= new File("src/main/resources/picture");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/picture/" + newFileName);
            Files.write(path, bytes);
            return "File upload success fully!!!";


        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
