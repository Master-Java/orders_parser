package com.nio.my_parser.Parser;

import com.nio.my_parser.Entity.Output;
import com.nio.my_parser.Files.File;

import java.util.List;

public interface Parser {
    public List<Output> myParse(File file);
}
