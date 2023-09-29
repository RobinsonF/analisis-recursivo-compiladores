package co.edu.unbosque.model;

public class Token implements Cloneable {
    private int type; // El atributo que almacena el tipo de token
    private String lexeme;
    private int position;
    
    public Token(int type, String lexeme, int position) {
        this.type = type;
        this.lexeme = lexeme;
        this.position = position;
    }
    
    // Getters para los atributos
    public int getType() {
        return type;
    }
    
    public String getLexeme() {
        return lexeme;
    }
    
    public int getPosition() {
        return position;
    }

    // Sobrescribe el método clone() y cambia su visibilidad a public
    @Override
    public Token clone() {
        return new Token(this.type, this.lexeme, this.position);
    }
}
