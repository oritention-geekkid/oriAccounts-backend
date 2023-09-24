package cn.org.oritention.accounts.config;

import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class Config {
    public static boolean canGenNewCard() throws IOException {
        if (!new File("config").exists()) {
            new File("config").mkdir();
        }

        File f = new File("config"+File.separator+"canGenNewCard");

        if (!f.exists()) {
            f.createNewFile();
            try (FileWriter fileWriter = new FileWriter(f)) {
                fileWriter.write('1');
            }
        }

        try (FileReader fileReader = new FileReader(f)) {
            return fileReader.read() == (int)('1');
        }
    }
}
