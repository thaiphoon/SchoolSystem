package system.inputHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

public class PersonIdInput implements InputHandler<String>{

    @Override
    public String handleInput(BufferedReader br) throws IOException, PatternSyntaxException {
        String tmp;
        while(true){
            tmp = br.readLine();
            if(tmp.matches("([0-9]{10})|([0-9]{6}-[0-9]{4})")){
                break;
            }
            System.out.println("Enter a valid personalId");
        }
        return tmp.replaceAll("-", "");
    }
}
