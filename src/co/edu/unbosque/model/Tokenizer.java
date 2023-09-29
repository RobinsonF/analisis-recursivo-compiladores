package co.edu.unbosque.model;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tokenizer {

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;

    public Tokenizer() {
        super();
        tokenInfos = new LinkedList<TokenInfo>();
        tokens = new LinkedList<Token>();
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^(" + regex + ")"), token));
    }

    public LinkedList<Token> tokenize(String str) throws LexerException {
        String s = str.trim();
        int totalLength = s.length();
        tokens.clear();
        boolean match = false;

        // Intentar coincidir con la cadena completa como un solo token
        Matcher stringMatcher = Pattern.compile("\"[^\"]*\"").matcher(s);
        if (stringMatcher.find()) {
            match = true;
            String tok = stringMatcher.group().trim();
            s = stringMatcher.replaceFirst("").trim();
            tokens.add(new Token(11, tok, totalLength - s.length())); // Tipo 11 para cadenas
        }

        // Si no coincide con una cadena completa, procesar como antes
        while (!s.equals("")) {
            int remaining = s.length();
            match = false;
            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    s = m.replaceFirst("").trim();
                    tokens.add(new Token(info.token, tok, totalLength - remaining));
                    break;
                }
            }
            if (!match) {
                throw new LexerException("Unexpected character in input: " + s.charAt(0));
            }
        }
        return tokens;
    }
    
    public LinkedList<Token> getTokens() {
        return tokens;
    }
}