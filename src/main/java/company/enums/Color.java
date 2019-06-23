package company.enums;

public enum Color
{
    BLACK("#000000"),WHITE("#FFFFFF"),RED("#FF0000"),GREEN("#008000"),BLUE("#0000FF"),YELLOW("#FFFF00");
    private String Hex;

    Color(String Hex)
    {
        this.Hex = Hex;
    }

    public String getHex()
    {
        return Hex;
    }
}
