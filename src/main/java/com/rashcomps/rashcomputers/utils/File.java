package com.rashcomps.rashcomputers.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type File.
 *
 * @author ntwari egide on 2019-09-20
 * @Version 0.2 <p> The File
 */
public class File {
    private String fileDirectory;

    private String fileName;

    private String fileExtension;

    private String fileBaseName;

    /**
     * Instantiates a new File.
     */
    public File() {

    }

    /**
     * Instantiates a new File.
     *
     * @param fileDirectory the file directory
     * @param fileName      the file name
     * @param fileExtension the file extension
     * @param fileBaseName  the file base name
     */
    public File(
        String fileDirectory, String fileName,
        String fileExtension, String fileBaseName
    ) {
        this.fileDirectory = fileDirectory;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileBaseName = fileBaseName;
    }

    /**
     * Gets file directory.
     *
     * @return the file directory
     */
    public String getFileDirectory() {
        return fileDirectory;
    }

    /**
     * Sets file directory.
     *
     * @param fileDirectory the file directory
     */
    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets file name.
     *
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets file extension.
     *
     * @return the file extension
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * Sets file extension.
     *
     * @param fileExtension the file extension
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * Gets file base name.
     *
     * @return the file base name
     */
    public String getFileBaseName() {
        return fileBaseName;
    }

    /**
     * Sets file base name.
     *
     * @param fileBaseName the file base name
     */
    public void setFileBaseName(String fileBaseName) {
        this.fileBaseName = fileBaseName;
    }

    /**
     * Gets file path.
     *
     * @return the file path
     */
    public Path getFilePath() {
        if (fileName == null || fileDirectory == null) {
            return null;
        }

        return Paths.get(fileDirectory, fileName);
    }
}
