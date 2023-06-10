package com.subida.archivos.controllers;


import com.subida.archivos.services.IUploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {

    @Autowired
    IUploadFilesService uploadFilesService;

    @PostMapping("/picture")

}
