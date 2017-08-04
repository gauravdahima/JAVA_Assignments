/*
 * Write a java function that will ping any host (given as input) and computes 
 * the median of the time taken to ping. 
 * Use the system ping utility, do not use any deprecated methods.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ping{

    public static void main(String[] args) throws  IOException {
        String ip1= "127.0.0.1";
        String ip2 = "google.com";
        
        pingHost(ip1,10);
        pingHost(ip2,15);
    }
    /*
     * This method takes the host name or ip address and an integer representing
     * the number of times to ping. 
     * A system process is created that will ping the host and we are reading the 
     * output of the command and storing it in a string. Later using regex, the 
     * time of the ping is extracted, and stored in an arraylist of double. After 
     * sorting the list the median is printed out according to the number of pings. 
     */
    static void pingHost(String host, int n){
    	String inputLine,pingCommand = "ping "+host;
    	Double median = 0.0;
        int pingCount = 0;
    	ArrayList<Double> list = new ArrayList<Double>();
        try {
            Runtime r = Runtime.getRuntime();
            Process process = r.exec(pingCommand);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (pingCount <= n) {
            	inputLine = in.readLine();
            	Pattern p = Pattern.compile("time=\\d+\\.?\\d+");
            	Matcher m = p.matcher(inputLine);
                if(m.find()){
                	list.add(Double.parseDouble(m.group().substring(5, m.group().length())));
                }
                pingCount++;
            }
            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        Collections.sort(list);
        if(n%2 == 0)
        	median = list.get((n+1)/2);
        else
        	median = (list.get((n)/2) + list.get((n)/2 + 1)) /2.0;
        
        System.out.println("Median of the time taken to ping "+ host +" \'"+n+"\' times is: "+median+" ms");
    }
}