package model;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class FolderDiff {
    private static final int MAX_DEPTH = 10;

    public static List<String> scanFolder(File folder, int depth) {
        List<String> results = new ArrayList<>();
        if (depth > MAX_DEPTH || folder == null || !folder.isDirectory()) {
            return results;
        }
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                String sha256 = calculateSHA256(file);
                results.add("File: " + file.getName() + " | Size: " + file.length() + " bytes | SHA-256: " + sha256);
            } else if (file.isDirectory()) {
                results.add("Directory: " + file.getName());
                results.addAll(scanFolder(file, depth + 1)); // Recursive scan
            }
        }
        return results;
    }

    private static String calculateSHA256(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] byteArray = new byte[1024];
            int bytesCount;
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
            byte[] bytes = digest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calculating SHA";
        }
    }
}
