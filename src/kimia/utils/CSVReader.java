package kimia.utils;

import kimia.data.CH;
import kimia.data.H;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import kimia.ui.Alert;
import static kimia.utils.Constant.COMMA_REGEX;

public class CSVReader {
    private static String line = "";
    private static BufferedReader csvReader = null;
    private static ClassLoader classLoader;

    public static ArrayList<CH> loadCHData(String filename){
        ArrayList<CH> listCH = new ArrayList<>();
        try{
            classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("raw/" + filename + Constant.EXTENSION_CSV);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            csvReader = new BufferedReader(inputStreamReader);
            while ((line = csvReader.readLine()) != null){
                String[] data = line.split(COMMA_REGEX);
                CH ch = new CH();
                ch.setId(Integer.parseInt(data[0]));
                ch.setData(Double.parseDouble(data[1]));
                ch.setR(data[2]);
                listCH.add(ch);
            }
        } catch (FileNotFoundException | NullPointerException notFound){
            Alert.showDialog("Alert", notFound.getLocalizedMessage());
        } catch (IOException e) {
            Alert.showDialog("Oops!", e.getMessage());
        }
        return listCH;
    }

    public static ArrayList<H> loadHData(String filename){
        ArrayList<H> listH = new ArrayList<>();
        try{
            classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("raw/" + filename + Constant.EXTENSION_CSV);
            InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            csvReader = new BufferedReader(inputStreamReader);
            while ((line = csvReader.readLine()) != null){
                String[] data = line.split(COMMA_REGEX);
                H h = new H();
                h.setId(Integer.parseInt(data[0]));
                h.setCis(Double.parseDouble(data[1]));
                h.setTrans(Double.parseDouble(data[2]));
                h.setGem(Double.parseDouble(data[3]));
                h.setR(data[4]);
                listH.add(h);
            }
        } catch (FileNotFoundException notFound){
            Alert.showDialog("Alert", notFound.getMessage());
        } catch (IOException e) {
            Alert.showDialog("Oops!", e.getMessage());
        }
        return listH;
    }
}
