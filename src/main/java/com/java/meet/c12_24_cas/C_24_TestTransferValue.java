package com.java.meet.c12_24_cas;

public class C_24_TestTransferValue {

    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(C_24_Person person){
        person.setPersonName("XXX");
    }

    public void changeValue3(String str){
        str = "XXX";
    }

    public static void main(String[] args) {
        C_24_TestTransferValue test = new C_24_TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age----"+age);

        C_24_Person person = new C_24_Person(10,"abc");
        test.changeValue2(person);
        System.out.println("personName----"+person.getPersonName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String---" + str);
    }
}
