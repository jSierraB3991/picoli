package com.jsierrab3991.picocli.springboot.utils;

public class Colors {
    private String textColor;
    private String bgColor;
    private String textString;
    private String coloredString;


    public static final String TEXT_RESET  = "\u001B[0m";
    public static final String TEXT_GREEN  = "\u001B[32m";
    public static final String TEXT_BG_BLACK  = "\u001B[40m";

    public Colors(String textColor, String bgColor, String textString){
        setTextColor(textColor);
        setBgColor(bgColor);
        setTextString(textString);
        this.coloredString = buildColoredString(bgColor, textColor, textString);
    }

    public void setTextColor(String textColor){
        this.textColor = textColor;
        setColoredString(this.textColor, this.bgColor, this.textString);
    }
    public void setBgColor(String bgColor){
        this.bgColor = bgColor;
        setColoredString(this.textColor, this.bgColor, this.textString);
    }
    public void setTextString(String textString){
        this.textString = textString;
        setColoredString(this.textColor, this.bgColor, this.textString);
    }
    public void setColoredString(String textColor, String bgColor, String textString) {
        coloredString = buildColoredString(bgColor, textColor, textString);
    }

    private static String buildColoredString(String bgColor, String textColor, String str){
        String toReturn = "";
        if (bgColor != null) toReturn += bgColor;
        if (textColor != null ) toReturn += textColor;
        return toReturn + str + TEXT_RESET;
    }

    public String getColoredString(){
        return coloredString;
    }

}