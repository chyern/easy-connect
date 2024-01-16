package chenyudan.utils;

import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/5/26 13:19
 */
@Slf4j
public class HttpUtil {

    private static final OkHttpClient httpClient = new OkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).callTimeout(30L, TimeUnit.SECONDS).build();

    public static String get(String url, Map<String, Object> params) throws IOException {
        return get(url, params, null);
    }

    public static String get(String url, Map<String, Object> params, Map<String, String> headers) throws IOException {
        String actualUrl = buildUrl(url, params);
        Request.Builder builder = new Request.Builder().url(actualUrl).method("GET", null);
        if (headers != null) {
            headers.forEach(builder::addHeader);
        }
        return getResult(builder);
    }

    public static String postForJson(String url, Map<String, Object> params, Object body) throws IOException {
        return postForJson(url, params, body, null);
    }

    public static String postForJson(String url, Map<String, Object> params, Object body, Map<String, String> headers) throws IOException {
        String actualUrl = buildUrl(url, params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), new GsonBuilder().create().toJson(body));
        Request.Builder builder = new Request.Builder().url(actualUrl).method("POST", requestBody);
        if (headers != null) {
            headers.forEach(builder::addHeader);
        }
        return getResult(builder);
    }

    public static String getResult(Builder builder) throws IOException {
        try (Response response = httpClient.newCall(builder.build()).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("response is not successful");
            }

            ResponseBody responseBody = response.body();
            return responseBody != null ? responseBody.string() : null;
        }
    }

    /**
     * 构建完整请求地址
     *
     * @param url    地址
     * @param params 参数
     */
    public static String buildUrl(String url, Map<String, Object> params) {
        String actualUrl = url;
        if (params != null && !params.isEmpty()) {

            List<String> paramList = params.entrySet().stream()
                    .filter(entry -> entry.getValue() != null)
                    .map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.toList());
            String paramsStr = StringUtils.join(paramList, "&");
            actualUrl = actualUrl + "?" + paramsStr;
        }
        return actualUrl;
    }
}
