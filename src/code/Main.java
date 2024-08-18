package code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String path01 = "C:/Users/feralcojam/Documents/"
                + "NetBeansProjects/LexSyntazer/"
                + "src/code/Lexer.flex";
        String path02 = "C:/Users/feralcojam/Documents/"
                + "NetBeansProjects/LexSyntazer/"
                + "src/code/LexerCup.flex";
        String [] paths = {"-parser", "Syntax", "C:/Users/feralcojam/"
                + "Documents/NetBeansProjects/LexSyntazer"
                + "/src/code/Syntax.cup"};
        generate(path01, path02, paths);
    }
    public static void generate(String path01, String path02, String[] paths) throws IOException, Exception {
        File file;
        file = new File(path01);
        JFlex.Main.generate(file);
        file = new File(path02);
        JFlex.Main.generate(file);
        java_cup.Main.main(paths);
        
        Path sym_path = Paths.get("C:/Users/feralcojam/Documents/NetBeansProjects/LexSyntazer/src/code/sym.java");
        if (Files.exists(sym_path)) {
            Files.delete(sym_path);
        }
        
        Files.move(
                Paths.get("C:/Users/feralcojam/Documents/NetBeansProjects/LexSyntazer/sym.java"),
                Paths.get("C:/Users/feralcojam/Documents/NetBeansProjects/LexSyntazer/src/code/sym.java") 
        );
        
        Path syn_path = Paths.get("C:/Users/feralcojam/Documents/NetBeansProjects/LexSyntazer/src/code/Syntax.java");
        if (Files.exists(syn_path)) {
            Files.delete(syn_path);
        }
        
        Files.move(
                Paths.get("C:/Users/feralcojam/Documents/NetBeansProjects/LexSyntazer/Syntax.java"),
                Paths.get("C:/Users/feralcojam/Documents/NetBeansProjects/LexSyntazer/src/code/Syntax.java") 
        );
    }
}
