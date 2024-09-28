package me.babaki.seed.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.babaki.seed.domain.Picture;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ProblemReader {

    private final ObjectMapper objectMapper;

    public ProblemReader() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public Optional<Picture> readFromJson(String filePath) {
        File inputFile = new File(filePath);
        try {
            inputFile.canRead();
            return Optional.of(objectMapper.readValue(inputFile, Picture.class));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
