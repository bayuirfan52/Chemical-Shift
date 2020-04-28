package kimia.lib;


import kimia.data.CH;
import kimia.data.Error;
import kimia.data.H;
import kimia.utils.Constant;
import kimia.utils.Log;

import java.util.ArrayList;

/**
 * Main predict library on this application
 * @author BAYU IRFAN
 */
public class Library {
    private final LibraryView view;
    public Library(LibraryView libraryView){
        this.view = libraryView;
    }
    
    /**
     * Predict CH2 group
     * @param input
     * @param data
     * @return ArrayList
     */
    public ArrayList<CH> predictCH2(double input, ArrayList<CH> data){
        ArrayList<CH> output = new ArrayList<>();
        ArrayList<Error> errors = new ArrayList<>();
        double currentError = 0;
        boolean firstStart = true;
        view.updateProgressCH(0);
        for (int i = 0; i < data.size(); i++) {
            int j = 0;
            while (j < data.size()) {
                double err = Math.abs(input - Constant.CH2 - data.get(i).getData() - data.get(j).getData());
                Error foundErrorData = new Error();

                if (currentError != err) {
                    if (firstStart) {
                        currentError = err;
                        foundErrorData.setError(err);
                        foundErrorData.setIdR1(data.get(i).getId());
                        foundErrorData.setIdR2(data.get(j).getId());
                        foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId());
                        errors.add(foundErrorData);
                        firstStart = false;
                    } else if (err < currentError) {
                        Log.i("NEW_DATA", "new error = " + err + ", id = " + data.get(i).getId() + "," + data.get(j).getId());
                        foundErrorData.setError(err);
                        foundErrorData.setIdR1(data.get(i).getId());
                        foundErrorData.setIdR2(data.get(j).getId());
                        foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId());
                        errors.clear();
                        errors.add(foundErrorData);
                        currentError = err;
                    }
                } else {
                    if (!isHasDuplicate(errors, data.get(i).getId() + data.get(j).getId())) {
                        Log.i("ADD_DATA", "add error = " + err + ", id = " + data.get(i).getId() + "," + data.get(j).getId());
                        foundErrorData.setError(err);
                        foundErrorData.setIdR1(data.get(i).getId());
                        foundErrorData.setIdR2(data.get(j).getId());
                        foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId());
                        errors.add(foundErrorData);
                    }
                }
                j++;
                view.updateProgressCH(100 * i / data.size());
            }
        }

        errors.forEach((error) -> {
            CH ch = new CH();
            StringBuilder allR = new StringBuilder();

            data.stream().map((dataCH) -> {
                if (error.getIdR1() == dataCH.getId()) {
                    allR.append(" - ").append(toBoldString(dataCH.getR()));
                }
                return dataCH;
            }).filter((dataCH) -> (error.getIdR2() == dataCH.getId())).forEachOrdered((dataCH) -> {
                allR.append(" - ").append(toBoldString(dataCH.getR()));
            });
            ch.setData(error.getError());
            ch.setR(allR.toString());
            Log.i("DATA_FOUND", "data found = " + error.getError() + ", value = CH2" + allR.toString());
            output.add(ch);
        });
        
        view.progressCHOnCompleteListener();
        return output;
    }
    
    /**
     * Predict CH group
     * @param input
     * @param data
     * @return ArrayList
     */
    public ArrayList<CH> predictCH(double input, ArrayList<CH> data){
        ArrayList<CH> output = new ArrayList<>();
        ArrayList<Error> errors = new ArrayList<>();
        double currentError = 0;
        boolean firstStart = true;
        view.updateProgressCH(0);
        for (int i = 0; i < data.size(); i++){
            for (int j = 0; j < data.size(); j++){
                int k = 0;
                while (k < data.size()) {
                    double err = Math.abs(input - Constant.CH - data.get(i).getData() - data.get(j).getData() - data.get(k).getData());
                    Error foundErrorData = new Error();
                    if (currentError != err){
                        if (firstStart) {
                            currentError = err;
                            foundErrorData.setError(err);
                            foundErrorData.setIdR1(data.get(i).getId());
                            foundErrorData.setIdR2(data.get(j).getId());
                            foundErrorData.setIdR3(data.get(k).getId());
                            foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId() + data.get(k).getId());
                            errors.add(foundErrorData);
                            firstStart = false;
                        } else if (err < currentError){
                            Log.i("NEW_DATA", "new error = " + err + ", id = " + data.get(i).getId() + "," + data.get(j).getId() + "," + data.get(k).getId());
                            foundErrorData.setError(err);
                            foundErrorData.setIdR1(data.get(i).getId());
                            foundErrorData.setIdR2(data.get(j).getId());
                            foundErrorData.setIdR3(data.get(k).getId());
                            foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId() + data.get(k).getId());
                            errors.clear();
                            errors.add(foundErrorData);
                            currentError = err;
                        }
                    } else {
                        if (!isHasDuplicate(errors, data.get(i).getId() + data.get(j).getId() + data.get(k).getId())) {
                            Log.i("ADD_DATA", "add error = " + err + ", id = " + data.get(i).getId() + "," + data.get(j).getId() + "," + data.get(k).getId());
                            foundErrorData.setError(err);
                            foundErrorData.setIdR1(data.get(i).getId());
                            foundErrorData.setIdR2(data.get(j).getId());
                            foundErrorData.setIdR3(data.get(k).getId());
                            foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId() + data.get(k).getId());
                            errors.add(foundErrorData);
                        }
                    }
                    k++;
                }
            }
            view.updateProgressCH(100 * i / data.size());
        }

        errors.forEach((error) -> {
            CH ch = new CH();
            StringBuilder allR = new StringBuilder();
            data.stream().map((dataCH) -> {
                if (error.getIdR1() == dataCH.getId()) allR.append(" - ").append(toBoldString(dataCH.getR()));
                return dataCH;
            }).map((dataCH) -> {
                if (error.getIdR2() == dataCH.getId()) allR.append(" - ").append(toBoldString(dataCH.getR()));
                return dataCH;
            }).filter((dataCH) -> (error.getIdR3() == dataCH.getId())).forEachOrdered((dataCH) -> {
                allR.append(" - ").append(toBoldString(dataCH.getR()));
            });

            ch.setData(error.getError());
            ch.setR(allR.toString());
            Log.i("DATA_FOUND", "data found = " + error.getError() + ", value = CH2" + allR.toString());
            output.add(ch);
        });
            
        view.progressCHOnCompleteListener();
        return output;
    }

    /**
     * Predict H group
     * @param input
     * @param data
     * @return ArrayList
     */
    public ArrayList<H> predictCisTransGem(double input, ArrayList<H> data){
        ArrayList<H> output = new ArrayList<>();
        ArrayList<Error> errors = new ArrayList<>();
        double currentError = 0;
        boolean firstStart = true;
        for (int i = 0; i < data.size(); i++){
            for (int j = 0; j < data.size(); j++){
                int k = 0;
                while (k < data.size()) {
                    double err = Math.abs(input - Constant.H - data.get(i).getCis() - data.get(j).getGem() - data.get(k).getTrans());
                    Error foundErrorData = new Error();
                    if (currentError != err){
                        if (firstStart) {
                            firstStart = false;
                            currentError = err;
                            foundErrorData.setError(err);
                            foundErrorData.setIdR1(data.get(i).getId());
                            foundErrorData.setIdR2(data.get(j).getId());
                            foundErrorData.setIdR3(data.get(k).getId());
                            foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId() + data.get(k).getId());
                            errors.add(foundErrorData);
                        } else if (err < currentError){
                            Log.i("NEW_DATA", "new error = " + err + ", id = " + data.get(i).getId() + "," + data.get(j).getId() + "," + data.get(k).getId());
                            foundErrorData.setError(err);
                            foundErrorData.setIdR1(data.get(i).getId());
                            foundErrorData.setIdR2(data.get(j).getId());
                            foundErrorData.setIdR3(data.get(k).getId());
                            foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId() + data.get(k).getId());
                            errors.clear();
                            errors.add(foundErrorData);
                            currentError = err;
                        }
                    } else {
                        if (!isHasDuplicate(errors, data.get(i).getId() + data.get(j).getId() + data.get(k).getId())){
                            Log.i("ADD_DATA", "add error = " + err + ", id = " + data.get(i).getId() + "," + data.get(j).getId() + "," + data.get(k).getId());
                            foundErrorData.setError(err);
                            foundErrorData.setIdR1(data.get(i).getId());
                            foundErrorData.setIdR2(data.get(j).getId());
                            foundErrorData.setIdR3(data.get(k).getId());
                            foundErrorData.setTotalCountId(data.get(i).getId() + data.get(j).getId() + data.get(k).getId());
                            errors.add(foundErrorData);
                        }
                    }
                    k++;
                }
            }

            view.updateProgressH(100 * i / data.size());
        }

        errors.forEach((Error error) -> {
            H h = new H();
            StringBuilder allR = new StringBuilder();
            data.stream().map((dataH) -> {
                if (error.getIdR1() == dataH.getId()) allR.append(" - ").append(toBoldString(dataH.getR()));
                return dataH;
            }).map((dataH) -> {
                if (error.getIdR2() == dataH.getId()) allR.append(" - ").append(toBoldString(dataH.getR()));
                return dataH;
            }).filter((dataH) -> (error.getIdR3() == dataH.getId())).forEachOrdered((dataH) -> {
                allR.append(" - ").append(toBoldString(dataH.getR()));
            });
            
            h.setR(allR.toString());
            Log.i("DATA_FOUND", "data found = " + error.getError() + ", value = H" + allR.toString());
            output.add(h);
        });
            
        view.progressHOnCompleteListener();
        return output;
    }
    
    /**
     * Check duplicate member on Array
     * @param e
     * @param currentTotal
     * @return 
     */
    private static boolean isHasDuplicate(ArrayList<Error> e, int currentTotal){
        boolean value = false;
        for(Error err : e){
            if (err.getTotalCountId() == currentTotal){
                value =  true;
                break;
            }
        }
        return value;
    }
    
    private static String toBoldString(String input){
        return "<b>" + input + "</b>";
    }
}