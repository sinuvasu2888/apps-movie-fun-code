package org.superbiz.moviefun.blobstore;

import org.apache.tika.Tika;
import org.apache.tika.io.IOUtils;
import org.springframework.http.MediaType;

import java.io.*;

import java.util.Optional;


public class FileStore implements BlobStore {



    @Override
    public void put(Blob blob) throws IOException {
        File targetFile = new File(blob.name);

        targetFile.delete();
        targetFile.getParentFile().mkdirs();
        targetFile.createNewFile();

        try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
            IOUtils.copy(blob.inputStream, outputStream);
        }
    }

    @Override
    public Optional<Blob> get(String name) throws IOException {
        File file=new File(name);
        String contentType = new Tika().detect(file);
        FileInputStream fileInputStream = new FileInputStream(file);

        Blob blob = new Blob(name,fileInputStream, contentType);
        return Optional.of(blob);
    }

    @Override
    public void deleteAll() {

    }


}
