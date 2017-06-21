package edu.mum.cs544.auctions.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/20/17.
 */
public interface IFileUploadService {
    String upload(MultipartFile file, String s) throws IOException;
}
