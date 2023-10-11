package week12;

import java.util.*;
import java.util.Map.Entry;

public class q베스트앨범 {
	
	 static class Music {
		 String genre;
		 int play;
		 int num;
		 
		 public Music(String genre, int play, int num) {
			 this.genre = genre;
			 this.play = play;
			 this.num = num;
		 }
	 }
	 
	 public int[] solution(String[] genres, int[] plays) {
	     
		 HashMap<String, Integer> music = new HashMap<>();
		 int [] answer;
		 
		 for(int i = 0; i < genres.length; i++) {
			 //재생수 더하기
			 music.put(genres[i], music.getOrDefault(genres[i], 0)+plays[i]);
		 }
		 
		 ArrayList<String> top_genres = new ArrayList<>();
		 
		 while(!music.isEmpty()) {
			 
			 int max = -1;
			 String top_genre = "";
			 
			 for(Entry<String, Integer> key : music.entrySet()) {
				 int temp = key.getValue();
				 
				 if(temp > max) {
					 max = temp;
					 top_genre = key.getKey();
				 }				 
			 }
			 
			 top_genres.add(top_genre);
			 music.remove(top_genre);
		 }
		 
		 ArrayList<Music> ans = new ArrayList<>();
		 
		 for(String top : top_genres) {
			 
			 ArrayList<Music> list = new ArrayList<>();
			 
			 for(int i = 0; i < genres.length; i++) {
				 if(genres[i].equals(top)) {
					 list.add(new Music(top, plays[i], i));
				 }
			 }
			 
			 Collections.sort(list, (o1, o2) -> o2.play - o1.play);
			 ans.add(list.get(0));
			 
			 if(list.size() > 1) {
				 ans.add(list.get(1));
			 }
			 
		 }
		 
		 answer = new int [ans.size()];
		 
		 for(int i = 0; i < ans.size(); i++) {
			 answer[i] = ans.get(i).num;
		 }
		 
		 return answer;
	 }
}
