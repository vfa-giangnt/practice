package vfa.gaunau.practice.presentation.di;

import com.orhanobut.hawk.Hawk;

import java.util.List;

public class HawkStorage implements Storage {

    // HawkStorage implement cac method dc dinh nghia trong Storage.
    // Hawk luu du lieu theo key-value

    class KEYS {
        final static String DATA_TOKEN = "DATA_TOKEN";
        final static String DATA_PROFILE = "DATA_PROFILE";
    }

    @Override
    public String getToken() {
        return Hawk.get(KEYS.DATA_TOKEN);
    }

    @Override
    public void setToken(String token) {
        Hawk.put(KEYS.DATA_TOKEN, token);
    }



    // ...

}
