package br.com.uploader.application;

import br.com.uploader.dao.UploaderDAO;
import br.com.uploader.model.Uploader;

public class Main {
    public static void main(String[] args) {
        UploaderDAO uploaderDao = new UploaderDAO();
        Uploader uploader = new Uploader();

        uploader.setFile("teste");
        uploader.setTypeImg("jpg");
        uploaderDao.saveImage(uploader);

        for(Uploader images : uploaderDao.getImage()){
            System.out.println("Imagens: " + images.getFile());
        }
    }
}
