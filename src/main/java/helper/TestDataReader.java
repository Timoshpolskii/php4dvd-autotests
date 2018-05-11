package helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestDataReader<T> {
    private String filePath;
    private Gson gson;
    private Class<T> testDataClass;

    public TestDataReader(String filePath, Class<T> testDataClass) {
        this.filePath = filePath;
        this.testDataClass = testDataClass;
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public T read() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(filePath));
        return gson.fromJson(reader, testDataClass);
    }

}
