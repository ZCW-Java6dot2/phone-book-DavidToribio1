package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;

import static java.util.Arrays.*;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {

        phonebook = new LinkedHashMap<String, List<String>>();

    }

    public void add(String name, String phoneNumber) {
            List<String> allNumbers = new ArrayList<>();
            allNumbers.add(phoneNumber);
            phonebook.replace(name, allNumbers);
            phonebook.put(name,allNumbers);

    }


    public void addAll(String name, String... phoneNumbers) {

        phonebook.put(name, Arrays.asList(phoneNumbers));
        }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {

        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {

        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> allNumbers = phonebook.keySet();
        for (String g : allNumbers){
            List<String> values = phonebook.get(g);
            if (values.contains(phoneNumber)){
                return g;
            }
        }
        return "";
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<String>();
        for(String names: phonebook.keySet()){
            contactNames.add(names);
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
