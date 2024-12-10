package com.example.council.data.hub;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Service
public class PythonScriptRunner {

    // Method to run the Python script and return the result
    public static List<Map<String, String>> runPythonScript(String pythonScriptPath) {
        List<Map<String, String>> result = new ArrayList<>();
        try {
            // Define the command to execute the Python script
            String[] command = {"python3", pythonScriptPath};  // Adjust command as needed

            // Create ProcessBuilder object
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Capture the output of the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");  // Capture each line of output
            }

            // Parse the output into a List<Map<String, String>> (assuming your script returns JSON)
            String jsonOutput = output.toString();
            // You would use a library like Gson or Jackson to parse the JSON into your Java object
            // For example:
            // Gson gson = new Gson();
            // result = gson.fromJson(jsonOutput, new TypeToken<List<Map<String, String>>>(){}.getType());

            // Wait for the Python process to finish
            int exitCode = process.waitFor();
            System.out.println("Python script executed with exit code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
