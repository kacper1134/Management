package company.parser;

import company.enums.SkinType;

public class SkinParser
{
    private static SkinParser skinParser = null;

    private SkinParser()
    {

    }

    public static SkinParser getInstance()
    {
        if(skinParser == null)
        {
            skinParser = new SkinParser();
        }
        return skinParser;
    }

    public static SkinType strToSkinType(String str)
    {
        str = str.toUpperCase();

        if(str.equals("NATURAL"))
        {
            return SkinType.NATURAL;
        }
        else
        {
            return SkinType.ARTIFICAL;
        }
    }
}
