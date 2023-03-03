package pl.kurs.exchangerateapponspring.config;

public interface AppConfig {
    //https://api.fastforex.io/fetch-all?from=EUR&api_key=51c632107c-9a87ee79b8-rje1zh

    String EXCHANGERATESAPI_PAGE = "https://api.fastforex.io";
    String PAGE_ENDPOINT = "/fetch-all?from=";
    String PRIVATE_API_KEY = "&api_key=560661bc8b-09d20e6814-rqlko1";
}
