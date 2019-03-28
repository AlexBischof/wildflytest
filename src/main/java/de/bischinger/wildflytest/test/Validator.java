package de.bischinger.wildflytest.test;

/**
 * @author Alexander Bischof, BMW
 */
public interface Validator {


    default boolean validate(String s){

        if (s == null){
            return false;
        }

        return validateInternal(s);
    }

    boolean validateInternal(String s);

    public static void main(String[] args) {
        new Validator1().validate("alex");
    }
}

class Validator1 implements Validator{
    @Override
    public boolean validateInternal(final String s) {
        return false;
    }
}
class Validator2 implements Validator{
    @Override
    public boolean validateInternal(final String s) {
        return false;
    }
}

