package api.login.loginapi.cookie;

import java.util.Arrays;
import java.util.Random;

public class RandomCookieValueGenerator {

    protected String text = "0123456789ABCDEFGHIJKLMNOPQRXTUNVXYZ";
    private final String[] texts = text.split("");
    public String generate(){
        Random random = new Random();

        String[] result = new String[10];
        for (int i = 0; i < 10; i++) {
            result[i]=texts[random.nextInt(texts.length)];
        }

        return Arrays.toString(result);
    }

}
