package com.kodilla.good.patterns.challegnes;

public class EmailInformationService implements InformationService{
    @Override
    public void inform(String user) {
        System.out.println("Email send to: " + user);
    }
}
