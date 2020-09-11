package Elements;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private final int symbolNum, valueNum;
    private final char symbol, value;
    private final Image image;
    private String properCard, properSymbol;

    public Card(int symbol, int val) {
        this.symbolNum = symbol;
        this.valueNum = val;

        this.symbol = switch (this.symbolNum) {
            case 0 -> 'H';
            case 1 -> 'D';
            case 2 -> 'S';
            case 3 -> 'C';
            default -> 'n';
        };
        this.value = Integer.toString(this.valueNum).charAt(0);

        image = new Image("file:" + this.value + this.symbol);

        this.setProperSymbol();
        this.setPrintableCard();
    }

    public Card(char symbol, char value) {
        this.symbol = symbol;
        this.value = value;

        this.symbolNum = switch (this.symbol) {
            case 'H' -> 0;
            case 'D' -> 1;
            case 'S' -> 2;
            case 'C' -> 3;
            default -> -1;
        };

        if (Character.isDigit(this.value)) {
            this.valueNum = Integer.parseInt(Character.toString(this.value));
        } else {
            this.valueNum = switch (this.value) {
                case 'J' -> 11;
                case 'Q' -> 12;
                case 'K' -> 13;
                case 'A' -> 14;
                default -> -1;
            };
        }

        image = new Image("file:" + this.value + this.symbol);

        this.setProperSymbol();
        this.setPrintableCard();
    }

    private void setProperSymbol() { // returns the string for the symbol corresponding to given number
        this.properSymbol = switch (this.symbolNum) {
            case 0 -> "Hearts";
            case 1 -> "Diamonds";
            case 2 -> "Spades";
            case 3 -> "Clubs";
            default -> "Invalid";
        };
    }

    public static String numToString(int symbol) {
        return switch (symbol) {
            case 0 -> "Hearts";
            case 1 -> "Diamonds";
            case 2 -> "Spades";
            case 3 -> "Clubs";
            default -> "Invalid";
        };
    }

    public String getProperSymbol() {
        return this.properSymbol;
    }

    private void setPrintableCard() {
        this.properCard = switch (this.valueNum) {
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 -> value + " of ";
            case 11 -> "Jack of ";
            case 12 -> "Queen of ";
            case 13 -> "King of ";
            case 14 -> "Ace of ";
            default -> "Invalid card of ";
        } + switch (this.symbolNum) {
            case 0 -> "Hearts";
            case 1 -> "Diamonds";
            case 2 -> "Spades";
            case 3 -> "Clubs";
            default -> "Invalid";
        };
    }

    public String getProperCard() {
        return this.properCard;
    }


    public int getSymbolNum() {
        return symbolNum;
    }

    public int getValueNum() {
        return valueNum;
    }

    /*public char getSymbol() {
        return symbol;
    }

    public char getValue() {
        return value;
    }*/


    public ImageView getImg() {
        ImageView graphicRep = new ImageView(image);

        graphicRep.setFitHeight(352);
        graphicRep.setFitWidth(230);

        return graphicRep;
    }

    @Override
    public String toString() {
        return Character.toString(this.symbol) + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Card))
            return true;

        Card toCompare = (Card) o;

        return toCompare.getSymbolNum() == this.symbolNum && toCompare.getValueNum() == this.valueNum;
    }
}
