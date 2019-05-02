package com.atdd.fizzbuzz;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.fail;

public class StepUtilities {
    static int makePutRequest(String content, String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(content);
        out.flush();
        out.close();
        return con.getResponseCode();
    }

    static String getStreamContent(InputStream stream) {
        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    static String runCommand(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        if(!process.isAlive() && process.exitValue() != 0) {
            fail("Command failed " + getStreamContent(process.getErrorStream()));
        }
        return getStreamContent(process.getInputStream());
    }
}
