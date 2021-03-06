package ca.ucalgary.soar.omnilog;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Record {
    private FileOutputStream fOut;
    private OutputStreamWriter myOutWriter;

    // With help from https://stackoverflow.com/questions/35481924/write-a-string-to-a-file
    Record(String fileName) {
        // Get the directory for the user's public pictures directory.
        System.out.println("Hello");
        final File path = Environment.getExternalStoragePublicDirectory("/OmniLog");

        // Make sure the path directory exists.
        if(!path.exists())
        {
            // Make it, if it doesn't exit
            if (!path.mkdirs()) {
                Log.e("Exception", "Directory not created");
            }
        }


        final File file = new File(path, fileName + ".txt");

        try
        {
            fOut = new FileOutputStream(file);
            myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append("# File initialised at: " + "\n# \n# Column Name (Units):" + "\n\n");

            fOut.flush();
        }
        catch (IOException e)
        {
            Log.e("Exception", "File init failed: " + e.toString());
        }
    }
    public void writeToFile(String[] sensors) {
        String sensorString = "";

        for (String sensor : sensors) {
            sensorString += (sensor + "|");
        }

        try {
            myOutWriter.append(sensorString);
            fOut.flush();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        testWrite(sensorString);
    }


    public void writeToFile(float[] data) {
        String dataString = "";

        for (float dataPoint:data) {
            dataString += (dataPoint + "|");
        }

        try {
            myOutWriter.append(dataString);
            fOut.flush();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        testWrite(dataString);
    }

    public void closeFile() {
        try
        {
            myOutWriter.close();
            fOut.close();
        }
        catch (IOException e)
        {
            Log.e("Exception", "File closure failed: " + e.toString());
        }

    }

    private void testWrite(String s) {
        Log.d("Written", s);
    }
}
