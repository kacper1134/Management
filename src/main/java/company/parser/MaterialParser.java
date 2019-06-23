package company.parser;

import company.enums.Material;

public class MaterialParser
{

    public static Material strToMaterial(String str)
    {
        str = str.toUpperCase();

        if(str.equals("LEATHER"))
        {
            return Material.LEATHER;
        }
        else if(str.equals("FUR"))
        {
            return Material.FUR;
        }
        else if(str.equals("COTTON"))
        {
            return Material.COTTON;
        }
        else if(str.equals("WOOL"))
        {
            return Material.WOOL;
        }
        else if(str.equals("POLYESTERS"))
        {
            return Material.POLYESTERS;
        }
        else
        {
            return Material.POLYESTERS;
        }
    }
}
