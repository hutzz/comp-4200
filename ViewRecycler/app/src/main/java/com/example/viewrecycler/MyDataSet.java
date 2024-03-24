package com.example.viewrecycler;

public class MyDataSet {
    public String text;
    public int image;
    public String btnText;
    public MyDataSet(String text, int image, String btnText){
        this.text = text;
        this.image = image;
        this.btnText = btnText;
    }

    public int getImage(){
        return  image;
    }
    public String getText(){
        return text;
    }
    public String getBtnText() { return btnText; }
}
