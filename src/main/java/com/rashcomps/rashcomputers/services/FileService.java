package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.utils.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

/**
 * The type File service.
 *
 * @author ntwari on 2019-09-20
 * @Version 0.2  <p> The FileService
 */
@Service
public class FileService {


    /**
     * Gets file extension.
     *
     * @param fileName the file name
     * @return the file extension
     */
    String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if(dotIndex < 0) {
            return null;
        }
        return fileName.substring(dotIndex+1);
    }



    /**
     * Handle file name string.
     *
     * @param fileName        the file name
     * @param uploadDirectory the upload directory
     * @return the string
     * @throws InvalidFileException the invalid file exception
     */
    String handleFileName(String fileName, String uploadDirectory, String id) {

        String cleanFileName = fileName.replaceAll("[^A-Za-z0-9.()]", "");
        String extension = getFileExtension(cleanFileName);



        String base = "profile-"+id;

            cleanFileName = base+"."+extension;

        return cleanFileName;
    }

    String handleDocumentName(String fileName, String id) {

        String cleanFileName = fileName.replaceAll("[^A-Za-z0-9.()]", "");
        String extension = getFileExtension(cleanFileName);



        String base = "profile-"+id;

        cleanFileName = base+"."+extension;

        return cleanFileName;
    }

    /**
     * Upload file file.
     *
     * @param file            the file
     * @param uploadDirectory the upload directory
     * @return the file
     * @throws IOException          the io exception
     */
    public File uploadFile(MultipartFile file, String uploadDirectory, String id)
        throws IOException {
        String fileName = handleFileName(file.getOriginalFilename(), uploadDirectory, id);
        Path path = Paths.get(uploadDirectory, fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        String extension = getFileExtension(fileName);
        String fileBaseName = fileName.substring(
            0,
            fileName.length()-extension.length()-1
        );
        return new File(uploadDirectory, fileName, extension, fileBaseName);
    }

    public String createRandomFileName(){

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";


        StringBuilder sb = new StringBuilder();


        Random random = new Random();

        int length = 7;

        for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();

        return randomString;
    }

//    public UploadDocResponse uploadUserProfile(MultipartFile file, String uploadDirectory)
//            throws IOException {
//        String fileName = handleDocumentName(file.getOriginalFilename(), createRandomFileName());
//
//        Path path = Paths.get(uploadDirectory, fileName);
//
//        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//
//        String extension = getFileExtension(fileName);
//
//        String fileBaseName = fileName.substring(
//                0,
//                fileName.length()-extension.length()-1
//        );
//
//        return new UploadDocResponse(file.getOriginalFilename(), fileName, file.getContentType(), file.getSize());
//
//    }

}
