import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;
import java.util.ArrayList;
import java.util.Locale;

public class ROT13  {

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String nocap = alphabet.toLowerCase();
    String newAlpha="";
    ROT13(Character cs, Character cf) {
        newAlpha(cs,cf);
    }

    ROT13()
    {

    }


    public void newAlpha(Character cs, Character cf) {
        int sub = (int) cf - cs;
        if (Character.isUpperCase(cf))
        {
            for (int i = 0; i < alphabet.length(); i++)
            {
                if(newAlpha.length()==26)
                    break;
                int current = (int) alphabet.charAt(i);
                if (current + sub < 91)
                {
                    newAlpha += (char) (current + sub);
                } else {
                    int counter = 0;
                    for (int f = i; f < alphabet.length(); f++) {
                        newAlpha += alphabet.charAt(counter);
                        counter++;
                        if(f==alphabet.length()-1)
                        {
                            break;
                        }
                    }
                }

            }
        }
        else
        {
            newAlphaLower(cs,cf);
        }
    }


    public void newAlphaLower(Character cs,Character cf)
    {
        int sub = (int) cf - cs;
            for (int i = 0; i < nocap.length(); i++)
            {
                if(newAlpha.length()==26)
                    break;
                int current = (int) nocap.charAt(i);
                if (current + sub < 123)
                {
                    newAlpha += (char) (current + sub);
                }
                else
                {
                    int counter = 0;
                    for (int f = i; f < nocap.length(); f++)
                    {
                        newAlpha += nocap.charAt(counter);
                        counter++;
                        if(f==nocap.length()-1)
                        {
                            break;
                        }
                    }
                }

            }
        }


    public String crypt(String text) throws UnsupportedOperationException {

       // abcdefghijklm
    return text;

    }

    public String encrypt(String text) {
        String ret = "";
        for (int i = 0; i < text.length(); i++) {
            char CurrentChar = text.charAt(i);
            int index = alphabet.indexOf(CurrentChar);
            boolean capflag=true;
            if (index == -1) {
                index = nocap.indexOf(CurrentChar);
                capflag=false;
            }
            if (index == -1) {
                ret += text.charAt(i);
            }
            if (index != -1) {
                if(capflag==true)
                {
                    ret += Character.toUpperCase(newAlpha.charAt(index));
                }
                else
                {
                    ret+=newAlpha.charAt(index);
                }

            }

        }
        return ret;
    }


    public String decrypt(String text) {
       return encrypt(text);
    }

    public static String rotate(String s, Character c) {
    String ret="";
    int count =0;
    int index = s.indexOf(c);
    for(int i =index;i<s.length();i++)
    {
        ret+=s.charAt(i);
    }

        while(ret.length()!=s.length())
        {
            ret+=s.charAt(count);
            count++;
        }

return ret;
}}
