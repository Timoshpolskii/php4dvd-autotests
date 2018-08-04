package testData;

import helper.PropertiesReader;
import org.testng.annotations.DataProvider;

import java.util.Properties;

public class MovieInfoDataProvider {
    private String MOVIE_INFO_FILEPATH = "/src/test/resources/fixtures/movie_info.properties";
    private Properties properties = PropertiesReader.readFromFile(MOVIE_INFO_FILEPATH);

    @DataProvider(name = "correct_movie")
    public Object[][] adminData() {
        return new Object[][]{{properties}};
    }
}
