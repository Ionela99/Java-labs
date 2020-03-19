package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
        private String id;
        private String name;
        private String location; //file name or Web page

        private Map<String, Object> tags = new HashMap<>();

    public Document(String java1, String s, String s1) {

    }

    //…
        public void addTag(String key, Object obj) {
            tags.put(key, obj);
        }
//…
    }


