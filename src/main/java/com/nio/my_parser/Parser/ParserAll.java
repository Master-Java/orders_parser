package com.nio.my_parser.Parser;

import com.nio.my_parser.Files.CSV;
import com.nio.my_parser.Entity.Output;
import com.nio.my_parser.Files.File;
import com.nio.my_parser.Files.JSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParserAll implements Parser {

    public List<Output> myParseCSV(CSV csv) {
        List<Output> allOutPut = new ArrayList<>();
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(Paths.get("D://Example/" + csv.getFilePath()));
            for (String fileLine : fileLines) {
                String[] splitText = fileLine.split(",");
                Output output = new Output(splitText);
                allOutPut.add(output);
                output.setLine(allOutPut.size());
                output.setFilename(csv.getFilePath());
                if (output.getResult().equals("")) {
                    output.setResult("OK");
                } else {
                    output.appendResult("FALSE");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allOutPut;
    }

    public List<Output> myParseJSON(JSON json) {
        List<Output> allOutPut = new ArrayList<>();
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(Paths.get("D://Example/" + json.getFilePath()));
            org.json.simple.parser.JSONParser parser = new JSONParser();
            for (String fileLine : fileLines) {
                JSONObject jsonObject = (JSONObject) parser.parse(fileLine);
                String[] allArgs = new String[4];
                allArgs[0] = jsonObject.get("orderId").toString();
                allArgs[1] = jsonObject.get("amount").toString();
                allArgs[2] = (String) jsonObject.get("currency");
                allArgs[3] = (String) jsonObject.get("comment");
                Output output = new Output(allArgs);
                allOutPut.add(output);
                output.setLine(allOutPut.size());
                output.setFilename(json.getFilePath());
                if (output.getResult().equals("")) {
                    output.setResult("OK");
                } else {
                    output.appendResult("FALSE");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allOutPut;
    }

    @Override
    public List<Output> myParse(File file) {
        if (file instanceof CSV) {
            return myParseCSV((CSV) file);
        }
        if (file instanceof JSON) {
            return myParseJSON((JSON) file);
        }
        return null;
    }
}
