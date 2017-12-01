package constants;

public enum PropertyPrefix
{
    URL("jdbc.url"), PASSWORD("jdbc.password"), USERNAME("jdbc.username"), SCHEMA("jdbc.schema");

    private String prefix;


    PropertyPrefix(String prefix)
    {
        this.prefix = prefix;
    }


    public String getPrefix()
    {
        return prefix;
    }
}