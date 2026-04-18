package dev.ohate.wynncraft4j.util;

public class TextColor {

    public static int BLACK = 0x000000;
    public static int DARK_BLUE = 0x0000AA;
    public static int DARK_GREEN = 0x00AA00;
    public static int DARK_AQUA = 0x00AAAA;
    public static int DARK_RED = 0xAA0000;
    public static int DARK_PURPLE = 0xAA00AA;
    public static int GOLD = 0xFFAA00;
    public static int GRAY = 0xAAAAAA;
    public static int DARK_GRAY = 0x555555;
    public static int BLUE = 0x5555FF;
    public static int GREEN = 0x55FF55;
    public static int AQUA = 0x55FFFF;
    public static int RED = 0xFF5555;
    public static int LIGHT_PURPLE = 0xFF55FF;
    public static int YELLOW = 0xFFFF55;
    public static int WHITE = 0xFFFFFF;

    public static int parse(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Text color string must not be null or empty");
        }

        value = value.toLowerCase();

        return switch (value) {
            case "black" -> BLACK;
            case "dark-blue" -> DARK_BLUE;
            case "dark-green" -> DARK_GREEN;
            case "dark-aqua" -> DARK_AQUA;
            case "dark-red" -> DARK_RED;
            case "dark-purple" -> DARK_PURPLE;
            case "gold" -> GOLD;
            case "gray" -> GRAY;
            case "dark-gray" -> DARK_GRAY;
            case "blue" -> BLUE;
            case "green" -> GREEN;
            case "aqua" -> AQUA;
            case "red" -> RED;
            case "light-purple" -> LIGHT_PURPLE;
            case "yellow" -> YELLOW;
            case "white" -> WHITE;
            default -> {
                try {
                    if (value.startsWith("#")) {
                        String hex = value.substring(1);
                        if (hex.length() == 3) {
                            hex = String.valueOf(new char[]{
                                    hex.charAt(0), hex.charAt(0),
                                    hex.charAt(1), hex.charAt(1),
                                    hex.charAt(2), hex.charAt(2)
                            });
                        }

                        yield Integer.parseInt(hex, 16);
                    }

                    if (value.startsWith("0x")) {
                        yield Integer.parseInt(value.substring(2), 16);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid text color value: \"" + value + "\"");
                }

                throw new IllegalArgumentException("Unknown text color: \"" + value + "\"");
            }
        };
    }

}
