package com.nio.my_parser.Entity;

public class Output {

    private int id;
    private double amount;
    private String currency;
    private String comment;
    private String filename;
    private int line;
    private String result;

    public Output(String[] splitText) {
        result="";
        setId(splitText[0]);
        setAmount(splitText[1]);
        setCurrency(splitText[2]);
        setComment(splitText[3]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) {
        try{
            int i =  Integer.parseInt(id);
            this.id = i;
        }catch (Exception e){
            result+="Invalid ID, ";
            this.id = -1;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAmount(String amount) {
        try{
            double i =  Double.parseDouble(amount);
            this.amount = i;
        }catch (Exception e){
            result+="Invalid Amount, ";
            this.amount = -1;
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if(!currency.equals("")) {
            this.currency = currency;
        } else {
            result+="Invalid Currency, ";
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(!comment.equals("")) {
            this.comment = comment;
        } else {
            result+="Invalid Comment, ";
        }
    }

    public void appendResult(String append){
        this.result+=append;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return  "{id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                ", filename='" + filename + '\'' +
                ", line=" + line +
                ", result='" + result + '\'' +
                '}';
    }
}
