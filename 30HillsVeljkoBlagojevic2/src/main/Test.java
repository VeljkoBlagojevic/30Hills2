package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.stream.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;

import person.Person;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectMapper objectMapper = new ObjectMapper();
		File database = new File(".//database//data.json");

		try {
			JsonNode jsonNode = objectMapper.readTree(database);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONParser jsonParser = new JSONParser();
		try {

			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(database));
			
			Person[] persons = new Person[20];
			
			//Initializing each person
			for (int i = 0; i < persons.length; i++) {
				persons[i] = new Person();
			}
			int personsCounter = 0;
			
			//Creating iterator that will go through database (which is JSONArray)
			Iterator<JSONObject> iterator = jsonArray.iterator();
			
			//going through database and setting each ones first name
			while (iterator.hasNext()) {
				persons[personsCounter++].setFirstName((String) iterator.next().get("firstName"));
			}
			
			
			//going through database and setting each ones surname
			iterator = jsonArray.iterator();
			personsCounter = 0;
			while (iterator.hasNext()) {
				persons[personsCounter++].setSurname((String) iterator.next().get("surname"));
			}

			
			//going through database and setting each ones age (null for primitive type in Java is a problem
			//and simple if would not help because of iterator constantly moving with each call)
			iterator = jsonArray.iterator();
			personsCounter = 0;
			while (iterator.hasNext()) {
				long age = 0;
				try {
					age = (long) iterator.next().get("age");
				} catch (Exception e) {
				}
				persons[personsCounter++].setAge(age);
			}
			

			//going through database and setting each ones id
			iterator = jsonArray.iterator();
			personsCounter = 0;
			while (iterator.hasNext()) {
				persons[personsCounter++].setId((long) iterator.next().get("id"));
			}
			
			
			//going through database and setting each ones id
			iterator = jsonArray.iterator();
			personsCounter = 0;
			while (iterator.hasNext()) {
				persons[personsCounter++].setGender((String) iterator.next().get("gender"));
			}
			
			//this one was a challenge...
			iterator = jsonArray.iterator();
			personsCounter = 0;
			JSONArray[] jsa = new JSONArray[20];
			int counter = 0;
			while (iterator.hasNext()) {
				jsa[counter++] = (JSONArray) iterator.next().get("friends");
			}
			
			long[][] friendList = new long[20][10];
			for (int i = 0; i < jsa.length; i++) {
				Object[] ls = jsa[i].toArray();
				for (int j = 0; j < ls.length && (long)ls[j]!=0; j++)
					friendList[i][j] = (long) ls[j];
			}
			
			for (int i = 0; i < persons.length; i++) {
				persons[i].setFriends(friendList[i]);
			}
			
			
			
			
			//printing all persons (just to check if everything's fine)
			for (int i = 0; i < persons.length; i++) {
				persons[i].print();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
