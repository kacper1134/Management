package service.parsers;
import company.enums.SkinType;
import company.parser.SkinParser;
import org.junit.Test;
import org.junit.Assert;

public class SkinTypeParserTest
{
    @Test
    public void testParserSkinTypeNatural()
    {
        //is
        String skinType = "natural";

        //then
        SkinType result = SkinParser.strToSkinType(skinType);

        //expected
        Assert.assertEquals(result,SkinType.NATURAL);
    }
    @Test
    public void testParserSkinTypeArtificial()
    {
        //is
        String skinType = "Artificial";

        //then
        SkinType result = SkinParser.strToSkinType(skinType);

        //expected
        Assert.assertEquals(result,SkinType.ARTIFICIAL);
    }
    @Test
    public void testParserSkinTypeDefault()
    {
        //is
        String skinType = "abc";

        //then
        SkinType result = SkinParser.strToSkinType(skinType);

        //expected
        Assert.assertEquals(result,SkinType.ARTIFICIAL);
    }
}
