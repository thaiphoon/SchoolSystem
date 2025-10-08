package system.inputHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

public class SingleIntegerInput implements InputHandler<Integer>{

    @Override
    public Integer handleInput(BufferedReader br) throws IOException, PatternSyntaxException {
        String tmp;

        while(true){
            tmp = br.readLine();
            if(tmp.matches("([0-9]){1,9}") && (Integer.parseInt(tmp) >= 0)){
                break;
            }
            System.out.println("Enter a digit(positive integer)");
        }
        return Integer.parseInt(tmp);
    }
}
