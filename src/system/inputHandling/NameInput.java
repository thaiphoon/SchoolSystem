package system.inputHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

public class NameInput implements InputHandler<String>{

    @Override
    public String handleInput(BufferedReader br) throws IOException, PatternSyntaxException {
        String tmp;
        while(true){
            tmp = br.readLine();
            if(tmp.matches("\\p{Lu}{1}[a-ö]+( \\p{Lu}[a-ö]+)?+")){
                break;
            }
            System.out.println("Enter a valid name");
        }
        return tmp;
    }
}
