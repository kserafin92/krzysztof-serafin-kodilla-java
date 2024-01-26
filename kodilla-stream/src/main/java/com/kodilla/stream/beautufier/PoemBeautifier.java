package com.kodilla.stream.beautufier;

public class PoemBeautifier {
    public String beautify(String text, PoemDecorator decorator) {
        return decorator.decorate(text);
    }
}
