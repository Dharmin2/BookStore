/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.ArrayList;

/**
 *
 * @author navni
 */
public interface Gift {
    Item randomGift(ArrayList<Item> gifts);
    Item randomGift(ArrayList<Item> gifts, String type);
    Item pointToGift(ArrayList<Item> gifts, String itemNo);
    
}
