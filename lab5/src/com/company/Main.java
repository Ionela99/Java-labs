package com.company;

import javax.management.PersistentMBean;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Java Resources", "d:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        com.company.CatalogUtil.save(catalog);
    }

    private void testLoadView() {
        Catalog catalog = com.company.CatalogUtil.load("d:/java/catalog.ser");
        Document doc = catalog.findById("java1");
        com.company.CatalogUtil.view(doc);
    }
}