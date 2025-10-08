package system.inputHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

public interface InputHandler<T> {

        public T handleInput(BufferedReader br) throws IOException, PatternSyntaxException;
    }
