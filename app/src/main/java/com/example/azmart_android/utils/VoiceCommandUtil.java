package com.example.azmart_android.utils;

import com.example.azmart_android.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VoiceCommandUtil {

    final String command;
    BottomNavigationView bottomNavigationView;

    public VoiceCommandUtil(String command, BottomNavigationView bottomNavigationView) {
        this.command = command;
        this.bottomNavigationView = bottomNavigationView;
        performCommand(command);
    }

     public void performCommand(String command) {
        switch (command) {
            case "GO TO ORDER": {
                bottomNavigationView.setSelectedItemId(R.id.cartFragment);
                break;
            }
            case "GO TO WISH LIST": {
                bottomNavigationView.setSelectedItemId(R.id.wishlistFragment);
                break;
            }
            default: {
                return;
            }
        }
    }

}
