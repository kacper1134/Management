package company.parser;

import company.enums.SkinType;

public class SkinParser
{
    public static SkinType strToSkinType(String str)
    {
        str = str.toUpperCase();

        if(str.equals("NATURAL"))
        {
            return SkinType.NATURAL;
        }
        else
        {
            return SkinType.ARTIFICIAL;
        }
    }
}
