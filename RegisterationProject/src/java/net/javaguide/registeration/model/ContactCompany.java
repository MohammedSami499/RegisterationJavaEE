/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javaguide.registeration.model;

/**
 *
 * @author Samy
 */
public enum ContactCompany {
    VODAFONE,
    ORANGE,
    WE,
    ETISALATMISR,
    WRONGENUMBER;
    
    public static ContactCompany getCompanyType(String companyId){
        switch (companyId) {
            case "010":
                return ContactCompany.VODAFONE;
            case "012":
                return ContactCompany.ORANGE;
            case "015":
                return ContactCompany.WE;
            case "011":
                return ContactCompany.ETISALATMISR;
            default:
                return ContactCompany.WRONGENUMBER;
        }
    }
    
}
