package service.parsers;

import company.enums.Color;
import company.parser.ColorParser;
import org.junit.Test;
import org.junit.Assert;

public class ColorParserTest
{
    @Test
    public void testParserColorBlack()
    {
        //is
        String color = "black";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.BLACK);
    }
    @Test
    public void testParserColorWhite()
    {
        //is
        String color = "white";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.WHITE);
    }
    @Test
    public void testParserColorRed()
    {
        //is
        String color = "red";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.RED);
    }
    @Test
    public void testParserColorGreen()
    {
        //is
        String color = "green";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.GREEN);
    }
    @Test
    public void testParserColorBlue()
    {
        //is
        String color = "blue";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.BLUE);
    }
    @Test
    public void testParserColorYellow()
    {
        //is
        String color = "yellow";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.YELLOW);
    }
    @Test
    public void testParserColorDefault()
    {
        //is
        String color = "abc";

        //then
        Color result = ColorParser.strToColor(color);

        //expected
        Assert.assertEquals(result,Color.WHITE);
    }
}
