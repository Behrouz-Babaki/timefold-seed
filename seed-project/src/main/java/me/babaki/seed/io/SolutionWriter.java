package me.babaki.seed.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.babaki.seed.domain.Picture;

import java.io.File;
import java.io.IOException;

public class SolutionWriter {

    private final ObjectMapper objectMapper;

    public SolutionWriter() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public void writeToJson(Picture solution, String filePath) {
        // Write the data to a JSON file
        File outputFile = new File(filePath);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
