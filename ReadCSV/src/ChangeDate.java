import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ChangeDate {
	public static void main(String[] args){
		String csvFile = "data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			PrintWriter writer = new PrintWriter("output.csv", "UTF-8");
			while ((line = br.readLine()) != null) {
				String change = "";
				Pattern pattern = Pattern.compile("[0-9]{1}([0-9]{1})?\\/[0-9]{1}([0-9]{1})?\\/[0-9]{4}");
				Matcher matcher = pattern.matcher(line);
				if (matcher.find())
				{
					//System.out.println(matcher.group(0));
					String[] temp = matcher.group(0).split("/");
				    StringBuilder sb = new StringBuilder();
				    sb.append(temp[2]);
				    sb.append('/');
				    sb.append(temp[0]);
				    sb.append('/');
				    sb.append(temp[1]);
				    change = sb.toString();
				    //System.out.println(change);
				}
				line = line.replaceAll("[0-9]{1}([0-9]{1})?\\/[0-9]{1}([0-9]{1})?\\/[0-9]{4}", change);
				System.out.println(line);
				
				
				writer.println(line);
				
			}
			writer.close();
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
	}
}
