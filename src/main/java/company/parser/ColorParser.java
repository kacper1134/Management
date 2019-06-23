package company.parser;

import company.enums.Color;

public class ColorParser
{
    public static Color strToColor(String str)
    {
        str = str.toUpperCase();

        if(str.equals("BLACK"))
        {
            return Color.BLACK;
        }
        else if(str.equals("WHITE"))
        {
            return Color.WHITE;
        }
        else if(str.equals("RED"))
        {
            return Color.RED;
        }
        else if(str.equals("GREEN"))
        {
            return Color.GREEN;
        }
        else if(str.equals("BLUE"))
        {
            return Color.BLUE;
        }
        else if(str.equals("YELLOW"))
        {
            return Color.YELLOW;
        }
        else
        {
            return Color.WHITE;
        }
    }
}
