package vfa.gaunau.practice.presentation.di;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class HeadersInterceptor implements Interceptor {

    private static String TAG = HeadersInterceptor.class.getSimpleName();
    private final String HEADER_KEY_AUTHOR = "authorization";
    private final String HEADER_KEY_LANGUAGE = "accept-language";
    private Storage storage;

    @Inject
    HeadersInterceptor(Storage storage) {
        this.storage = storage;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request origonRequest = chain.request();
        Request.Builder newRequest = origonRequest.newBuilder();

        String token = storage.getToken();
        if (token != null) {
            newRequest.addHeader(HEADER_KEY_AUTHOR, storage.getToken());
        }
        return chain.proceed(newRequest.build());
    }
}
