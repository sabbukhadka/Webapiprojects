package com.example.recyclerview;

public class Contacts {
    private String name;
    private  String phoneno;
    private  int imagprofile;

    //constructor
    public Contacts(String name, String phoneno, int imagprofile)
    {
        this.name= name;
        this.phoneno =phoneno;
        this.imagprofile = imagprofile;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public int getImagprofile() {
        return imagprofile;
    }

    public void setImagprofile(int imagprofile) {
        this.imagprofile = imagprofile;
    }




}
