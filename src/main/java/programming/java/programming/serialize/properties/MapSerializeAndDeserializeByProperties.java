package programming.java.programming.serialize.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapSerializeAndDeserializeByProperties {

    private final static String FILE = "resources/hashCodeToPart.properties";

    public static void main(String[] args) {

        //        writing();

        reading();
    }

    private static void writing() {

        Map<Integer, Integer> hashCodeToPart = new HashMap<Integer, Integer>();
        hashCodeToPart.put(1, 2);
        hashCodeToPart.put(3, 4);

        Properties props = new Properties();
        hashCodeToPart.keySet().stream().forEach(key -> {
            props.put(key.toString(), String.valueOf(hashCodeToPart.get(key)));
        });

        File file = new File(FILE);
        try (OutputStream output = new FileOutputStream(file)) {
            props.store(output, null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void reading() {

        Map<Integer, Integer> hashCodeToPart = new HashMap<Integer, Integer>();

        Properties props = new Properties();
        File file = new File(FILE);
        try (InputStream input = new FileInputStream(file)) {
            props.load(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        props.keySet().forEach(key -> {
            String keyStr = key.toString();
            Integer mapKey = Integer.parseInt(keyStr);
            Integer mapValue = Integer.parseInt(props.get(keyStr).toString());
            hashCodeToPart.put(mapKey, mapValue);
        });

        System.out.println(hashCodeToPart);
    }
}
