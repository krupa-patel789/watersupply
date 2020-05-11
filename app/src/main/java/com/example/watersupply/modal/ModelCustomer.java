package com.example.watersupply.modal;

public class ModelCustomer {

    private  String name,address;
    private int phoneno,cbottle,hbottle,pcbottle,
            phbottle,credit,debit,total;

    public ModelCustomer(String name,String address,int phoneno,int cbottle,int hbottle,int pcbottle,
                         int phbottle,int credit,int debit,int total){

        this.name= name;
        this.address = address;
        this.phoneno = phoneno;
        this.cbottle = cbottle;
        this.hbottle = hbottle;
        this.pcbottle = pcbottle;
        this.phbottle = phbottle;
        this.credit = credit;
        this.debit = debit;
        this.total = total;
    }

    public String getName(){return name;}

    public String getAddress(){return address;}
    public int getPhoneno(){return phoneno;}

    public int getCbottle() {
        return cbottle;
    }

    public int getHbottle() {
        return hbottle;
    }

    public int getPcbottle() {
        return pcbottle;
    }

    public int getPhbottle() {
        return phbottle;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }

    public int getTotal() {
        return total;
    }
}
