package com.nio.my_parser;

import com.nio.my_parser.Config.MyConfig;
import com.nio.my_parser.Entity.Output;
import com.nio.my_parser.Files.CSV;
import com.nio.my_parser.Files.File;
import com.nio.my_parser.Files.JSON;
import com.nio.my_parser.Parser.Parser;
import com.nio.my_parser.Parser.ParserAll;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        List<File> files = allFiles(args);
        Parser parser = context.getBean("parserAll", ParserAll.class);
        for (File file : files) {
            List<Output> arr = parser.myParse(file);
            for (Output o : arr) {
                System.out.println(o);
            }
        }
    }

    public static List<File> allFiles(String[] files) {
        List<File> f = new ArrayList<>();
        for (String str : files) {


            int csv = str.lastIndexOf(".csv");
            int json = str.lastIndexOf(".json");
            if (csv != -1) {
                f.add(new CSV(str));
            }
            if (json != -1) {
                f.add(new JSON(str));
            }
        }
        return f;
    }
}
