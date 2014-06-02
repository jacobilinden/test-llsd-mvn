package com.ll.appbuster;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.FileNotFoundException;
import java.io.IOException;
import uk.ac.stand.llsdj.*;
import java.io.StringWriter;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Hello world!
 *
 */
public class App 
{

    public static LLSD doParse(String doc)
        throws IOException, LLSDException, ParserConfigurationException, SAXException {
        final InputStream inputStream = new ByteArrayInputStream(doc.getBytes("UTF-8"));
        final LLSDParser parser = new LLSDParser();

        return parser.parse(inputStream);
    }

    public static void main(String[] args){
        String TEST_DOCUMENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<llsd>\n<map>\n  <key>region_id</key>\n    <uuid>67153d5b-3659-afb4-8510-adda2c034649</uuid>\n  <key>scale</key>\n    <string>one minute</string>\n  <key>simulator statistics</key>\n  <map>\n    <key>time dilation</key><real>0.9878624</real>\n    <key>sim fps</key><real>44.38898</real>\n    <key>pysics fps</key><real>44.38906</real>\n    <key>agent updates per second</key><real>nan</real>\n    <key>lsl instructions per second</key><real>0</real>\n    <key>total task count</key><real>4</real>\n    <key>active task count</key><real>0</real>\n    <key>active script count</key><real>4</real>\n    <key>main agent count</key><real>0</real>\n    <key>child agent count</key><real>0</real>\n    <key>inbound packets per second</key><real>1.228283</real>\n    <key>outbound packets per second</key><real>1.277508</real>\n    <key>pending downloads</key><real>0</real>\n    <key>pending uploads</key><real>0.0001096525</real>\n    <key>frame ms</key><real>0.7757886</real>\n    <key>net ms</key><real>0.3152919</real>\n    <key>sim other ms</key><real>0.1826937</real>\n    <key>sim physics ms</key><real>0.04323055</real>\n    <key>agent ms</key><real>0.01599029</real>\n    <key>image ms</key><real>0.01865955</real>\n    <key>script ms</key><real>0.1338836</real>\n  </map>\n</map>\n</llsd>";


        //String TEST_DOCUMENT = "<?xml version=\"1.0\"?><llsd></llsd>";

        try{
                try{
                    LLSD result = doParse(TEST_DOCUMENT);
                    HashMap content = (HashMap)result.getContent();
                    System.out.println(content);
                }
                catch(Exception e){
                    System.err.println("Caught Exception: " + e.getMessage());
                }
        }
        catch(Exception e){
            System.err.println("Caught Exception: " + e.getMessage());
        }
    }
}
