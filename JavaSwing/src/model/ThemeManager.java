package model;

import javax.swing.*;
import java.awt.*;

public class ThemeManager {
    public static void applyDarkTheme() {
        UIManager.put("control", new Color(45, 45, 45));
        UIManager.put("info", new Color(45, 45, 45));
        UIManager.put("nimbusBase", new Color(18, 30, 49));
        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
        UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
        UIManager.put("nimbusFocus", new Color(115, 164, 209));
        UIManager.put("nimbusGreen", new Color(176, 179, 50));
        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
        UIManager.put("nimbusLightBackground", new Color(45, 45, 45));
        UIManager.put("nimbusOrange", new Color(191, 98, 4));
        UIManager.put("nimbusRed", new Color(169, 46, 34));
        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
        UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
        UIManager.put("text", new Color(230, 230, 230));
    }

    public static void applyLightTheme() {
        UIManager.put("control", new Color(214, 217, 223));
        UIManager.put("info", new Color(214, 217, 223));
        UIManager.put("nimbusBase", new Color(51, 98, 140));
        UIManager.put("nimbusAlertYellow", new Color(255, 220, 35));
        UIManager.put("nimbusDisabledText", new Color(142, 143, 145));
        UIManager.put("nimbusFocus", new Color(115, 164, 209));
        UIManager.put("nimbusGreen", new Color(176, 179, 50));
        UIManager.put("nimbusInfoBlue", new Color(47, 92, 180));
        UIManager.put("nimbusLightBackground", new Color(255, 255, 255));
        UIManager.put("nimbusOrange", new Color(191, 98, 4));
        UIManager.put("nimbusRed", new Color(169, 46, 34));
        UIManager.put("nimbusSelectedText", new Color(0, 0, 0));
        UIManager.put("nimbusSelectionBackground", new Color(57, 105, 138));
        UIManager.put("text", new Color(0, 0, 0));
    }
}
