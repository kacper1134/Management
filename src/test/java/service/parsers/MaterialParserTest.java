package service.parsers;
import company.enums.Material;
import company.parser.MaterialParser;
import org.junit.Test;
import org.junit.Assert;

public class MaterialParserTest
{
    @Test
    public void testMaterialParserLeather()
    {
        //is
        String material = "leather";

        //then
        Material result = MaterialParser.strToMaterial(material);

        //expected
        Assert.assertEquals(result,Material.LEATHER);
    }
    @Test
    public void testMaterialParserFur()
    {
        //is
        String material = "FuR";

        //then
        Material result = MaterialParser.strToMaterial(material);

        //expected
        Assert.assertEquals(result,Material.FUR);
    }
    @Test
    public void testMaterialParserCotton()
    {
        //is
        String material = "CoTTon";

        //then
        Material result = MaterialParser.strToMaterial(material);

        //expected
        Assert.assertEquals(result,Material.COTTON);
    }
    @Test
    public void testMaterialParserWool()
    {
        //is
        String material = "wOOl";

        //then
        Material result = MaterialParser.strToMaterial(material);

        //expected
        Assert.assertEquals(result,Material.WOOL);
    }
    @Test
    public void testMaterialParserPolyesters()
    {
        //is
        String material = "Polyesters";

        //then
        Material result = MaterialParser.strToMaterial(material);

        //expected
        Assert.assertEquals(result,Material.POLYESTERS);
    }
    @Test
    public void testMaterialParserDefault()
    {
        //is
        String material = "Pav";

        //then
        Material result = MaterialParser.strToMaterial(material);

        //expected
        Assert.assertEquals(result,Material.POLYESTERS);
    }
}
