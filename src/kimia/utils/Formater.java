package kimia.utils;

import kimia.data.Error;

import java.util.ArrayList;
import java.util.Collections;

public class Formater {
    private ArrayList<Error> listError;

    public Formater(){}

    public Formater(ArrayList<Error> listError){
        this.listError = listError;
    }

    public ArrayList<Error> sorterErrorResult(){
        Collections.sort(listError);
        return listError;
    }
}