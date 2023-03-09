package br.com.uploader.application;

import br.com.uploader.dao.UploaderDAO;
import br.com.uploader.model.Uploader;

public class Main {
    public static void main(String[] args) {
        UploaderDAO uploaderDao = new UploaderDAO();
        Uploader uploader = new Uploader();

        uploader.setFile("teste23");
        uploader.setTypeImg("jpg");
        uploaderDao.saveImage(uploader);

        //PUT, atualizar imagem.
        Uploader updateImage = new Uploader();
        updateImage.setFile("Hello World!");
        updateImage.setTypeImg("jpg");
        updateImage.setId(1);
        uploaderDao.putImage(updateImage);

        uploaderDao.deleteImageById(1);

        for(Uploader images : uploaderDao.getImage()){
            System.out.println("Imagens: " + images.getFile());
        }
    }
}
