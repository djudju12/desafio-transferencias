package com.desafios.user;

import com.desafios.user.model.User;
import com.desafios.user.model.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static UserDTO readUser(String filePath) throws JsonProcessingException {
        System.out.println(filePath);
        InputStream stream = Utils.class.getClassLoader().getResourceAsStream(filePath);
        if (stream == null) {
            throw new RuntimeException("File not found");
        }
        String content = readStream(stream);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, UserDTO.class);
    }

    private static String readStream(InputStream stream) {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
