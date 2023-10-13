package com.desafios.accounts;

import com.desafios.accounts.model.Account;
import com.desafios.accounts.model.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
public class Utils {

    public static AccountDTO readAcc(String fileName) throws IOException {
        String content = readResource(fileName);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, AccountDTO.class);
    }

    public static String readResource(String resourceName) {
        InputStream stream = Utils.class.getClassLoader().getResourceAsStream(resourceName);
        if (stream == null) {
            throw new RuntimeException("File not found");
        }

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
