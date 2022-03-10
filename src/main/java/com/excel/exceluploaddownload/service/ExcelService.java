package com.excel.exceluploaddownload.service;


import java.io.IOException;
import java.util.List;

import com.excel.exceluploaddownload.helper.ExcelHelper;
import com.excel.exceluploaddownload.model.Tutorial;
import com.excel.exceluploaddownload.repository.TutorialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ExcelService {
  @Autowired
  TutorialRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials =ExcelHelper.excelToTutorials(file.getInputStream());
      repository.saveAll(tutorials);

    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

public List<Tutorial> getAllTutorials() {
    return null;
}
}