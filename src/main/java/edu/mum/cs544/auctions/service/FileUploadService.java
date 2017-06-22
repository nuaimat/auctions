package edu.mum.cs544.auctions.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/20/17.
 */

@Service
public class FileUploadService implements IFileUploadService {
    private final String UPLOAD_FOLDER = "/tmp/auction_uploads/";
    @Override
    public String upload(MultipartFile file, String destfilename) throws IOException {
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String ext = getFileExtension(file.getOriginalFilename());
            Path path = Paths.get(UPLOAD_FOLDER + destfilename + ext);
            Files.write(path, bytes);

            return destfilename + ext;

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

    }

    @Override
    public String getUploadFolder() {
        return UPLOAD_FOLDER;
    }

    private String getFileExtension(String originalFilename) {
        String[] nameParts = originalFilename.split("\\.");
        return "."+nameParts[nameParts.length - 1].toLowerCase();
    }
}
