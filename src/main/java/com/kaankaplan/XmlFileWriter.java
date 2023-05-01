package com.kaankaplan;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class XmlFileWriter {

    private final Set<User> userSet;

    public XmlFileWriter(Set<User> userSet) {
        this.userSet = userSet;
    }

    public void createXmlFile() {
        try{
            Configuration configuration = new Configuration();
            Template template = configuration.getTemplate(Constant.XML_TEMPLATE_FILENAME_LOCATION);

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(Constant.OUTPUT_FILENAME_LOCATION)
            );

            Map<String, Set<User>> userMap = new HashMap<>();
            userMap.put("users", userSet);

            template.process(userMap, writer);

            writer.close();

            System.out.println("XML dosyası oluşturuldu.");
        } catch (IOException e){
            e.printStackTrace();
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
