package com.kaankaplan;

import java.util.*;

public class App
{

    public static void main( String[] args )
    {
        String inputFilename = "input.csv";

        Set<User> users = CsvFileReader.readCsv(inputFilename);

        XmlFileWriter xmlFileWriter = new XmlFileWriter(users);
        xmlFileWriter.createXmlFile();
    }

}
